package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.Student;

public class UpdateStudentDemo {

	public static void main(String... strings) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			
//		int studentId = 1;
//		Student student = session.get(Student.class, studentId);
		
		//delete student
//		session.delete(student);
		
		//delete student id=2
		session.createQuery("delete from Student where id=2").executeUpdate();
		
		
			// commit the transaction
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}

}
