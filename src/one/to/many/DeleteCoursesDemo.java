
package one.to.many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.Course;
import com.hibernate.Instructor;
import com.hibernate.InstructorDetail;

public class DeleteCoursesDemo {

    public static void main(final String... strings) {

        final SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class).buildSessionFactory();

        final Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            // get the course
            final int id = 10;
            final Course c = session.get(Course.class, id);

            // delete courses
            session.delete(c);

            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }

}
