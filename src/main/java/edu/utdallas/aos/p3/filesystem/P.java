package edu.utdallas.aos.p3.filesystem;

public class P {
	private String nodeID;
	private Integer versionNumber;
	private Integer replicasUpdated;
	private String content;
	private Integer count;

	public P(String id, Integer VN, Integer RU, String content) {
		this.nodeID = id;
		this.versionNumber = VN;
		this.replicasUpdated = RU;
		this.content = content;
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

	@Override
	public boolean equals(Object obj) {
		P objP = null;
		if (obj instanceof P) {
			objP = (P) obj;
		} else {
			return false;
		}
		
		if (this.nodeID == objP.nodeID) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int id = Integer.parseInt(nodeID);
		return id;
	}

}
