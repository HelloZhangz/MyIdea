package com.neusoft.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.neusoft.entity.Item;
import com.neusoft.entity.Menu;
import com.neusoft.entity.User;
import com.neusoft.util.DBUtil;
import com.neusoft.util.InputUtil;

public class QueryByNameItem implements Item{

	@Override
	public Menu execute() {
		// TODO Auto-generated method stub
		System.out.println("请输入要查询的用户姓名(支持模糊查询)");
		String name = InputUtil.getString();
		Connection conn = DBUtil.getInstance().getConn();
		String sql = "select * from userinfo where status = 1 and username like ? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+name+"%");
			rs = pstmt.executeQuery();
			while(rs.next()){
				int userid = rs.getInt("id");
				String username = rs.getString("username");
				String email = rs.getString("email");
				int power = rs.getInt("power");
				User user = new User();
				user.setId(userid);
				user.setUsername(username);
				user.setEmail(email);
				user.setPower(power);
				System.out.println(user);
				System.out.println("=======================");
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
