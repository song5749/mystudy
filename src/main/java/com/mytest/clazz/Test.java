package com.mytest.clazz;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {

    public static void main(String[] args) throws Exception {
        PersonModel personModel = new PersonModel();
        personModel.setName("sss");
        personModel.setAge(11);

        Class clazz = personModel.getClass();

        Field[] f = clazz.getDeclaredFields();

        for (Field field : f) {
            String key = field.getName();
            PropertyDescriptor descriptor = new PropertyDescriptor(key, clazz);
            Method method = descriptor.getReadMethod();
            Object value = method.invoke(personModel);

            System.out.println(key + ":" + value);



        }
    }
}
