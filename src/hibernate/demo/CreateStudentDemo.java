package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.Student;


public class CreateStudentDemo {
	
	public static void main(String...strings) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			Student student = new Student("Paul", "Wall", "paull@test.com");
			
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}
	}

}
