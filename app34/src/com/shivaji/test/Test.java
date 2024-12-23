package com.shivaji.test;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.shivaji.entity.Employee;

public class Test {

	public static void main(String[] args)throws Exception {
		/*
		Class c = Class.forName("com.shivaji.entity.Employee");
		System.out.println("Class Name  : "+c.getName());
		System.out.println("Super Class : "+c.getSuperclass());
		System.out.print("Interfaces  : ");
		Class [] cls = c.getInterfaces();
		for(Class c1:cls) {
			System.out.print(c1.getName()+"  ");
		}
		System.out.println();
		System.out.print("Varibles   : ");
		Field[] flds = c.getDeclaredFields();
		for(Field fls : flds) {
			System.out.print(fls.getName()+"  ");
		}
		System.out.println();
		System.out.print("Constructors  : ");
		Constructor[] cons = c.getDeclaredConstructors();
		for(Constructor con:cons) {
			System.out.print(con.getName()+"  ");
		}
		System.out.println();
		
		System.out.print("Methods    : ");
		Method[] methods = c.getDeclaredMethods();
		for(Method m : methods) {
			System.out.print(m.getName()+"  ");
		}
	*/
		
		
		
		BeanInfo beanInfo = Introspector.getBeanInfo(Employee.class);
		PropertyDescriptor [] propDesc = beanInfo.getPropertyDescriptors();
		
		for(PropertyDescriptor p : propDesc) {
			System.out.println("Property Name         : "+p.getName());
			System.out.println("Property Type         : "+p.getPropertyType());
			System.out.println("Property Read Method  : "+p.getReadMethod().getName());
			System.out.println("Property Write Method : "+p.getWriteMethod());
			System.out.println("-----------------------------");
			
			MethodDescriptor [] md = beanInfo.getMethodDescriptors();
			for(MethodDescriptor m:md) {
				System.out.println(m.getName()+"  ");
			}
			
		}
		
	}
}


// This program deals with the Reflection API with its help we are able to get complete metadata about any class,
// attributes, methods, constructors, interfaces, etc. In Context of Spring Framework we can relate this with Introspection.
// Introspection will give the complete details about the bean.