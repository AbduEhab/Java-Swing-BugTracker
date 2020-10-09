package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import Misc.Logger;

public class Data implements Serializable {
    private static HashMap<String, Object> tables;
    private static HashMap<String, Object> charts;
    private static HashMap<String, Object> tasks;
    private static HashMap<String, Object> bugs;

    public Data() {

        tables = new HashMap<String, Object>();
        charts = new HashMap<String, Object>();
        tasks = new HashMap<String, Object>();
        bugs = new HashMap<String, Object>();
    }

    public void AddTable(String name, ArrayList<String> columns) {

        tables.put(name, new Table(name, columns));
    }

    public void AddChart(String name) {

        charts.put(name, new Chart(name));
    }

    public void AddTask(String name, String note, Priority priority, int year, int month, int day) {

        tasks.put(name, new Task(name, note, priority, year, month, day));
    }

    public void AddBug(String name, String bug, String note, Platform platform, Priority priority) {

        bugs.put(name, new Bug(name, bug, note, platform, priority));
    }

    public void remove(Object o) {

        switch (o.getClass().getSimpleName()) {
            case "Task":
                tasks.remove(((Task) (o)).getName());
                Logger.Warn("Task Deleted");
                break;
            case "Table":
                tables.remove(((Table) (o)).getName());
                Logger.Warn("Table Deleted");
                break;
            case "Bug":
                bugs.remove(((Bug) (o)).getName());
                Logger.Warn("Bug Deleted");
                break;
            case "Chart":
                charts.remove(((Chart) (o)).getName());
                Logger.Warn("Chart Deleted");
                break;
            default:
                break;
        }
    }

    public Table getTable(String Name) throws Exception {

        Table temp = (Table) tables.get(Name);
        if (temp != null)
            return temp;

        Logger.Error("Table could not be Found, Table: " + Name);
        throw new Exception("Table could not be Found, Table: " + Name);
    }

    public Chart getChart(String Name) throws Exception {

        Chart temp = (Chart) charts.get(Name);
        if (temp != null)
            return temp;

        Logger.Error("Chart could not be Found, Chart: " + Name);
        throw new Exception("Chart could not be Found, Chart: " + Name);
    }

    public Task getTask(String Name) throws Exception {

        Task temp = (Task) tasks.get(Name);
        if (temp != null)
            return temp;

        Logger.Error("Task could not be Found, Task: " + Name);
        throw new Exception("Task could not be Found, Task: " + Name);
    }

    public Bug getBug(String Name) throws Exception {

        Bug temp = (Bug) bugs.get(Name);
        if (temp != null)
            return temp;

        Logger.Error("Bug could not be Found, Bug: " + Name);
        throw new Exception("Bug could not be Found, Bug: " + Name);
    }

    public HashMap<String, Object> getTables() {
        return tables;
    }

    public HashMap<String, Object> getCharts() {
        return charts;
    }

    public HashMap<String, Object> getTasks() {
        return tasks;
    }

    public HashMap<String, Object> getBugs() {
        return bugs;
    }

}