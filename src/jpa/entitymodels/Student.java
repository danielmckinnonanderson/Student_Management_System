package jpa.entitymodels;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {
	
	@Id
	@Column(name="email", nullable=false, length=50)
	private String sEmail;
	
	@Column(name="name", nullable=false, length=50)
	private String sName;
	
	@Column(name="password", nullable=false, length=50)
	private String sPass;
	
	@OneToMany(targetEntity=Course.class)
	private List<Course> sCourses;
	
	
	public Student() {
		super();
	}

	public Student(String sName, String sEmail, String sPass, List<Course> sCourses) {
		super();
		this.sName = sName;
		this.sEmail = sEmail;
		this.sPass = sPass;
		this.sCourses = sCourses;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsEmail() {
		return sEmail;
	}

	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}

	public String getsPass() {
		return sPass;
	}

	public void setsPass(String sPass) {
		this.sPass = sPass;
	}

	public List<Course> getsCourses() {
		return sCourses;
	}

	public void setsCourses(List<Course> sCourses) {
		this.sCourses = sCourses;
	}
}