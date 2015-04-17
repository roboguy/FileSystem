package edu.utdallas.aos.p3.filesystem;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class FileInfo {
	private Integer versionNumber;
	private Integer replicasUpdated;
	private Boolean isReadLocked;
	private Boolean isWriteLocked;
	private Boolean isQuorumAcquired;
	private ReentrantReadWriteLock readWriteLock;
	private Set<P> consentObtained_P;
	private Set<Q> quorum_Q;
	private Integer max_RU_M;
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

	public Set<P> getP() {
		return consentObtained_P;
	}

	public void setP(Set<P> p) {
		consentObtained_P = p;
	}

	public Set<Q> getQ() {
		return quorum_Q;
	}

	public void setQ(Set<Q> q) {
		quorum_Q = q;
	}

	public Integer getMax_RU_M() {
		return max_RU_M;
	}

	public void setMax_RU_M(Integer max_RU_M) {
		this.max_RU_M = max_RU_M;
	}

	public Integer getN() {
		return N;
	}

	public void setN(Integer n) {
		N = n;
	}

	public FileInfo(){
		
	}
	
	public boolean quorumObtained(){
		//TODO:Check Quorum Condition for this FileName
		return false;
	}


	
	public FileInfo getDefaultInformation(Integer replicasUpdated, Integer versionNumber)
	{
		FileInfo defaultInfo 	= new FileInfo();
		
		defaultInfo.versionNumber 	= versionNumber;
		defaultInfo.replicasUpdated = replicasUpdated;
		defaultInfo.isQuorumAcquired= false;
		defaultInfo.isReadLocked	= false;
		defaultInfo.isWriteLocked	= false;
		defaultInfo.readWriteLock 	= new ReentrantReadWriteLock();
		defaultInfo.max_RU_M 		= 0;
		defaultInfo.consentObtained_P 				= new LinkedHashSet<>();
		defaultInfo.quorum_Q				= new LinkedHashSet<>();
		defaultInfo.N				= 0;
		
		return defaultInfo;
	}
	
}
