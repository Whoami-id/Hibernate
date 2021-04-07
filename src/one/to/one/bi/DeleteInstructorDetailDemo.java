
package one.to.one.bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.Instructor;
import com.hibernate.InstructorDetail;

public class DeleteInstructorDetailDemo {

    public static void main(final String... strings) {

        final SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

        final Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            // get the instructor detail object
            final int id = 2;
            final InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);

            System.out.println(instructorDetail.getInstructor());

            // delete
            session.delete(instructorDetail);

            session.getTransaction().commit();

        } catch (final Exception ex) {
            ex.printStackTrace();

        } finally {
            session.close();
            factory.close();
        }
    }

}
