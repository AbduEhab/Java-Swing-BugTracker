package Model;

import java.util.ArrayList;

import Misc.Logger;

public class Chart implements Component {

    private int size = 0; // number of elements in the chart
    private ArrayList<Double> percentages; // array of the percentages of each label
    private ArrayList<Integer> values; // array with the values of each label
    private ArrayList<String> labels; // array with the labels in the chart

    private String name;

    public Chart(String name) {
        values = new ArrayList<Integer>();
        labels = new ArrayList<String>();
        percentages = new ArrayList<Double>();
        this.name = name;

        Logger.Log("Chart " + this.name + "has been created with hashcode: " + hashCode());
    }

    public Chart(String name, ArrayList<Integer> values, ArrayList<String> labels) {
        this.values = values;
        this.labels = labels;
        this.name = name;
        percentages = new ArrayList<Double>();
        size = labels.size();

        Logger.Log("Chart " + this.name + "has been created with hashcode: " + hashCode());
    }

    public void add(String label, int value) { // adds a label with a certain value

        labels.add(label);
        values.add(value);

        if (size == 0) {
            percentages.add(100.0);
            size++;
        } else {
            size++;
            computePercentages();

        }

        Logger.Log("Label Added to " + name + " (" + this.getClass() + " @" + hashCode() + "}");
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

    }

    public void change(String label, int value) throws Exception { // changes the value assigned to a label

        if (!labels.contains(label)) {

            Logger.Error("Lable {" + label + "} does not exist in chart: " + name);
            throw new Exception("Lable {" + label + "} does not exist in chart: " + name);

        }

        values.add(labels.indexOf(label), value);
        computePercentages();

    }

    public void change(String label, String newLabel) throws Exception { // changes the name of a label

        if (!labels.contains(label)) {

            Logger.Error("Lable {" + label + "} does not exist in chart: " + name);
            throw new Exception("Lable {" + label + "} does not exist in chart: " + name);

        }

        labels.add(labels.indexOf(label), newLabel);

    }

    private void computePercentages() { // fixes the percentages after you add or remove a value

        for (int i = 0; i < values.size(); i++) {
            percentages.add(i, (values.size() / totalValue()) * 100.0);
        }

    }

    public int totalValue() { // returns the sum of all the values

        int total = 0;
        for (Integer val : values) {
            if (!(val == null))
                total += val;
        }
        return total;
    }

    public String getLabel(int index) throws Exception {// gets the label of a certain index, i dont know if i'll use it
                                                        // but im coding it anyway

        if (size <= index) {
            Logger.Error("label @" + index + " does not exist in: " + name);
            throw new Exception("label @" + index + " does not exist in: " + name);
        }

        return labels.get(index);
    }

    public int getValue(int index) throws Exception { // gets the value of a certain index, i dont know if i'll use it
                                                      // but im coding it anyway

        if (size <= index) {
            Logger.Error("Value @" + index + " does not exist in: " + name);
            throw new Exception("Value @" + index + " does not exist in: " + name);
        }

        return values.get(index);
    }

    public int getValueOf(String label) throws Exception { // gets the value of a certain label

        boolean f = false;
        for (String name : labels) {
            if (f) {
                break;
            } else if (name.equals(label)) {
                f = true;
            }
        }

        if (!f) {
            Logger.Error("Lable {" + label + "} does not exist in chart: " + name);
            throw new Exception("Lable {" + label + "} does not exist in chart: " + name);
        }

        return values.get(labels.indexOf(label));
    }

    public double getPercentageOf(String label) { // gets the percentage of a certain label

        return percentages.get(labels.indexOf(label));
    }

    public String toString() {

        String string = "";

        for (String label : labels) {
            string += "| " + label + ": " + percentages.get(labels.indexOf(label)) + "% with value of: "
                    + values.get(labels.indexOf(label)) + " ";
        }

        string += "|";

        return string;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!(name == null))
            this.name = name;
    }

    public ArrayList<Double> getPercentages() {
        return percentages;
    }

}