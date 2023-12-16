package com.cousinware.example;

import com.cousinware.eventlistener.EventBus;
import com.cousinware.example.event.StartEvent;
import com.cousinware.example.event.TickEvent;

public class Main {

    public static Main INSTANCE;

    public static EventBus eventBus;

    public static void main(String[] args) {

        //start a new EventBus instance
        eventBus = new EventBus();

        //add a listener to a class
        Test test = new Test();

        //post an event to the event bus so it can be processed
        eventBus.postEvent(new StartEvent(System.nanoTime()));

        eventBus.postEvent(new TickEvent());




    }

}