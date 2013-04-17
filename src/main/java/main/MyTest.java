package main;

import java.lang.reflect.Method;

import model.MyClass;
import annotations.CanRun;

public class MyTest {

	public static void main(String[] args) {

		MyClass clazz = new MyClass();
		Method[] methods = clazz.getClass().getMethods();

		for (Method method : methods) {
			CanRun annos = method.getAnnotation(CanRun.class);
			if (annos != null) {
				try {
					method.invoke(clazz);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}