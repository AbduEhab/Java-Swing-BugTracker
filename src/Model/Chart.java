package Model;

import java.util.ArrayList;

import Misc.Logger;

public class Chart {

    private int size = 0;
    private ArrayList<Integer> values;
    private ArrayList<String> labels;
    private String name;

    public Chart(String name) {
        values = new ArrayList<Integer>();
        labels = new ArrayList<String>();
        this.name = name;
    }

    public Chart(String name, ArrayList<Integer> values, ArrayList<String> labels) {
        this.values = values;
        this.labels = labels;
        this.name = name;
        size = labels.size();
    }

    public void add(String label, int value) throws Exception {

        if (totalValue() == 100 || value <= 0) {
            Logger.Error("Invalid vlaue");
            throw new Exception("Invalid vlaue");
        }

        labels.add(label);
        if (size == 0)
            values.add(value);
        else if (100 - totalValue() < value)
            values.add(100 - totalValue());
        else
            values.add(value);

        size++;
        Logger.Log("Label Added to " + name + " (" + this.getClass() + " @" + hashCode() + "}");
    }

    private int totalValue() {

        int total = 0;
        for (Integer val : values) {
            total += val;
        }
        return total;
    }

    public String getLabel(int index) throws Exception {

        if (size < index + 1) {
            Logger.Error("label @" + index + " does not exist in: " + name);
            throw new Exception("label @" + index + " does not exist in: " + name);
        }
        return labels.get(index);
    }

    public int getValue(int index) throws Exception {

        if (size < index + 1) {
            Logger.Error("Value @" + index + " does not exist in: " + name);
            throw new Exception("Value @" + index + " does not exist in: " + name);
        }
        return values.get(index);

    }

    public int getValue(String label) throws Exception {

        boolean f = false;
        for (String name : labels) {
            if (f) {
                break;
            } else if (name == label) {
                f = true;
            }
        }

        if (!f) {
            Logger.Error("Lable {" + label + "} does not exist in chart: " + name);
            throw new Exception("Lable {" + label + "} does not exist in chart: " + name);
        }

        return values.get(labels.indexOf(label));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}