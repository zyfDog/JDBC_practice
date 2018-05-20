package edu.cqut.hr.view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import edu.cqut.hr.dao.TeacherDao;
import edu.cqut.hr.model.Teacher;

public class View {
	static Scanner scanner = new Scanner(System.in);
	public int showMenu() {
		System.out.println("\t\t\t教职工管理系统                         ");
		System.out.print("\t1、查询全体教职工信息        \t");
		System.out.println("2、查询单个教职工信息                     ");
		System.out.print("\t3、新教职工信息增添               \t");
		System.out.println("4、教职工信息修改                        ");
		System.out.print("\t5、教职工信息删除                     ");
		System.out.println("\t6、根据关键字查询教职工信息");
		System.out.println("\t7、退出系统                       \n");
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
		
		System.out.println("请输入教职工的生日：(格式为yyyy-MM-dd)");
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
		
		System.out.printf("所需删除教职工信息为:（%d, %s, %f），是否删除（Y/N）?\n"
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
		System.out.println("id   name   sex   birthday       salary   college     major   ");
		for(int i = 0; i < result.size(); i++){
			Teacher T = result.get(i);
			
			System.out.printf("%-4d %-13s %-13s %-14tF %-8.2f %-20s %-5s\n", 
					T.getId(), T.getName(), T.getSex(), T.getBirthday(), 
					T.getSalary(), T.getCollege(), T.getMajor());
		}
	}
	
	public void get() throws Exception{
		Teacher T = new Teacher();
		
		System.out.println("请输入想要查询的职工的id号：");
		int id = scanner.nextInt();
		
		T = TeacherDao.getTeacherDao().get(id);
		System.out.printf("所查询的教职工信息为：（%d, %s, %s, %s, %.2f, %s, %s）\n",
				T.getId(),T.getName(),T.getSex(),T.getBirthday().toString(),
				T.getSalary(),T.getCollege(),T.getMajor());
	}
	
	public void query() throws Exception {
		List<Teacher> teachers = new ArrayList<Teacher>();
		List<Map<String,Object>> params = new ArrayList<Map<String,Object>>();
		Map<String,Object> param = new HashMap<String,Object>();
		
		System.out.println("请选择要查询的属性");
		System.out.println("1.id  2.name  3.sex  4.birthday  5.salary  6.college  7.major");
	    
		int command = scanner.nextInt();
	    switch(command) {
	    case 1:
	    	param.put("name","id");
	    	break;
	    case 2:
	    	param.put("name","name");
	    	break;
	    case 3:
	    	param.put("name","sex");
	    	break;
	    case 4:
	    	param.put("name","birthdat");
	    	break;
	    case 5:
	    	param.put("name","salary");
	    	break;
	    case 6:
	    	param.put("name","college");
	    	break;
	    case 7:
	    	param.put("name","major");
	    	break;
	    default:
			break;
	    }
	    
	    param.put("rela","like");
	    System.out.println("请输入所查询属性的值：(生日格式为yyyy-MM-dd)");
	    String value = "'%" + scanner.next() + "%'";
	    param.put("value",value);
	    params.add(param);
	    
	    teachers = TeacherDao.getTeacherDao().query(params);
	    System.out.println("id   name   sex   birthday       salary   college     major   ");
		for(int i = 0; i < teachers.size(); i++){
			Teacher T = teachers.get(i);
			System.out.printf("%-4d %-13s %-13s %-14tF %-8.2f %-20s %-5s\n", 
					T.getId(), T.getName(), T.getSex(), T.getBirthday(), 
					T.getSalary(), T.getCollege(), T.getMajor());
		}
	}
	
	public void exit(){
		System.out.println("\t\t             成功退出教职工管理系统！ ");
		System.out.println("\t\t\t  欢迎下次使用");
		
	}
	
	
	
}
