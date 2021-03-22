package jpa.entitymodels;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {
	
	@Id
	@Column(name="email", nullable=false, length=50, unique=true)
	private String sEmail;
	
	@Column(name="name", nullable=false, length=50)
	private String sName;
	
	@Column(name="password", nullable=false, length=50)
	private String sPass;
	
	@OneToMany(targetEntity=Course.class,
			fetch=FetchType.EAGER)
	private List sCourses;
	
	
	public Student() {
		super();
	}
	
	public Student(String sName, String sEmail, String sPass) {
		super();
		this.sName = sName;
		this.sEmail = sEmail;
		this.sPass = sPass;
	}

	public Student(String sName, String sEmail, String sPass, List sCourses) {
		super();
		this.sName = sName;
		this.sEmail = sEmail;
		this.sPass = sPass;
		this.sCourses = sCourses;
	}
	
	@Override
	public String toString() {
		return String.format("%s, %s\n", sName, sEmail);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (sEmail == null) {
			if (other.sEmail != null)
				return false;
		} else if (!sEmail.equals(other.sEmail))
			return false;
		if (sName == null) {
			if (other.sName != null)
				return false;
		} else if (!sName.equals(other.sName))
			return false;
		if (sPass == null) {
			if (other.sPass != null)
				return false;
		} else if (!sPass.equals(other.sPass))
			return false;
		return true;
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

	public List getsCourses() {
		return sCourses;
	}

	public void setsCourses(List sCourses) {
		this.sCourses = sCourses;
	}
}