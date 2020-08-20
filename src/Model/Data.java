package Model;

import java.io.Serializable;
import java.util.ArrayList;

import Misc.Logger;

public class Data implements Serializable { // ToDo
    private static ArrayList<Object> tables;
    private static ArrayList<Object> charts;
    private static ArrayList<Object> tasks;
    private static ArrayList<Object> bugs;

    public Data() {

        tables = new ArrayList<Object>();
        charts = new ArrayList<Object>();
        tasks = new ArrayList<Object>();
        bugs = new ArrayList<Object>();
    }

    public void AddTable(String name, ArrayList<String> columns) {

        tables.add(new Table(name, columns));
    }

    public void AddChart(String name) {

        charts.add(new Chart(name));
    }

    public void AddTask(String name, String note, Priority priority, int year, int month, int day) {

        tasks.add(new Task(name, note, priority, year, month, day));
    }

    public void AddBug(String name, String bug, String note, Platform platform, Priority priority) {

        bugs.add(new Bug(name, bug, note, platform, priority));
    }

    public void remove(Object o) {

        switch (o.getClass().getSimpleName()) {
            case "Task":
                tasks.remove(o);
                Logger.Warn("Task Deleted");
                break;
            case "Table":
                tables.remove(o);
                Logger.Warn("Table Deleted");
                break;
            case "Bug":
                bugs.remove(o);
                Logger.Warn("Bug Deleted");
                break;
            case "Chart":
                charts.remove(o);
                Logger.Warn("Chart Deleted");
                break;
            default:
                break;
        }
    }

    public Table getTable(String Name) throws Exception {

        for (Object table : tables) {
            if (((Table) table).getName().equals(Name))
                return (Table) table;
        }

        Logger.Error("Table could not be returned, Table: " + Name);
        throw new Exception("Table could not be returned, Table: " + Name);
    }

    public Chart getChart(String Name) throws Exception {

        for (Object chart : charts) {
            if (((Chart) chart).getName().equals(Name))
                return (Chart) chart;
        }

        Logger.Error("Chart could not be returned, Chart: " + Name);
        throw new Exception("Chart could not be returned, Chart: " + Name);
    }

    public Task getTask(String Name) throws Exception {

        for (Object task : tasks) {
            if (((Task) task).getName().equals(Name))
                return (Task) task;
        }

        Logger.Error("Task could not be returned, Task: " + Name);
        throw new Exception("Task could not be returned, Task: " + Name);
    }

    public Bug getBug(String Name) throws Exception {

        for (Object bug : bugs) {
            if (((Bug) bug).getName().equals(Name))
                return (Bug) bug;
        }

        Logger.Error("Bug could not be returned, Bug: " + Name);
        throw new Exception("Bug could not be returned, Bug: " + Name);
    }

    public ArrayList<Object> getTables() {
        return tables;
    }

    public ArrayList<Object> getCharts() {
        return charts;
    }

    public ArrayList<Object> getTasks() {
        return tasks;
    }

    public ArrayList<Object> getBugs() {
        return bugs;
    }

}