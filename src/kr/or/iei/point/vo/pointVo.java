package kr.or.iei.point.vo;

public class pointVo {
	private String rank;
	private String name;
	private int point;
	
	
	//기본생성자
	public	pointVo() {
		
	}
	
	//매개변수가 있는 생성자 
	public pointVo(String rank,String name, int point) {
		this.setRank(rank);
		this.name = name;
		this.point = point;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPoint() {
		return point;
	}
	
	public void setPoint(int point) {
		this.point = point;
	}
}
