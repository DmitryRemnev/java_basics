import entities.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();

        try (SessionFactory factory = metadata.getSessionFactoryBuilder().build()) {

            Session session = factory.openSession();
            Transaction transaction = session.beginTransaction();

            /*CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Course> query = builder.createQuery(Course.class);
            Root<Course> root = query.from(Course.class);
            query.select(root).where(builder.greaterThan(root.get("price"), 100_000))
                    .orderBy(builder.desc(root.get("price")));
            List<Course> courseList = session.createQuery(query).setMaxResults(5).getResultList();

            for (Course course : courseList) {
                System.out.println(course.getName() + " - " + course.getPrice());
            }*/

            String hql = "From " + Course.class.getSimpleName() + " Where price > 120000";
            List<Course> courseList = session.createQuery(hql).getResultList();

            for (Course course : courseList) {
                System.out.println(course.getName() + " - " + course.getPrice());
            }

            transaction.commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}