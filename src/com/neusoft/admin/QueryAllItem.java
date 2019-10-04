package com.neusoft.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.neusoft.entity.Item;
import com.neusoft.entity.Menu;
import com.neusoft.entity.User;
import com.neusoft.main.AdminMenu;
import com.neusoft.util.DBUtil;

public class QueryAllItem implements Item{

	@Override
	public Menu execute() {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getInstance().getConn();
		String sql = "select * from userinfo where power = 0 and status = 1";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String email = rs.getString("email");
				int power = rs.getInt("power");
				User user = new User();
				user.setId(id);
				user.setUsername(username);
				user.setEmail(email);
				user.setPower(power);
				System.out.println(user);
				System.out.println("==========================");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, conn);
		}
		return new QueryMenu();
	}

}
