
package eager.vs.lazy.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.Course;
import com.hibernate.Instructor;
import com.hibernate.InstructorDetail;

public class EagerLazyDemo {

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

            // get courses for instructor
            System.out.println(instructor.getCourses());

            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }

}
