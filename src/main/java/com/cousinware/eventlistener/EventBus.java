package com.cousinware.eventlistener;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class EventBus {

    /*
     * @author Ace8Underscores
     */

    ArrayList<Method> targetMethodsArrayList;
    ArrayList<Class<?>> classesArrayList;

    public EventBus() {
        targetMethodsArrayList = new ArrayList<>();
        classesArrayList = new ArrayList<>();
    }

    public void addListener(Class<?> c) {
        //below we search the given class to see if any method contain our listener if so we add it to the targetMethodsArrayList
        for (Method m : c.getMethods()) {
            if (ClassUtils.hasAnnotation(m, Listener.class)) {
                targetMethodsArrayList.add(m);
                classesArrayList.add(c);
                System.out.println("Added");
            }
        }
    }

    public void postEvent(Class<?> c) throws InvocationTargetException, IllegalAccessException {
        for (Method method : targetMethodsArrayList) {

            //System.out.println(Arrays.toString(method.getDeclaredAnnotations()));

            for (int i = 0; i < method.getDeclaredAnnotations().length; i ++) {
                Listener l = (Listener) method.getDeclaredAnnotations()[i];

                if (c == l.event()) {
                    System.out.println(method.getDeclaringClass());
                    method.invoke(method.getDeclaringClass());
                }
                //if (method.getDeclaredAnnotations()[i].annotationType() == Lis)
            }

//            for (int i = 0; i < method.getDeclaredAnnotations().length; i++) {
//                if (method.getDeclaredAnnotations()[i].getClass() == c) {
//                    System.out.println("true");
//                    System.out.println(method.getDeclaringClass().getName());
//                    method.invoke(new TickEvent(), new TickEvent());
//                }
//            }
        }
    }


    public ArrayList<Method> getTargetMethodsArrayList() {
        return this.targetMethodsArrayList;
    }
}
