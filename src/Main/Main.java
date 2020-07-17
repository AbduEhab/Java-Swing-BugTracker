package Main;

import java.util.ArrayList;

import Misc.Logger;
import Model.Chart;
import Model.Table;

public class Main {
    public static void main(String[] args) throws Exception {

        Logger.Declare("Program Start");
        Table temp = new Table("lol");
        temp.addColumn("5");
        temp.addColumn(null);
        temp.addColumn("null");
        ArrayList<String> data = new ArrayList<String>();
        data.add("0");
        data.add(null);
        data.add("l");
        temp.addRow(data);
        System.out.println(temp.getRow(0));
        temp.changeValue(1, 0, "laban");
        temp.display();
        // System.out.println(temp.toString());

        // Chart chart = new Chart("Chart 1");
        // chart.add("first", 1);
        // System.out.println(chart.getValueOf("first"));

        Logger.Declare("Program End");
    }

}