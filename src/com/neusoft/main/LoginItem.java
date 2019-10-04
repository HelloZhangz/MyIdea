package com.neusoft.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.neusoft.entity.Item;
import com.neusoft.entity.Menu;
import com.neusoft.entity.User;
import com.neusoft.start.Start;
import com.neusoft.util.DBUtil;
import com.neusoft.util.InputUtil;

public class LoginItem implements Item{

	@Override
	public Menu execute() {
		// TODO Auto-generated method stub
		//做登录功能
		Menu menu = null;
		System.out.println("请输入用户名");
		String username = InputUtil.getString();
		System.out.println("请输入密码");
		String password = InputUtil.getString();
        Connection conn = DBUtil.getInstance().getConn();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        StringBuilder sb = new StringBuilder();
        sb.append("select * from userinfo ");
        sb.append("where username = ? ");
        sb.append("and password = ? ");
        sb.append("and status = 1");
        String sql = sb.toString();
        try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if(rs.next()){
				User user = new User();
				//从结果集中按照获取数据的类型去获取，即int型数据用rs.getInt()，
				//String型数据用rs.getString()，方法中放的字符串是用来表示你要获取
				//哪列数据，例要获取id，方法中就要放入id在数据库表中的列名，即"id"
				int id = rs.getInt("id");
				String username1 = rs.getString("username");
				String password1 = rs.getString("password");
				String email = rs.getString("email");
				int power = rs.getInt("power");
				int status = rs.getInt("status");
				user.setId(id);
				user.setUsername(username);
				user.setPassword(password1);
				user.setEmail(email);
				user.setPower(power);
				user.setStatus(status);
				Start.currUser = user;
				System.out.println("登录成功");
				System.out.println("=================");
				System.out.println("欢迎登录主窗体");
				if(user.getPower() == 0){
					menu = new UserMenu();
				}
				if(user.getPower() == 1){
					menu = new AdminMenu();
				}
			}else{
				System.out.println("用户名或密码错误，请返回主页面");
				menu = new MainMenu();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, conn);
		}
        
		return menu;
		
	}

}
