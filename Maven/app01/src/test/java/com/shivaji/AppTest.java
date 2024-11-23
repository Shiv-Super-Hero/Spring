package com.shivaji;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
    	System.out.println();
    	Employee emp = new Employee("E-111", "Durga", 5000, "Hyd");
    	emp.getEmpDetails();
        System.out.println();
    	assertTrue(true);
    }
}
