package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			Student student = new Student("John", "Done", "john@test.com");
			Student student2 = new Student("Mary", "Public", "mary@test.com");
			Student student3 = new Student("Bonita", "Applebum", "bonita@test.com");
			
			session.beginTransaction();
			
			session.save(student);
			session.save(student2);
			session.save(student3);
			
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}

	}

}
