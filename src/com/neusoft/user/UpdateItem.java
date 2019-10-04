package com.neusoft.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.neusoft.entity.Item;
import com.neusoft.entity.Menu;
import com.neusoft.main.UserMenu;
import com.neusoft.start.Start;
import com.neusoft.util.DBUtil;
import com.neusoft.util.InputUtil;

public class UpdateItem implements Item{

	@Override
	public Menu execute() {
		// TODO Auto-generated method stub
		System.out.println("请输入要修改的姓名");
		String username = InputUtil.getString();
		System.out.println("请输入要修改的密码");
		String password = InputUtil.getString();
		System.out.println("请输入要修改的邮箱");
		String email = InputUtil.getEmail();
		Connection conn = DBUtil.getInstance().getConn();
		StringBuilder sb = new StringBuilder();
		sb.append("update userinfo ");
		sb.append("set username = ?,");
		sb.append("password = ?,");
		sb.append("email = ? ");
		sb.append("where id = ?");
		String sql = sb.toString();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, email);
			pstmt.setInt(4, Start.currUser.getId());
			pstmt.executeUpdate();
			System.out.println("修改成功");
			Start.currUser.setUsername(username);
			Start.currUser.setPassword(password);
			Start.currUser.setEmail(email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(null, pstmt, conn);
		}
		return new UserMenu();
	}

}
