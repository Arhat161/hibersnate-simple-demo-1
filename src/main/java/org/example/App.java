package org.example;

import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // First, create Configuration (all connection properties in 'hibernate.properties' file
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        // Second, create sessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        // Third, get session to wor from sessionFactory
        Session session = sessionFactory.getCurrentSession();

        try {
            // open transaction
            session.beginTransaction();

            Person person = session.get(Person.class, 1); // SELECT * FROM Person WHERE id=1

            System.out.println(person.getName());
            System.out.println(person.getAge());

            // close transaction
            session.getTransaction().commit();

        } finally {
            // close sessionFactory
            sessionFactory.close();

        }

    }
}
