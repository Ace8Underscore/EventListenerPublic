package com.cousinware.demo;

import com.cousinware.eventlistener.EventBus;
import com.cousinware.demo.event.StartEvent;
import com.cousinware.demo.event.TickEvent;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Main {

    public static Main INSTANCE;

    //below dev will insert their EventClass
    static EventBus eventBus;

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        eventBus = new EventBus();
        Test test = new Test();

        System.out.println(eventBus.getTargetMethodsArrayList());
        eventBus.postEvent(TickEvent.class);

        while (true) {
            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt();
            if (i == 1) eventBus.postEvent(StartEvent.class);
        }


    }

}