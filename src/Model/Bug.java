package Model;

import java.util.HashMap;

import Misc.Logger;

public class Bug extends Event {

    private Platform platform;
    private String problem;
    private static int count = 0;
    private int savedint;
    private int number;

    public Bug() {
        super("Bug " + count);
        number = ++count;

        Logger.Log("An unnamed Bug has been created with hashcode: " + hashCode());
    }

    public Bug(String name) {
        super(name);
        number = ++count;
        Logger.Log("Bug " + getName() + " has been created with hashcode: " + hashCode());
    }

    public Bug(String name, String problem) {
        this(name);
        this.problem = problem;
    }

    public Bug(String name, Platform platform) {
        this(name);
        this.platform = platform;
    }

    public Bug(String name, Priority priority) {
        this(name);
        setPriority(priority);
    }

    public Bug(String name, String problem, String note) {
        this(name, problem);
        setNote(note);
    }

    public Bug(String name, String problem, Platform platform) {
        this(name, platform);
        this.problem = problem;
    }

    public Bug(String name, String note, Priority priority) {
        this(name, priority);
        setNote(note);
    }

    public Bug(String name, String problem, Platform platform, String note) {
        this(name, note, platform);
        this.problem = problem;
    }

    public Bug(String name, String problem, String note, Priority priority) {
        this(name, note, priority);
        this.problem = problem;
    }

    public Bug(String name, String problem, String note, Platform platform, Priority priority) {
        this(name, problem, note, priority);
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

    public String toString() {
        return "\n" + getClass().getSimpleName() + " " + getName()
                + ":\n".concat("Problem: " + problem + "/n").concat("Platform: " + platform + "/n")
                        .concat("Note: " + getNote() + "/n").concat("Priority: " + getPriority() + "/n");
    }

    public Platform getPlatform() {
        return platform == null ? Platform.NA : platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public String getProblem() {
        return problem == null ? "NA" : problem;
    }

    public void setBug(String problem) {
        this.problem = problem == null ? "NA" : problem;
    }

}