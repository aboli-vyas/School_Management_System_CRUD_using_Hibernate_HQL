package com.service;

import com.dao.SchoolDao;

public class SchoolService {

	public void insertData() {
		SchoolDao sd = new SchoolDao();
		sd.insertData();
	}

	public void updateData() {
		SchoolDao sd = new SchoolDao();
		sd.updateData();
		
	}

	public void deleteData() {
		
		SchoolDao sd = new SchoolDao();
		sd.deleteData();
	}

	public void getParticular() {
		SchoolDao sd = new SchoolDao();
		sd.getParticular();
		
	}

	public void fetchAll() {
		SchoolDao sd = new SchoolDao();
		sd.fetchAll();
		
	}

}
