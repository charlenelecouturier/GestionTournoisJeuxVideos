package com.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import com.action.RegisterAction;
import java.sql.CallableStatement;
import java.sql.Types;

public class User {
	private String lastname, name, email, city, password, birthdate, phone, gender;

	public static Connection conn() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/DB?useSSL=false&allowPublicKeyRetrieval=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
	}

	public static int register(RegisterAction ra) throws Exception {
		int flag = 0;

		try {
			Connection con=conn();

			PreparedStatement ps = con.prepareStatement("INSERT INTO USERS VALUES(?,?,?,?,?,?,?,?)");
			ps.setString(1, ra.getUserBean().getName());
			ps.setString(2, ra.getUserBean().getLastname());
			ps.setString(3, ra.getUserBean().getEmail());

			ps.setString(4, ra.getUserBean().getPassword());

			ps.setString(5, ra.getUserBean().getBirthdate());

			ps.setString(6, ra.getUserBean().getCity());
			ps.setString(7, ra.getUserBean().getPhone());
			ps.setString(8, ra.getUserBean().getGender());

			flag = ps.executeUpdate();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;

	}

	public String getUser(String user_email, String user_pass) {
		try {
			Connection con=conn();

			CallableStatement cs =con.prepareCall("{call getUser(?,?,?)}");
			cs.setString(1, user_email);
			cs.setString(2, user_pass);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.executeQuery();
			String str=cs.getString(3);
			con.close();
			return str;
		} catch (Exception e) {
			return e.getMessage();
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
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone =phone;
	}


	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender =gender;
	}

}
