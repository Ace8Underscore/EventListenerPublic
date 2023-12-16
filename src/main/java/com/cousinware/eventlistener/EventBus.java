package com.cousinware.eventlistener;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class EventBus {

    /*
     * @author Ace8Underscores
     */

    boolean debug = false;

    ArrayList<Method> targetMethodsArrayList;

    public EventBus() {
        targetMethodsArrayList = new ArrayList<>();
    }

    public void addListener(Class<?> c) {
        //below we search the given class to see if any method contains our listener if so we add it to the targetMethodsArrayList
        for (Method m : c.getMethods()) {
            if (ClassUtils.hasAnnotation(m, Listener.class)) {
                targetMethodsArrayList.add(m);
                if (debug) System.out.println("Listener was add to class: " + c + " at method " + m);

            }
        }
    }
    public void postEvent(Object c) {
        // below we search each given method that has a listener and check if any of its parameters contain the posted even or object
        //TODO n^2 not good possibly could use a hashmap?
        for (Method method : targetMethodsArrayList) {
            for (int i = 0; i < method.getParameterTypes().length; i++) {
                if (!(method.getParameterTypes()[i] == c.getClass())) break;
                try {
                    method.invoke(method.getDeclaringClass(), c);
                } catch (Exception e) {
                    System.out.println("\u001B[31m" + "Tried to Post event but failed! Have you initialized your listener correctly? err at: " + method + "\n|| Failed event -> " + c.getClass() + "\u001B[0m");
                }

            }

        }
    }


    public ArrayList<Method> getTargetMethodsArrayList() {
        return this.targetMethodsArrayList;
    }
}
