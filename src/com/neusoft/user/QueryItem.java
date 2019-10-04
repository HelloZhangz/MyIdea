package com.neusoft.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.neusoft.entity.Item;
import com.neusoft.entity.Menu;
import com.neusoft.entity.User;
import com.neusoft.main.UserMenu;
import com.neusoft.start.Start;
import com.neusoft.util.DBUtil;

public class QueryItem implements Item{

	@Override
	public Menu execute() {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getInstance().getConn();
		String sql = "select *from userinfo where id = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Start.currUser.getId());
			rs = pstmt.executeQuery();
			if(rs.next()){
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String email = rs.getString("email");
				User user = new User();
				user.setId(id);
				user.setUsername(username);
				user.setPassword(password);
				user.setEmail(email);
				System.out.println(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, conn);
		}
		return new UserMenu();
	}
	
}
