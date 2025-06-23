package com.controller;

import com.service.SchoolService;

public class SchoolController {
	
	public static void main(String[] args) {
		
		SchoolService ss = new SchoolService();
		//ss.insertData();
		//ss.updateData();
		//ss.deleteData();
		//ss.getParticular();
		ss.fetchAll();
		
		
	}

}
