package edu.utdallas.aos.p3.filesystem;

public class P {
	private String nodeID;
	private Integer versionNumber;
	private Integer replicasUpdated;
	private String content;
	private Integer count;

	public P(String id, Integer VN, Integer RU, String content){
		
	}
	
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getNodeID() {
		return nodeID;
	}

	public void setNodeID(String nodeID) {
		this.nodeID = nodeID;
	}

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}



}
