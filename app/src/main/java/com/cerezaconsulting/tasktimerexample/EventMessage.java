package com.cerezaconsulting.tasktimerexample;

import java.io.Serializable;

/**
 * Created by junior on 23/06/17.
 */

public class EventMessage implements Serializable {

    private int time;

    public EventMessage(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
