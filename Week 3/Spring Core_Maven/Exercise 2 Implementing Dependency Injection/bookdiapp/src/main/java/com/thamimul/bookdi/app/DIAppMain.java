package com.thamimul.bookdi.app;

import com.thamimul.bookdi.service.BookProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DIAppMain {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookProcessor processor = ctx.getBean("bookProcessor", BookProcessor.class);
        processor.process();
    }
}
