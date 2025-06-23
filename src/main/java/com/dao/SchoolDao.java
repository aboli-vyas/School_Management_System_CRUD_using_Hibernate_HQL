package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;

import com.entities.School;

public class SchoolDao {

	// insert data

	public void insertData() {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(School.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		String hqlQuery = "insert into School(studId,studName,tId,tName,subject)values(:studId,:studName,:tId,:tName,:subject)";

		Query<School> query = ss.createNativeQuery(hqlQuery);
		query.setParameter("studId", 2);
		query.setParameter("studName", "Asha");
		query.setParameter("tId", 1002);
		query.setParameter("tName", "VP");
		query.setParameter("subject", "Marathi");
		query.executeUpdate();

		System.out.println("Data inserted");
		tr.commit();
		ss.close();

	}

	// update data

	public void updateData() {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(School.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		int id = 1;

		String hqlQuery = "update School set studId=:studId, studName=:studName , tId=:tId, tName=:tName , subject=:subject where id=:id";

		MutationQuery query = ss.createMutationQuery(hqlQuery);
		query.setParameter("id", id);
		query.setParameter("studId", 101);
		query.setParameter("studName", "ASV");
		query.setParameter("tId", 121);
		query.setParameter("tName", "Avi");
		query.setParameter("subject", "Science");
		query.executeUpdate();
		System.out.println("Data updated");

		tr.commit();
		ss.close();

	}

	// delete record

	public void deleteData() {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(School.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		int id = 2;

		String hqlQuery = "delete from School where id=:id";
		MutationQuery query = ss.createMutationQuery(hqlQuery);
		query.setParameter("id", id);
		query.executeUpdate();
		System.out.println("Data deleted");

		tr.commit();
		ss.close();

	}

	// get particular record

	public void getParticular() {

		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(School.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		int id = 101;
		String hqlQuery = "from School where id=:id";
		Query<School> query = ss.createQuery(hqlQuery, School.class);
		query.setParameter("id", id);
		School sc = query.getSingleResult();
		System.out.println(sc);

		tr.commit();
		ss.close();
	}

	// fetch all record

	public void fetchAll() {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(School.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		String hqlQuery = "from School";

		Query<School> query = ss.createQuery(hqlQuery, School.class);
		List<School> lst = query.list();

		for (School school : lst) {

			System.out.println(school);

		}
	}

}
