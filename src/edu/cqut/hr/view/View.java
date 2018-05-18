package edu.cqut.hr.view;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import edu.cqut.hr.dao.TeacherDao;
import edu.cqut.hr.model.Teacher;

public class View {
	static Scanner scanner = new Scanner(System.in);
	public int showMenu() {
		System.out.println("\t\t\t教职工管理系统                         ");
		System.out.print("\t1、查询全体教职工信息        \t");
		System.out.println("2、新教职工信息增添                     ");
		System.out.print("\t3、教职工信息修改               \t");
		System.out.println("4、教职工信息删除                        ");
		System.out.println("\t5、退出系统                       \n");
		System.out.print("\t请选择你的操作选项号：");
		
		int command = scanner.nextInt();
		return command;
	}
	
	public void add() throws Exception {
		Teacher T = new Teacher();
		
		System.out.println("请输入教职工的id号：");
		T.setId(scanner.nextInt());
		
		System.out.println("请输入教职工的名字：");
		T.setName(scanner.next());
		
		System.out.println("请输入教职工的性别：");
		T.setSex(scanner.next());
		
		System.out.println("请输入教职工的生日：");
		String birthdayString = scanner.next();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		T.setBirthday(sdf.parse(birthdayString));
		
		System.out.println("请输入教职工的基本工资");
		T.setSalary(scanner.nextFloat());
		
		System.out.println("请输入教职工的学院");
		T.setCollege(scanner.next());
		
		System.out.println("请输入教职工的专业");
		T.setMajor(scanner.next());
		
		System.out.printf("插入教职工信息为:（%d, %s, %.2f），是否插入（Y/N）?"
				,T.getId(),T.getName(),T.getSalary());
		System.out.print("请输入：Y(N)  ");
		
		if(scanner.next().toUpperCase().equals("Y")){
			TeacherDao.getTeacherDao().addTeacher(T);
		    System.out.println("修改成功（返回菜单）");
		}
			
	}
	
	public void delete() throws Exception {
		Teacher T = new Teacher();
		
		System.out.println("请输入教职工id：");
		Integer deleteId = scanner.nextInt();
		T = TeacherDao.getTeacherDao().get(deleteId);
		
		System.out.printf("所需删除教职工信息为:（%d, %s, %f），是否删除（Y/N）?"
				,T.getId(),T.getName(),T.getSalary());
		System.out.print("请输入：Y(N)  ");
		
		if(scanner.next().toUpperCase().equals("Y")){
			TeacherDao.getTeacherDao().deleteTeacher(deleteId);
		    System.out.println("删除成功（返回菜单）");
		}
	}
	
	public void update() throws Exception {
		Teacher Old = new Teacher();
		Teacher T = new Teacher();
		
		System.out.println("请输入教职工的id号：");
		Integer id = scanner.nextInt();
		Old = TeacherDao.getTeacherDao().get(id);
		
		T.setId(Old.getId());
		System.out.println("请输入id为" + id +"的教职工修改后的名字：");
		T.setName(scanner.next());
		System.out.println("请输入id为" + id +"的教职工修改后的性别：");
		T.setSex(scanner.next());
		System.out.println("请输入id为" + id +"的教职工修改后的生日：");
		String birthdayString = scanner.next();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		T.setBirthday(sdf.parse(birthdayString));
		System.out.println("请输入id为" + id +"的教职工修改后的基本工资：");
		T.setSalary(scanner.nextFloat());
		System.out.println("请输入id为" + id +"的教职工修改后的学院：");
		T.setCollege(scanner.next());
		System.out.println("请输入id为" + id +"的教职工修改后的专业：");
		T.setMajor(scanner.next());
		
		System.out.println("修改后教职工信息为:（" + T.getId() + ", " + T.getName() + ", " + T.getSalary() + "），是否修改（Y/N）?");
		System.out.print("请输入：Y(N)  ");
		
		if(scanner.next().toUpperCase().equals("Y")){
			TeacherDao.getTeacherDao().updateTeacher(T);
			System.out.println("修改成功（返回菜单）");
		}
	}
	
	public void queryAll() throws Exception {
		List<Teacher> result = TeacherDao.getTeacherDao().queryAll();
		
		System.out.println("全体教职工信息如下：");
		System.out.println("id   name   sex   birthday   salary   college   major   ");
		for(int i = 0; i < result.size(); i++){
			Teacher T = result.get(i);
			System.out.println(T.getId() + "   " + T.getName() + "   " + T.getSex() + "   "
					 + T.getBirthday() + "   "  + T.getSalary() + "   " + T.getCollege() + "   "
					 + T.getMajor());
		}
	}
	
	public void get(){
		
	}
	
	public void exit(){
		System.out.println("\t\t             成功退出教职工管理系统！ ");
		System.out.println("\t\t\t  欢迎下次使用");
		
	}
	
	
	
}
