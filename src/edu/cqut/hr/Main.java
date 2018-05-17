package edu.cqut.hr;

import edu.cqut.hr.view.View;

public class Main {
	
    public static void main(String[] args) throws Exception {
	
    	View TeacherView = new View();
    	
    	while(true){
    		int command =  TeacherView.showMenu();
    		switch(command){
    		case 1 :
    			TeacherView.queryAll();
    		case 2 :
    			TeacherView.add();
    		case 3 :
    			TeacherView.update();
    		case 4 :
    			TeacherView.delete();
    		default:
				break;
    		}
    	}
	}
}
