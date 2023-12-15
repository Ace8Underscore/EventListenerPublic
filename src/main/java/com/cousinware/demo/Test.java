package com.cousinware.demo;

import com.cousinware.demo.event.StartEvent;
import com.cousinware.demo.event.TickEvent;
import com.cousinware.eventlistener.Listener;

public class Test {

    public Test() {
        Main.INSTANCE.eventBus.addListener(this.getClass());
    }

    @Listener(event = TickEvent.class)
    public static void update() {
        System.out.println("Ticking");
    }

    @Listener(event = StartEvent.class)
    public static void update2(StartEvent event) {
        System.out.println("Starting");
        System.out.println(event.getStartTime());
    }

    //@Listener
    public String toString() {
        return "";
    }
}
