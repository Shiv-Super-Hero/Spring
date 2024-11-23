package com.shivaji;

import com.shivaji.jdbc.JdbcApp;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        JdbcApp jdbcApp = new JdbcApp();
        jdbcApp.getEmpDetails();
    }
}
