package edu.cqut.hr.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.cqut.hr.db.DBUtil;
import edu.cqut.hr.model.Teacher;

public class TeacherDao {
	
	private static TeacherDao teacherDao;

	public static TeacherDao getTeacherDao() {
		if (teacherDao == null) {
			teacherDao = new TeacherDao();
		}

		return teacherDao;
	}
	
	public void addTeacher(Teacher T) throws Exception {
		Connection connection = DBUtil.getConnection();
		String sql = " INSERT INTO teacher" +
		        "(id,name,sex,birthday,salary,college,major)" + 
				"valuse(" +
		        "?,?,?,?,?,?,?) ";
		PreparedStatement ptmt = connection.prepareStatement(sql);
	
		ptmt.setInt(1, T.getId());
		ptmt.setString(2, T.getName());
		ptmt.setString(3, T.getSex());
		ptmt.setDate(4, new Date(T.getBirthday().getTime()));
		ptmt.setFloat(5, T.getSalary());
		ptmt.setString(6, T.getCollege());
		ptmt.setString(7, T.getMajor());
		ptmt.execute();
	}
	
	public void deleteTeacher(Integer id) throws Exception {
		Connection connection = DBUtil.getConnection();
		String sql = " DELETE FROM teacher " +
		        "WHERE id = ? ";
		PreparedStatement ptmt = connection.prepareStatement(sql);
	
		ptmt.setInt(1, id);
		ptmt.execute();
	}
	
	public void updateTeacher(Teacher T) throws Exception {
		Connection connection = DBUtil.getConnection();
		String sql = " UPDATE teacher " + 
		        " SET name=?,sex=?,birthday=?,salary=?,college=?,major=? " +
				" WHERE id = ?";
		
		PreparedStatement ptmt=connection.prepareStatement(sql);
		
		ptmt.setString(1, T.getName());
		ptmt.setString(2, T.getSex());
		ptmt.setDate(3, new Date(T.getBirthday().getTime()));
		ptmt.setFloat(4, T.getSalary());
		ptmt.setString(5, T.getCollege());
		ptmt.setString(6, T.getMajor());
		ptmt.execute();
	}
	
	public List<Teacher> queryAll() throws Exception {
		Connection connection = DBUtil.getConnection();

		List<Teacher> result = new ArrayList<Teacher>();
		String sql =" SELECT * FROM teacher ";
		
		PreparedStatement ptmt=connection.prepareStatement(sql);
		ResultSet teachers = ptmt.executeQuery();
		
		while(teachers.next()) {
			Teacher T = new Teacher();
			T.setId(teachers.getInt("id"));
			T.setName(teachers.getString("name"));
			T.setSex(teachers.getString("sex"));
			T.setBirthday(teachers.getDate("birthday"));
			T.setSalary(teachers.getFloat("salary"));
			T.setCollege(teachers.getString("college"));
			T.setMajor(teachers.getString("major"));
			result.add(T);
		}
		
		return result;
	}
	
	public Teacher get(Integer id) throws Exception {
		Connection connection = DBUtil.getConnection();
		String sql = " SELECT * FROM teacher WHERE id = ?";
		PreparedStatement ptmt=connection.prepareStatement(sql);
		
		ptmt.setInt(1, id);
		ResultSet rs = ptmt.executeQuery();
		Teacher T = new Teacher();
		while(rs.next()){
			T.setId(rs.getInt("id"));
			T.setName(rs.getString("name"));
			T.setSex(rs.getString("sex"));
			T.setBirthday(rs.getDate("birthday"));
			T.setSalary(rs.getFloat("salary"));
			T.setCollege(rs.getString("college"));
			T.setMajor(rs.getString("marjor"));
		}
		return T;
	}
}
