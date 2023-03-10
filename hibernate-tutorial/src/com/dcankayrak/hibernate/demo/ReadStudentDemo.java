package com.dcankayrak.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dcankayrak.hibernate.demo.entities.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 1;
			
			// find out the primary key : student id
			System.out.println("Saved Student. Generated Id : "+studentId);
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id : primary key
			System.out.println("\nGetting Student with id : "+studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			System.out.println(myStudent);
			
			// update
			System.out.println("Updating student");
			myStudent.setFirstName("test");
			
			// commit transaction
			session.getTransaction().commit();
			
			// new code
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Updating all emails");
			session.createQuery("Update Student set email='testt'").executeUpdate();
			
			session.getTransaction().commit();
			
			
			System.out.println("Done!");
			
			
		}finally {
			factory.close();
		}
	}

}
