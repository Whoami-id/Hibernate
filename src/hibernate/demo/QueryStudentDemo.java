package hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.Student;


public class QueryStudentDemo {
	
	public static void main(String...strings) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			
			
			session.beginTransaction();
			
			// query student
			List<Student> sList = session.createQuery("from Student").getResultList();
			
			//display student
			sList.forEach(System.out::println);
			
			//query students lastname=Done
			sList = session.createQuery("from Student s where s.lastName='Done'").getResultList();
			sList.forEach(System.out::println);
			
			//query students lastname = done or firstname =Daffy
			sList = session.createQuery("from Student s where s.lastName='Done' OR s.firstName='Daffy'").getResultList();
			sList.forEach(System.out::println);
			
			//query student where email like 
			sList = session.createQuery("from Student s where" + " s.email LIKE'%mary@test.com'").getResultList();
			sList.forEach(System.out::println);
			
			
			
		
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}
	}

}
