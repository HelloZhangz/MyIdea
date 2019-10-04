package com.neusoft.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.neusoft.entity.Item;
import com.neusoft.entity.Menu;
import com.neusoft.main.AdminMenu;
import com.neusoft.util.DBUtil;
import com.neusoft.util.InputUtil;

public class UpdateItem implements Item{

	@Override
	public Menu execute() {
		// TODO Auto-generated method stub
		System.out.println("请输入需要修改的用户ID");
		int userid = InputUtil.getInt();
		System.out.println("请输入修改后的用户姓名");
		String username = InputUtil.getString();
		System.out.println("请输入修改后的用户密码");
		String userpass = InputUtil.getString();
		System.out.println("请输入修改后的用户邮箱");
		String useremail = InputUtil.getEmail();
		System.out.println("请输入修改后的用户权限(管理员/普通用户)");
		String userpower = InputUtil.getPower();
		Connection conn = DBUtil.getInstance().getConn();
		String sql = "update userinfo set username = ?,password = ?,email = ?,power = ? where id = ?";
		PreparedStatement pstmt = null;
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, userpass);
			pstmt.setString(3, useremail);
			if(userpower.equals("管理员")){
				pstmt.setInt(4, 1);
			}else{
				pstmt.setInt(4, 0);
			}
			pstmt.setInt(5, userid);
			pstmt.executeUpdate();
			conn.commit();
			System.out.println("修改成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				conn.rollback();
				System.out.println("修改失败");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{
			DBUtil.close(null, pstmt, conn);
		}
		return new AdminMenu();
	}
	
}
