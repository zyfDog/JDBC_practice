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
    			break;
    		case 2 :
    			TeacherView.add();
    			break;
    		case 3 :
    			TeacherView.update();
    			break;
    		case 4 :
    			TeacherView.delete();
    			break;
    		case 5 :
    			TeacherView.exit();
    			break;
    		default:
				break;
    		}
    		if(command == 5)
    			break;
    	}
	}
}
