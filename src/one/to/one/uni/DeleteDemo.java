
package one.to.one.uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.Instructor;
import com.hibernate.InstructorDetail;

public class DeleteDemo {

    public static void main(final String... strings) {

        final SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

        final Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            // get instructor by primary key /id
            final int id = 1;
            final Instructor instructor = session.get(Instructor.class, id);

            if (instructor != null) {

                // wil delete associate objects
                session.delete(instructor);
            }

            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }

}
