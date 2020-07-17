package Model;

import java.sql.Date;
import java.text.SimpleDateFormat;

import Misc.Logger;

public class Task extends Event { // ToDo check build

    private Date dueDate;
    private static int count = 0;
    private int number;

    public Task() {
        number = ++count;
        Logger.Log("An unnamed task has been created with hashcode: " + hashCode());
    }

    public Task(String name) {
        super(name);
        number = ++count;
        Logger.Log("Task " + getName() + "has been created with hashcode: " + hashCode());
    }

    public Task(String name, String note) {
        super(name, note);
        number = ++count;
        Logger.Log("Task " + getName() + "has been created with hashcode: " + hashCode());
    }

    public Task(String name, Priority priority) {
        super(name, priority);
        number = ++count;
        Logger.Log("Task " + getName() + "has been created with hashcode: " + hashCode());
    }

    public Task(String name, String note, Priority priority) {
        super(name, note, priority);
        number = ++count;
        Logger.Log("Task " + getName() + "has been created with hashcode: " + hashCode());
    }

    public Task(String name, String note, Priority priority, int year, int month, int day) {
        super(name, note, priority);
        number = ++count;
        dueDate = new Date(year, month, day);
        Logger.Log("Task " + getName() + "has been created with hashcode: " + hashCode());

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

    public void setNumber(int number) throws Exception { // ToDo build correctly

        if (number == this.number)
            return;
        if (number >= count) {
            Logger.Error("Task number is not possible");
            throw new Exception("Task number is not possible");
        }

        Logger.Log("Task number of " + getName() + " was changed from " + this.number + " to: " + number);

        for (Task task : Data.getTasks()) {
            if (task.number == number)
                task.number = this.number;
        }
        this.number = number;
    }

}