package Model;

import java.text.SimpleDateFormat;
import java.util.Date;

import Misc.Logger;

public abstract class Event { // ToDo check build

    private String name;
    private Priority priority;
    private Date loggedDate;
    private String note;

    public Event() {
        name = "Unnamed " + getClass().getSimpleName();
        loggedDate = new Date(System.currentTimeMillis());
        priority = Priority.NON;
    }

    public Event(String name) {
        this.name = name;
        loggedDate = new Date(System.currentTimeMillis());
        priority = Priority.NON;
    }

    public Event(String name, String note) {
        this.name = name;
        this.note = note;
        loggedDate = new Date(System.currentTimeMillis());
        priority = Priority.NON;
    }

    public Event(String name, Priority priority) {
        this.name = name;
        this.priority = priority;
        loggedDate = new Date(System.currentTimeMillis());
    }

    public Event(String name, String note, Priority priority) {
        this.name = name;
        this.note = note;
        loggedDate = new Date(System.currentTimeMillis());
        this.priority = priority;
    }

    public String getLoggedDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm z");
        return formatter.format(loggedDate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? "" : name;
        Logger.Log(getClass().getSimpleName() + " name set to: " + name);
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? "" : note;
        Logger.Log(getClass().getSimpleName() + " note set to: " + note);
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
        Logger.Log(getClass().getSimpleName() + " priority set to: " + priority);
    }

    public abstract int getNumber();

    public abstract void setNumber(int number) throws Exception;

}