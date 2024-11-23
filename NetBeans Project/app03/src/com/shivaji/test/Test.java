package com.shivaji.test;

import com.shivaji.beans.WishBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/com/shivaji/resources/applicationContext.xml");
        WishBean wish = (WishBean)context.getBean("wishBean");
        System.out.println(wish.wishUser());
    }    
}
