package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.Student;

public class DeleteStudentDemo {

	public static void main(String... strings) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			
		int studentId = 1;
		Student student = session.get(Student.class, studentId);
		
		student.setFirstName("scooby");
		
			// commit the transaction
			session.getTransaction().commit();
			
			// new code
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//update email for all 
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			
			session.getTransaction().commit();
			
			
		} finally {
			factory.close();
		}
	}

}
