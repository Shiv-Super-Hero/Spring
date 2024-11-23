package com.shivaji.test;

import java.util.ArrayList;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.shivaji.beans.City_State;
import com.shivaji.beans.City_State_Collection;

public class Test {

	public static void main(String[] args) throws Exception{
		City_State_Collection collection = new City_State_Collection();
		StandardEvaluationContext context = new StandardEvaluationContext(collection);
		ExpressionParser parser = new SpelExpressionParser();
		
		Expression expr = parser.parseExpression("cityState.?[state == 'Telengana']");
		ArrayList<City_State> al = (ArrayList<City_State>)expr.getValue(context);
		System.out.println(al);
		
		Expression ex = parser.parseExpression("cityState.?[state == 'Maharastra']");
		ArrayList<City_State> al1 = (ArrayList<City_State>)ex.getValue(context);
		System.out.println(al1);
	}

}
