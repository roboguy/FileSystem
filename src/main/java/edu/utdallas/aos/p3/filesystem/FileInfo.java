package edu.utdallas.aos.p3.filesystem;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class FileInfo {
	private Integer versionNumber;
	private Integer replicasUpdated;
	private Boolean isReadLocked;
	private Boolean isWriteLocked;
	private Boolean isQuorumAcquired;
	private ReentrantReadWriteLock readWriteLock;
	private Map<String, P> consentObtained_P;
	private Map<String, Q> quorum_Q;
	private Integer max_VN_M;
	private Integer N;

	public Integer getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(Integer versionNumber) {
		this.versionNumber = versionNumber;
	}

	public Integer getReplicasUpdated() {
		return replicasUpdated;
	}

	public void setReplicasUpdated(Integer replicasUpdated) {
		this.replicasUpdated = replicasUpdated;
	}

	public Boolean getIsReadLocked() {
		return isReadLocked;
	}

	public void setIsReadLocked(Boolean isReadLocked) {
		this.isReadLocked = isReadLocked;
	}

	public Boolean getIsWriteLocked() {
		return isWriteLocked;
	}

	public void setIsWriteLocked(Boolean isWriteLocked) {
		this.isWriteLocked = isWriteLocked;
	}

	public Boolean getIsQuorumAcquired() {
		return isQuorumAcquired;
	}

	public void setIsQuorumAcquired(Boolean isQuorumAcquired) {
		this.isQuorumAcquired = isQuorumAcquired;
	}

	public ReentrantReadWriteLock getReadWriteLock() {
		return readWriteLock;
	}

	public void setReadWriteLock(ReentrantReadWriteLock readWriteLock) {
		this.readWriteLock = readWriteLock;
	}

	public Map<String, P> getP() {
		return consentObtained_P;
	}

	public void setP(Map<String, P> p) {
		consentObtained_P = p;
	}

	public Map<String, Q> getQ() {
		return quorum_Q;
	}

	public void setQ(Map<String, Q> q) {
		quorum_Q = q;
	}

	public Integer getMax_RU_M() {
		return max_VN_M;
	}

	public void setMax_RU_M(Integer max_RU_M) {
		this.max_VN_M = max_RU_M;
	}

	public Integer getN() {
		return N;
	}

	public void setN(Integer n) {
		N = n;
	}

	public FileInfo(){
		
	}
	
	public synchronized boolean quorumObtained(String dU, FileSystemHandler fsHandler, String fileName){
		//TODO:Check Quorum Condition for this FileName
		//TODO: VERY VERY IMPORTANT TO GET THIS RIGHT !
		if(consentObtained_P.size() < 1){
			return false;
		}
		
		int max = 0;
		for(Entry<String, P> entry : consentObtained_P.entrySet()){
			P pi = entry.getValue();
			if(pi.getVersionNumber() > max){
				max = pi.getVersionNumber();
			}
		}
		//M = max{VNj | Sj belongs to P}
		this.max_VN_M = max;
		
		for(Entry<String, P> entry : consentObtained_P.entrySet()){
			String key = entry.getKey();
			P pi = entry.getValue();
			//Q = {Sj | VNj = M}
			if(pi.getVersionNumber() == this.max_VN_M){
				Q qi = (Q) pi;
				
				//DS = DSj where Sj belongs to Q
				if(qi.getNodeID() == dU){
					qi.setIsDS(true);
				} else {
					qi.setIsDS(false);
				}
				
				//N = {RUj where Sj belongs to Q
				this.N = qi.getReplicasUpdated();
				
				quorum_Q.put(key, qi);
			}
		}
		
		Integer modQ = quorum_Q.size();
		
		if(modQ > (N/2)){
			isQuorumAcquired = true;
		}else if(modQ == (N/2)){
			
			for(Entry<String, Q> qEntry : quorum_Q.entrySet()){
				Q qi = qEntry.getValue();
				if(qi.getIsDS()){
					isQuorumAcquired = true;
				}
			}
			isQuorumAcquired = false;
		} else {
			isQuorumAcquired = false;
		}
		
		for(Entry<String, Q> qEntry : quorum_Q.entrySet()){
			Q qi = qEntry.getValue();
			//If I have a stale copy
			if(qi.getVersionNumber() == this.max_VN_M){
				//This code should not run.
				String content = qi.getContent();
				try {
					//Update stale copy with latest version.
					fsHandler.getFilesystem().write(fileName, content);
					break;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	
		return isQuorumAcquired;
		
	}

	public void resetQuorumCondition(){
		this.isQuorumAcquired = false;
		this.consentObtained_P = new LinkedHashMap<>();
		this.quorum_Q = new LinkedHashMap<>();
		this.max_VN_M = 0;
		this.N = 0;
	}
	
	public static FileInfo getDefaultInformation(Integer replicasUpdated, Integer versionNumber)
	{
		FileInfo defaultInfo 	= new FileInfo();
		
		defaultInfo.versionNumber 		= versionNumber;
		defaultInfo.replicasUpdated 	= replicasUpdated;
		defaultInfo.isQuorumAcquired	= false;
		defaultInfo.isReadLocked		= false;
		defaultInfo.isWriteLocked		= false;
		defaultInfo.readWriteLock 		= new ReentrantReadWriteLock();
		defaultInfo.max_VN_M 			= 0;
		defaultInfo.consentObtained_P 	= new LinkedHashMap<>();
		defaultInfo.quorum_Q			= new LinkedHashMap<>();
		defaultInfo.N					= 0;
		
		return defaultInfo;
	}
	
}
