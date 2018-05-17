package edu.cqut.hr.action;

import java.util.List;
import java.util.Scanner;

import edu.cqut.hr.dao.TeacherDao;
import edu.cqut.hr.model.Teacher;

public class TeacherAction {
	TeacherDao dao = new TeacherDao();
	
	public void add(Teacher T) throws Exception {
		dao.addTeacher(T);
	}
	
	public void delete(Integer id) throws Exception {
		dao.deleteTeacher(id);
	}
	
	public void update(Teacher T) throws Exception {
		dao.updateTeacher(T);
	}
	
	public List<Teacher> query() throws Exception {
		return dao.queryAll();
	}

}
