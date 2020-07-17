package Model;

import java.util.ArrayList;

import Misc.Logger;

public class Table { //ToDo fix the first row of the table

    private ArrayList<ArrayList<String>> table; // table itself (Collumns - Rows)
    private ArrayList<String> tableHeaders; // stores the name of the columns
    private String name; // name of the table itself

    public Table(String name) {

        table = new ArrayList<ArrayList<String>>();
        tableHeaders = new ArrayList<String>();
        this.name = name;

        Logger.Log("Table " + this.name + "has been created with hashcode: " + hashCode());
    }

    public Table(String name, ArrayList<String> columns) {

        for (String string : columns) {
            tableHeaders.add(string);
        }
        this.name = name;
        
        Logger.Log("Table " + this.name + "has been created with hashcode: " + hashCode());
    }

    public Table(String name, String[] columns){

        for (String string : columns) {
            tableHeaders.add(string);
        }
        this.name = name;

        Logger.Log("Table " + this.name + "has been created with hashcode: " + hashCode());
    }

    public void addColumn(String header) throws Exception { // adds a column to the table

        for (String name : tableHeaders) {
            if (name == null)
                continue;
            if (name.equals(header)) {
                Logger.Error("Name already exists");
                throw new Exception("Name already exists");
            }
        }

        tableHeaders.add(header);
        table.add(new ArrayList<String>());

        Logger.Log("Column added to " + name + " {" + this.getClass() + " @" + hashCode() + "}");
    }

    public void addRow(ArrayList<String> data) { // adds a row to the table

        for (ArrayList<String> column : table) {
            column.add(data.remove(0));
        }

        Logger.Log("Row added to " + name + " {" + this.getClass() + " @" + hashCode() + "}");
    }

    public String toString() { // a bit over-engineered? doest seem like it     //ToDo redo?

        String string = "\n" + name + ":\n";



        for (int i = 0; i < columnSize(); i++) {

            for (int j = 0; j < table.size(); j++) {

                string += j == 0 ? "|" : "";
                string += "\t" + (table.get(j).get(i) == null ? "-" : table.get(j).get(i)) + "\t | ";

            }
            string += "\n";
        }
        return string;
    }

    private int columnSize() { // Just to ease readability

        return table.get(0).size();

    }

    public ArrayList<String> getRow(int index) throws Exception { // returns the requested row      //ToDo redo?

        if (table.get(0).size() < index) {
            Logger.Error("Row does not exist");
            throw new Exception("Row does not exist");
        }
        ArrayList<String> row = new ArrayList<String>();

        for (ArrayList<String> column : table) {
            if (column.get(index) == null)
                row.add(null);
            else
                row.add(column.get(index));
        }
        return row;
    }

    public ArrayList<String> getColumn(int index) { // simple sol lol

        return table.get(index); // ToDo defencive programming

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getTableHeaders() {
        return tableHeaders;
    }

}