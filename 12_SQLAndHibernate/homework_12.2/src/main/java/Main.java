import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();

        try (SessionFactory factory = metadata.getSessionFactoryBuilder().build()) {

            Session session = factory.openSession();
            Course course = session.get(Course.class, 1);

            System.out.println(course.getName());
            System.out.println(course.getStudentsCount());

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}