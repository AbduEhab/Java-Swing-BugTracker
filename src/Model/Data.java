package Model;

import java.util.ArrayList;

import Misc.Logger;

public class Data {

    private ArrayList<Table> data;

    public Data() {
        data = new ArrayList<Table>();
    }

    public Table GetTable(String Name) {
        // ToDo
        for (Table table : data) {
            if (table.getName().equals(Name))
                return table;
        }

        Logger.Error("Table could not be returned, Table: " + Name);
        return null;
    }

    public void AddTable(Table table) {

        data.add(table);

    }

}