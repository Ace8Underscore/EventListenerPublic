package com.cousinware.example;

import com.cousinware.eventlistener.EventBus;
import com.cousinware.example.event.StartEvent;
import com.cousinware.example.event.TickEvent;

public class Main {

    public static EventBus eventBus;
    public static long startTime = System.currentTimeMillis();

    public static void main(String[] args) {

        //start a new EventBus instance
        eventBus = new EventBus();

        //add a listener to a class
        Test test = new Test();

        //post an event to the event bus so it can be processed
        for (int i = 0; i < 100; i++) {
            eventBus.postEvent(new StartEvent(System.currentTimeMillis()));

        }




    }

}