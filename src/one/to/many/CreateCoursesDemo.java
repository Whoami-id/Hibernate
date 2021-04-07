
package one.to.many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.Course;
import com.hibernate.Instructor;
import com.hibernate.InstructorDetail;

public class CreateCoursesDemo {

    public static void main(final String... strings) {

        final SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class).buildSessionFactory();

        final Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            // get instructor from db
            final int id = 2;
            final Instructor instructor = session.get(Instructor.class, id);

            // Create Courses
            final Course c1 = new Course("Air guitar");
            final Course c2 = new Course("pintball master class");

            // add courses to instructor
            instructor.add(c1);
            instructor.add(c2);

            session.save(c1);
            session.save(c2);

            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }

}
