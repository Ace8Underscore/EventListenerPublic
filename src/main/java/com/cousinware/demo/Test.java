package com.cousinware.demo;

import com.cousinware.demo.event.StartEvent;
import com.cousinware.demo.event.TickEvent;
import com.cousinware.eventlistener.Listener;

public class Test {

    public Test() {
        Main.INSTANCE.eventBus.addListener(this.getClass());
    }

   // @Listener(event =
    @Listener
    public static void update(TickEvent event) {
        System.out.println("Ticking");
    }

    @Listener()
    public static void update2(StartEvent event) {
        System.out.println("Starting");
        System.out.println(event.getStartTime());
    }

    //@Listener
    public String toString() {
        return "";
    }
}
