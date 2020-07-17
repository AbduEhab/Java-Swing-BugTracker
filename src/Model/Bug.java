package Model;

import Misc.Logger;

public class Bug {

    private String name;
    private Platform platform;
    private String bug;
    private String note;
    private String loggedTime;
    private Task task;

    public Bug(String name) {
        this.name = name;

        Logger.Log("Bug " + this.name + "has been created with hashcode: " + hashCode());
    }

    public Bug(String name, String bug) {
        this.name = name;
        this.bug = bug;

        Logger.Log("Bug " + this.name + "has been created with hashcode: " + hashCode());
    }

}