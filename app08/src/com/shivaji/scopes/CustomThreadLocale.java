package com.shivaji.scopes;

import java.util.HashMap;

public class CustomThreadLocale extends ThreadLocal<Object> {
	@Override
	protected Object initialValue() {
		return new HashMap<String,Object>();
	}
}
