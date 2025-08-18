package com.crudDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Crud crud=new Crud();
        crud.setId(13);
        crud.setName("Mary");
        crud.setDept("ECE");

        SessionFactory sessionFactory=new Configuration().
                                      configure().
                                      addAnnotatedClass(com.crudDemo.Crud.class).
                                      buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.merge(crud);

        crud = session.find(com.crudDemo.Crud.class, 13);
        System.out.println(crud);
        session.close();
        sessionFactory.close();
    }
}
