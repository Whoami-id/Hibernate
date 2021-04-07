
package one.to.one.uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.Instructor;
import com.hibernate.InstructorDetail;

public class CreateDemo {

    public static void main(final String... strings) {

        final SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

        final Session session = factory.getCurrentSession();

        try {

            final Instructor instructor = new Instructor("Chad", "Darby", "darby@test.com");
            final InstructorDetail instructorDetail = new InstructorDetail("www.youtube.com", "test test");

            // associate the objects
            instructor.setInstructorDetail(instructorDetail);

            session.beginTransaction();

            session.save(instructor);

            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }

}
