package Model;

import java.io.Serializable;
import java.util.ArrayList;

import Misc.Logger;

public class Chart implements Serializable {

    private String name;

    private int size = 0; // number of elements in the chart
    private ArrayList<Double> percentages; // array of the percentages of each label
    private ArrayList<Double> values; // array with the values of each label
    private ArrayList<String> labels; // array with the labels in the chart

    public Chart() {
        values = new ArrayList<Double>();
        labels = new ArrayList<String>();
        percentages = new ArrayList<Double>();
        name = "Unnamed Chart";

    }

    public Chart(String name) {
        values = new ArrayList<Double>();
        labels = new ArrayList<String>();
        percentages = new ArrayList<Double>();
        this.name = name;

        Logger.Log("Chart " + this.name + " has been created with hashcode: " + hashCode());
    }

    public Chart(String name, ArrayList<Double> values, ArrayList<String> labels) {
        this(name);
        this.values = values;
        this.labels = labels;
        size = labels.size();

        Logger.Log("Chart " + this.name + " has been created with hashcode: " + hashCode());
    }

    public void add(String label, double value) { // adds a label with a certain value

        labels.add(label);
        values.add(value);

        if (size == 0) {
            percentages.add(100.0);
            size++;
        } else {
            size++;
            computePercentages();

        }

        Logger.Log("Label Added to " + name + " (" + this.getClass().getSimpleName() + " @" + hashCode() + "}");
    }

    public void change(String label, String newLabel) throws Exception { // changes the name of a label

        if (!labels.contains(label)) {

            Logger.Error("Lable {" + label + "} does not exist in chart: " + name + " @" + hashCode());
            throw new Exception("Lable {" + label + "} does not exist in chart: " + name + " @" + hashCode());

        }

        if (labels.contains(newLabel)) {
            int i = labels.indexOf(label);
            labels.set(labels.indexOf(newLabel), label);
            labels.set(i, newLabel);
        } else
            labels.set(labels.indexOf(label), newLabel);

        Logger.Warn("Label " + label + " in chart " + name + " @" + hashCode() + " has been changed to: " + newLabel);
    }

    public void change(String label, double value) throws Exception { // changes the value assigned to a label

        if (!labels.contains(label)) {

            Logger.Error("Lable {" + label + "} does not exist in chart: " + name + " @" + hashCode());
            throw new Exception("Lable {" + label + "} does not exist in chart: " + name + " @" + hashCode());

        }

        values.set(labels.indexOf(label), value);
        computePercentages();

        Logger.Warn("Value of " + label + " in chart " + name + " @" + hashCode() + " has been changed to: " + value);

    }

    public void remove(String label) throws Exception { // removes the label along with its value

        if (!labels.contains(label)) {

            Logger.Error("Lable {" + label + "} does not exist in chart: " + name);
            throw new Exception("Lable {" + label + "} does not exist in chart: " + name);

        }

        percentages.remove(percentages.get(labels.indexOf(label)));
        values.remove(values.get(labels.indexOf(label)));
        labels.remove(labels.get(labels.indexOf(label)));
        size--;
        computePercentages();

        Logger.Warn("Label " + label + " in chart " + name + " @" + hashCode() + " has been removed");

    }

    private void computePercentages() { // fixes the percentages after you add or remove a value

        percentages = new ArrayList<Double>();

        for (double value : values) {
            percentages.add((value / totalValue()) * 100.0);
        }

    }

    public int totalValue() { // returns the sum of all the values

        int total = 0;
        for (Double val : values) {
            if (!(val == null))
                total += val;
        }
        return total;
    }

    public String getLabel(int index) throws Exception {// gets the label of a certain index, i dont know if i'll use it
                                                        // but im coding it anyway

        if (size <= index) {
            Logger.Error("label @" + index + " does not exist in: " + getClass().getSimpleName() + " " + name + " @"
                    + hashCode());
            throw new Exception("label @" + index + " does not exist in: " + getClass().getSimpleName() + " " + name
                    + " @" + hashCode());
        }

        return labels.get(index);
    }

    public Double getValue(int index) throws Exception { // gets the value of a certain index, i dont know if i'll use
                                                         // it
                                                         // but im coding it anyway

        if (size <= index) {
            Logger.Error("Value @" + index + " does not exist in: " + getClass().getSimpleName() + " " + name + " @"
                    + hashCode());
            throw new Exception("Value @" + index + " does not exist in: " + getClass().getSimpleName() + " " + name
                    + " @" + hashCode());
        }

        return values.get(index);
    }

    public Double getValueOf(String label) throws Exception { // gets the value of a certain label

        boolean f = false;
        for (String name : labels) {
            if (f) {
                break;
            } else if (name.equals(label)) {
                f = true;
            }
        }

        if (!f) {
            Logger.Error("Lable {" + label + "} does not exist in chart: " + getClass().getSimpleName() + " " + name
                    + " @" + hashCode());
            throw new Exception("Lable {" + label + "} does not exist in chart: " + getClass().getSimpleName() + " "
                    + name + " @" + hashCode());
        }

        return values.get(labels.indexOf(label));
    }

    public double getPercentageOf(String label) { // gets the percentage of a certain label

        return percentages.get(labels.indexOf(label));
    }

    public boolean clearChart() { // erases all data on the chart

        values = new ArrayList<Double>();
        labels = new ArrayList<String>();
        percentages = new ArrayList<Double>();
        Logger.Warn("Chart: " + name + " @" + hashCode() + " has been cleared");
        return true;
    }

    public void display() {
        System.out.println(toString());
    }

    public String toString() {

        String string = "\n" + getClass().getSimpleName() + " " + name + ":\n";

        for (String label : labels) {
            string += label + ": " + percentages.get(labels.indexOf(label)) + "% with value of: "
                    + values.get(labels.indexOf(label)) + "\n";
        }

        return string;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name == null ? "" : name;
        Logger.Log("Chart " + this.name + " has been renamed to: " + name == null ? "" : name);

    }

    public ArrayList<Double> getPercentages() {
        return percentages;
    }

}