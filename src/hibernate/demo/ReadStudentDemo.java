package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.Student;

public class ReadStudentDemo {

	public static void main(String... strings) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			Student student = new Student("Daffy", "Duck", "daffy@test.com");

			session.beginTransaction();
			session.save(student);

			// commit transaction
			session.getTransaction().commit();

			// Find out the students id:primarykey
			System.out.println("saved student. Generated id: " + student.getId());

			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve student based on the id: primary key
			System.err.println("\nGetting student with id: " + student.getId());
			Student mystudent = session.get(Student.class, student.getId());
			System.out.println("get Complete: " + mystudent);

			// commit the transaction
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}

}
