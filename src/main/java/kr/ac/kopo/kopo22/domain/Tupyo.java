package kr.ac.kopo.kopo22.domain;

public class Tupyo {
	private int id;
	private int age;
	private int votes;
	
	public Tupyo() {
		
	}
	public Tupyo (int id, int age) {
		this.id = id;
		this.age = age;
	}
	public Tupyo (int id, int age, int votes) {
		this.id = id;
		this.age = age;
		this.votes = votes;
	}
	public Tupyo(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
