package com.cousinware.eventlistener;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class EventBus {

    /*
     * @author Ace8Underscores
     */

    ArrayList<Method> targetMethodsArrayList;
    //ArrayList<Class<?>> classesArrayList;

    public EventBus() {
        targetMethodsArrayList = new ArrayList<>();
        //classesArrayList = new ArrayList<>();
    }

    public void addListener(Class<?> c) {
        //below we search the given class to see if any method contain our listener if so we add it to the targetMethodsArrayList
        for (Method m : c.getMethods()) {
            if (ClassUtils.hasAnnotation(m, Listener.class)) {
                targetMethodsArrayList.add(m);
                //classesArrayList.add(c);
                System.out.println("Added");
            }
        }
    }

//    public void removeListener(Class<?> c) {
//
//    }

    int steps = 0;
    public void postEvent(Object c) {
        for (Method method : targetMethodsArrayList) {


            for (int i = 0; i < method.getParameterTypes().length; i ++) {
                steps++;
                if (method.getParameterTypes()[i] == c.getClass()) {
                    try {
                        method.invoke(method.getDeclaringClass(), c);
                        System.out.println(steps + " steps to complete operation");
                    } catch (Exception e) {
                        System.out.println("\u001B[31m" + "Tried to Post event but failed! Have you initialized your listener correctly? err at: " + method + "\n|| Failed event -> " + c.getClass() + "\u001B[0m");
                    }
                }
            }

        }
    }




    public ArrayList<Method> getTargetMethodsArrayList() {
        return this.targetMethodsArrayList;
    }
}
