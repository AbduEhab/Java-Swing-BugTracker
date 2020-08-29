package Model;

import java.util.ArrayList;
import java.util.HashMap;

import Misc.Logger;

public class Bug extends Event { // ToDo null name generator

    private Platform platform;
    private String bug;
    private static int count = 0;
    private int savedint;
    private int number;

    public Bug() {
        number = ++count;
        Logger.Log("An unnamed Bug has been created with hashcode: " + hashCode());
    }

    public Bug(String name) {
        super(name);
        number = ++count;
        Logger.Log("Bug " + getName() + " has been created with hashcode: " + hashCode());
    }

    public Bug(String name, String bug) {
        this(name);
        this.bug = bug;
    }

    public Bug(String name, Platform platform) {
        this(name);
        this.platform = platform;
    }

    public Bug(String name, Priority priority) {
        this(name);
        setPriority(priority);
    }

    public Bug(String name, String bug, String note) {
        this(name, bug);
        setNote(note);
    }

    public Bug(String name, String bug, Platform platform) {
        this(name, platform);
        this.bug = bug;
    }

    public Bug(String name, String note, Priority priority) {
        this(name, priority);
        setNote(note);
    }

    public Bug(String name, String bug, Platform platform, String note) {
        this(name, note, platform);
        this.bug = bug;
    }

    public Bug(String name, String bug, String note, Priority priority) {
        this(name, note, priority);
        this.bug = bug;
    }

    public Bug(String name, String bug, String note, Platform platform, Priority priority) {
        this(name, bug, note, priority);
        this.platform = platform;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number, HashMap<String, Object> bugs) throws Exception { // a bigger set method than
                                                                                       // anticipated

        if (number == this.number)
            return;
        if (number > count) {
            Logger.Error("Bug number is not possible");
            throw new Exception("Bug number is not possible");
        }

        Logger.Log("Bug number of " + getName() + " was changed from " + this.number + " to: " + number);

        for (Object bug : bugs.values()) {
            if (((Bug) bug).number == number)
                ((Bug) bug).number = this.number;
        }
        this.number = number;
    }

    public Platform getPlatform() {
        return platform == null ? Platform.NA : platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public String getBug() {
        return bug == null ? "NA" : bug;
    }

    public void setBug(String bug) {
        this.bug = bug == null ? "NA" : bug;
    }

}