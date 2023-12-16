package com.cousinware.example;

import com.cousinware.example.event.StartEvent;
import com.cousinware.example.event.TickEvent;
import com.cousinware.eventlistener.Listener;

public class Test {

    public Test() {
        //adds the listener to this class
        Main.INSTANCE.eventBus.addListener(this.getClass());
    }

    //@Listener annotations will be used for methods that will be listened to
    //Also set the methods first parameter to the event you want to listen to
    @Listener
    public static void update(TickEvent event) {
        System.out.println("Ticking");
    }

    @Listener
    public static void update2(StartEvent event) {
        System.out.println("Starting");
        System.out.println(event.getStartTime());
    }

}
