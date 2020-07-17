package Model;

import java.text.SimpleDateFormat;
import java.util.Date;

import Misc.Logger;

public class Task { // ToDo build

    private String name;

    private int count = 0;
    private Date loggedDate;
    private String note;

    public Task() {
        count++;
    }

    public Task(String name) {
        this.name = name;
        loggedDate = new Date(System.currentTimeMillis());
        count++;
        Logger.Log("Task " + this.name + "has been created with hashcode: " + hashCode());
    }

    public Task(String name, String note) {
        this.name = name;
        this.note = note;
        loggedDate = new Date(System.currentTimeMillis());
        count++;
    }

    public String getLoggedDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss z");
        return formatter.format(loggedDate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? "" : name;

    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? "" : note;
    }
}