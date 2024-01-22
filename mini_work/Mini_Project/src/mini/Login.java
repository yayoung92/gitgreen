package mini;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.DBConnection;
import info.User;

class Login {

	public static int login(String name, String pw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.getConnection();	
			String sql = "select * from user where u_name=? and u_password=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				User.setUserId(rs.getString("u_name"));
				User.setUserPassword(rs.getString("u_password"));
				User.setIdx(rs.getInt("u_idx"));
			} else {
				System.out.println("회원정보가 없습니다.");
				return 0;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 1;
	}
}

class Join {
	public static void join(String name, String pw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.getConnection();	
			String sql = "insert into user (`u_name`,`u_password`) "
					+ "values (?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, pw);
			pstmt.executeUpdate();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
