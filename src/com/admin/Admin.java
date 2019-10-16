package com.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import com.action.RegisterAction;

public class Admin {
	public static Connection conn() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/DB?useSSL=false&allowPublicKeyRetrieval=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
	}

	public static int register(RegisterAction ra) throws Exception {
		int flag = 0;
		Connection con=conn();

		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO USERS VALUES(?,?,?,?,?,?)");
			ps.setString(1, ra.getName());
			ps.setString(2, ra.getLastname());
			ps.setString(3, ra.getPassword());

			ps.setString(4, ra.getEmail());
			ps.setString(5, ra.getBirthdate());

			ps.setString(6, ra.getCity());

			flag = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.close();

		return flag;

	}
}
