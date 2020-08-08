package Model;

import java.io.Serializable;
import java.util.ArrayList;

import Misc.Logger;

public class Data implements Serializable { // on hold till i complete the basic models

    private static ArrayList<Table> tables;
    private static ArrayList<Task> tasks;
    private static ArrayList<Bug> bugs;

    public Data() {
        tables = new ArrayList<Table>();
        tasks = new ArrayList<Task>();
        bugs = new ArrayList<Bug>();
    }

    public Table GetTable(String Name) {

        for (Table table : tables) {
            if (table.getName().equals(Name))
                return table;
        }

        Logger.Error("Table could not be returned, Table: " + Name);
        return null;
    }

    public void AddTable(Table table) {

        tables.add(table);

    }

}