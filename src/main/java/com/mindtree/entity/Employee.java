package com.mindtree.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Range;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component
@Entity
@Table
public class Employee {
	@Id
	//@Range(min = 1, max = 150) 
	private int id;
	//@NotEmpty
	private String username;
	//@NotEmpty
	private String password;
	//@NotEmpty
	private String fullname;
	//@Email
	private String emailid;
	private String dob;
	private String gender;
	//@NotEmpty
	private String securityQuestion;
	//@NotEmpty
	private String securityAnswer;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return " \n Employee [id=" + id + ", username=" + username + ", password=" + password + ", fullname=" + fullname
				+ ", emailid=" + emailid + ", dob=" + dob + ", gender=" + gender + ", securityQuestion="
				+ securityQuestion + ", securityAnswer=" + securityAnswer + "] \n";
	}
	public Employee(int id, String username, String password, String fullname, String emailid, String dob,
			String gender, String securityQuestion, String securityAnswer) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.emailid = emailid;
		this.dob = dob;
		this.gender = gender;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSecurityQuestion() {
		return securityQuestion;
	}
	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}
	public String getSecurityAnswer() {
		return securityAnswer;
	}
	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}
	
	
}
