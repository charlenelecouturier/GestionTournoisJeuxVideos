package com.action;

import com.admin.Admin;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {

	String lastname, name, email, city, password, birthdate;

	public String execute() throws Exception {

		int var = Admin.register(this);
		if (var > 0) {
			return "SUCCESS";
		} else {
			return "input";
		}
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate =birthdate;
	}
	
}