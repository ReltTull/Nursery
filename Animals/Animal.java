package Animals;

import java.sql.Date;
import java.util.ArrayList;

abstract public class Animal {

	private String name;
	private int age;
	private String kind;
	private ArrayList<String> skills;
	private Date birthDate;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public ArrayList<String> getSkills() {
		return skills;
	}

	public void setSkills(ArrayList<String> skills) {
		this.skills = skills;
	}

	public String getKind() {
		return kind;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	Animal(String name, int age, String kind, ArrayList<String> skills) {
		super();
		this.name = name;
		this.age = age;
		this.kind = kind;
		this.skills = skills;
	}

	public void newSkill(String newSkill) {
		// TODO Auto-generated method stub
		skills.add(newSkill);
	}



}
