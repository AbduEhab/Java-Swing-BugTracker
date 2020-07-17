package Model;

import Misc.Logger;

public class Bug extends Event { // ToDo check build

    private Platform platform;
    private String bug;
    private static int count = 0;
    private int number;

    public Bug() {
        number = ++count;
        Logger.Log("An unnamed Bug has been created with hashcode: " + hashCode());
    }

    public Bug(String name) {
        super(name);
        number = ++count;
        Logger.Log("Bug " + getName() + "has been created with hashcode: " + hashCode());
    }

    public Bug(String name, Platform platform) {
        super(name);
        this.platform = platform;
        number = ++count;
        Logger.Log("Bug " + getName() + "has been created with hashcode: " + hashCode());
    }

    public Bug(String name, String bug) {
        super(name);
        this.bug = bug;
        number = ++count;
        Logger.Log("Bug " + getName() + "has been created with hashcode: " + hashCode());
    }

    public Bug(String name, String bug, Platform platform) {
        super(name);
        this.bug = bug;
        this.platform = platform;
        number = ++count;
        Logger.Log("Bug " + getName() + "has been created with hashcode: " + hashCode());
    }

    public Bug(String name, String bug, String note) {
        super(name, note);
        this.bug = bug;
        number = ++count;
        Logger.Log("Bug " + getName() + "has been created with hashcode: " + hashCode());
    }

    public Bug(String name, String bug, Platform platform, String note) {
        super(name, note);
        this.bug = bug;
        this.platform = platform;
        number = ++count;
        Logger.Log("Bug " + getName() + "has been created with hashcode: " + hashCode());
    }

    public Bug(String name, Priority priority) {
        super(name, priority);
        number = ++count;
        Logger.Log("Bug " + getName() + "has been created with hashcode: " + hashCode());
    }

    public Bug(String name, String note, Priority priority) {
        super(name, note, priority);
        number = ++count;
        Logger.Log("Bug " + getName() + "has been created with hashcode: " + hashCode());
    }

    public Bug(String name, String bug, String note, Priority priority) {
        super(name, note, priority);
        this.bug = bug;
        number = ++count;
        Logger.Log("Bug " + getName() + "has been created with hashcode: " + hashCode());
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) throws Exception { // ToDo build correctly

        if (number == this.number)
            return;
        if (number >= count) {
            Logger.Error("Bug number is not possible");
            throw new Exception("Bug number is not possible");
        }

        Logger.Log("Bug number of " + getName() + " was changed from " + this.number + " to: " + number);

        for (Bug bug : Data.getBugs()) {
            if (bug.number == number)
                bug.number = this.number;
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