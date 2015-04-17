package edu.utdallas.aos.p3.filesystem;

public class Q extends P{
	
	private Boolean isDS;
	
	public Q(String id, Integer VN, Integer RU, String content) {
		super(id, VN, RU, content);
	}
	
	public Boolean getIsDS() {
		return isDS;
	}

	public void setIsDS(Boolean isDS) {
		this.isDS = isDS;
	}
	
}
