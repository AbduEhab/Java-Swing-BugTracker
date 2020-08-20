package Model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Misc.Logger;

public abstract class Event implements Serializable { // ToDo check build

    private String name;
    private Priority priority;
    private Date loggedDate;
    private String note;
    private DataTypeListener listener;

    public Event() {
        name = "Unnamed " + getClass().getSimpleName();
        loggedDate = new Date(System.currentTimeMillis());
        priority = Priority.NON;
    }

    public Event(String name) {
        this();
        this.name = name;
    }

    public String getLoggedDate() {

        return new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm z").format(loggedDate);
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

    public final void setPriority(Priority priority) {
        this.priority = priority;
        Logger.Log(getClass().getSimpleName() + " priority set to: " + priority);
    }

    public abstract int getNumber();

    public abstract void setNumber(int number, ArrayList<Object> data) throws Exception;

}