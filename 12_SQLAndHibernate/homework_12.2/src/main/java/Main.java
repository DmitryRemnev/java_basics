import entities.Course;
import entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();

        try (SessionFactory factory = metadata.getSessionFactoryBuilder().build()) {

            Session session = factory.openSession();
            Transaction transaction = session.beginTransaction();

            Course course = session.get(Course.class, 1);
            System.out.println(course.getTeacher().getName());
            System.out.println(course.getStudents().size());

            List<Student> studentList = course.getStudents();
            studentList.forEach(s -> System.out.println(s.getName()));

            transaction.commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}