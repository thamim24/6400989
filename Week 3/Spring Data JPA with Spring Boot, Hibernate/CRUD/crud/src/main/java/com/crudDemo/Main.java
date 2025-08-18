package com.crudDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Crud crud=new Crud();
        crud.setId(12);
        crud.setName("Doe");
        crud.setDept("CSE");

        SessionFactory sessionFactory=new Configuration().
                                      configure().
                                      addAnnotatedClass(com.crudDemo.Crud.class).
                                      buildSessionFactory();
        Session session=sessionFactory.openSession();
//        session.beginTransaction();
//        session.persist(crud);
//        session.getTransaction().commit();
        crud = session.find(com.crudDemo.Crud.class, 11);
        System.out.println(crud);
        crud = session.find(com.crudDemo.Crud.class, 12);
        System.out.println(crud);
        crud = session.find(com.crudDemo.Crud.class, 13);
        System.out.println(crud);
//        session.merge(crud);
//        session.getTransaction().commit();
//        crud = session.find(com.crudDemo.Crud.class, 13);

//        Crud crud1 = session.find(com.crudDemo.Crud.class, 12);
//        session.remove(crud1);
//        session.getTransaction().commit();
//        System.out.println(crud1);
        session.close();
        sessionFactory.close();
    }
}
