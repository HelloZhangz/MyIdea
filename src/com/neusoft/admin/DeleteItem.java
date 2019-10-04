package com.neusoft.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.neusoft.entity.Item;
import com.neusoft.entity.Menu;
import com.neusoft.main.AdminMenu;
import com.neusoft.start.Start;
import com.neusoft.util.DBUtil;
import com.neusoft.util.InputUtil;

public class DeleteItem implements Item{

	@Override
	public Menu execute() {
		// TODO Auto-generated method stub
		System.out.println("请输入要删除的用户ID");
		int id = InputUtil.getInt();
		Connection conn = DBUtil.getInstance().getConn();
		String sql = "update userinfo set status = 0 where id = ?";
		PreparedStatement pstmt = null;
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			conn.commit();
			System.out.println("删除成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				conn.rollback();
				System.out.println("删除失败");
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
