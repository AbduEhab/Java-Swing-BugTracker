package Model;

import java.io.Serializable;
import java.util.ArrayList;

import Misc.Logger;

public class Data implements Serializable { // ToDo
    private static ArrayList<Table> tables;
    private static ArrayList<Chart> charts;
    private static ArrayList<Task> tasks;
    private static ArrayList<Bug> bugs;

    public Data() {

        tables = new ArrayList<Table>();
        charts = new ArrayList<Chart>();
        tasks = new ArrayList<Task>();
        bugs = new ArrayList<Bug>();
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

        for (Table table : tables) {
            if (table.getName().equals(Name))
                return table;
        }

        Logger.Error("Table could not be returned, Table: " + Name);
        throw new Exception("Table could not be returned, Table: " + Name);
    }

    public Chart getChart(String Name) throws Exception {

        for (Chart chart : charts) {
            if (chart.getName().equals(Name))
                return chart;
        }

        Logger.Error("Chart could not be returned, Chart: " + Name);
        throw new Exception("Chart could not be returned, Chart: " + Name);
    }

    public Task getTask(String Name) throws Exception {

        for (Task task : tasks) {
            if (task.getName().equals(Name))
                return task;
        }

        Logger.Error("Task could not be returned, Task: " + Name);
        throw new Exception("Task could not be returned, Task: " + Name);
    }

    public Bug getBug(String Name) throws Exception {

        for (Bug bug : bugs) {
            if (bug.getName().equals(Name))
                return bug;
        }

        Logger.Error("Bug could not be returned, Bug: " + Name);
        throw new Exception("Bug could not be returned, Bug: " + Name);
    }

    public ArrayList<Table> getTables() {
        return tables;
    }

    public ArrayList<Chart> getCharts() {
        return charts;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public ArrayList<Bug> getBugs() {
        return bugs;
    }

}