package com.cousinware.demo.event;

public class StartEvent extends Event {

    long startTime;

    public StartEvent(long startTime) {
        this.startTime = startTime;
    }

    public long getStartTime() {
        return startTime;
    }
}
