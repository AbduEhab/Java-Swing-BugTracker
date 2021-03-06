package Model;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import Misc.Logger;

public class Task extends Event {

    private Date dueDate;
    private String task;
    private static int count = 0;
    private int savedint;
    private int number;

    public Task() {
        super("Task " + count);
        number = ++count;
        Logger.Log("An unnamed task has been created with hashcode: " + hashCode());
    }

    public Task(String name) {
        super(name);
        number = ++count;
        Logger.Log("Task " + getName() + " has been created with hashcode: " + hashCode());
    }

    public Task(String name, String task) {
        this(name);
        this.task = task;
    }

    public Task(String name, String task, String note) {
        this(name, task);
        setNote(note);
    }

    public Task(String name, String task, Priority priority) {
        this(name, task);
        setPriority(priority);
    }

    public Task(String name, String task, String note, Priority priority) {
        this(name, task, priority);
        setNote(note);
    }

    public Task(String name, String note, Priority priority, int year, int month, int day) {
        this(name, note, priority);
        dueDate = new Date(year, month, day);
        Logger.Log("Task " + getName() + " has been created with hashcode: " + hashCode());

    }

    public String toString() {
        return "\n" + getClass().getSimpleName() + " " + getName()
                + ":\n".concat("Task: " + task + "/n").concat("DueDate: " + dueDate + "/n")
                        .concat("Note: " + getNote() + "/n").concat("Priority: " + getPriority() + "/n");
    }

    public String getDueDate() {
        if (dueDate == null)
            return "NA";
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return formatter.format(dueDate);
    }

    public void setDueDate(int year, int month, int day) {

        if (dueDate == null) {
            dueDate = new Date(year, month, day);
            Logger.Log("Task " + getName() + "duedate set to: [" + day + " - " + month + " - " + year + "]");
            return;
        }

        dueDate.setYear(year - 1900);
        dueDate.setMonth(month);
        dueDate.setDate(day);

        Logger.Log("Task " + getName() + "duedate set to: [" + day + " - " + month + " - " + year + "]");
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number, HashMap<String, Object> tasks) throws Exception { // ToDo build correctly

        if (number == this.number)
            return;
        if (number >= count) {
            Logger.Error("Task number is not possible");
            throw new Exception("Task number is not possible");
        }

        Logger.Log("Task number of " + getName() + " was changed from " + this.number + " to: " + number);

        for (Object task : tasks.values()) {
            if (((Task) task).number == number)
                ((Task) task).number = this.number;
        }
        this.number = number;
    }

}