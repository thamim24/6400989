package com.thamimul.ormlearn.diffexample.hibernate;

import com.thamimul.ormlearn.diffexample.entity.Country;
import jakarta.annotation.PostConstruct;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class CountryHibernateDemo {

    private SessionFactory sessionFactory;

    @PostConstruct
    public void init() {
        System.out.println("=== Hibernate Example ===");

        // ✅ Programmatic Hibernate configuration
        Configuration configuration = new Configuration();

        configuration.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:h2:mem:testdb");
        configuration.setProperty("hibernate.connection.username", "sa");
        configuration.setProperty("hibernate.connection.password", "");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        configuration.setProperty("hibernate.show_sql", "true");

        // ✅ Tell Hibernate which entity to use
        configuration.addAnnotatedClass(Country.class);

        sessionFactory = configuration.buildSessionFactory();

        // ✅ Use Hibernate to fetch data
        Session session = sessionFactory.openSession();
        Country country = session.get(Country.class, "IN");
        System.out.println("Hibernate Found: " + country);
        session.close();
        sessionFactory.close();
    }
}
