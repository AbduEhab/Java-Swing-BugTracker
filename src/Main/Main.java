package Main;

import java.util.ArrayList;

import Misc.Logger;
import Model.Chart;
import Model.Priority;
import Model.Table;
import Model.Task;

public class Main {
    public static void main(String[] args) throws Exception {
        Logger.Declare("Program Start");

        // Table temp = new Table("lol");
        // temp.addColumn("5");
        // temp.addColumn(null);
        // temp.addColumn("null");
        // ArrayList<String> data = new ArrayList<String>();
        // data.add("0");
        // data.add(null);
        // data.add("l");
        // temp.addRow(data);
        // System.out.println(temp.getRow(0));
        // System.out.println(temp.getTableHeaders());
        // temp.changeValue(0, 0, "laban");
        // temp.changeHeader("5", "ja");
        // temp.display();
        // System.out.println(temp.toString());

        // Chart chart = new Chart("Chart 1");
        // chart.add("first", 1);
        // chart.add("sec", 2);
        // System.out.println(chart.getValueOf("first"));
        // System.out.println(chart.toString());

        Task l = new Task();
        l.setPriority(Priority.EXTREME);
        l.setDueDate(1, 1, 1);

        Logger.Declare("Program End");
    }

}