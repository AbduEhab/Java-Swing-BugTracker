package Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import Misc.Logger;
import Model.Bug;
import Model.Chart;
import Model.Data;
import Model.Table;
import Model.Task;

public class ModelTests {

    Data data = new Data();
    Table table = new Table();
    Chart chart = new Chart();
    Bug bug = new Bug();
    Task task = new Task();

    @Test
    @DisplayName("Add Column Method (Table)")
    @Timeout(5)
    void addColumnTable() throws Exception {

        table.addColumn("2");
        try {
            assertEquals("2", table.getTableHeaders().get(0), "Couldn't get column");
        } catch (Exception e) {
            fail("Method threw an Exception");
        }
        try {
            table.addColumn("2");
        } catch (Exception e) {
            assertEquals(true, true, "Method thew exception on dublicate add call");
            return;
        }
        assertEquals(true, false, "Method didn't throw an exception on dublicate add call");
    }

    @Test
    @DisplayName("Change Header Method (Table)")
    @Timeout(5)
    void changeHeaderTable() throws Exception {

        table.addColumn("2");
        table.addColumn("1");
        table.changeHeader("2", "1");

        try {
            assertEquals("1", table.getTableHeaders().get(0), "headers weren't changed");
        } catch (Exception e) {
            fail("Method threw an exception");
        }
    }

    @Test
    @DisplayName("Change Value Method (Table)")
    @Timeout(5)
    void changeValueTable() throws Exception {

        table.addColumn("2");
        ArrayList<String> row = new ArrayList<String>();
        row.add("1");
        table.addRow(row);
        table.changeValue(0, 0, "3");

        try {
            assertEquals("3", table.getRow(0).get(0), "Value didn't changed");
        } catch (Exception e) {
            fail("Method threw an exception");
        }
    }

    @Test
    @DisplayName("Add Row Method (Table)")
    @Timeout(5)
    void addRowTable() throws Exception {

        ArrayList<String> row = new ArrayList<String>();
        table.addColumn("2");
        row.add("1");
        row.add("1");
        table.addRow(row);

        try {
            assertEquals("1", table.getRow(0).get(0), "Couldn't get the columns");
        } catch (Exception e) {
            Logger.Log(e.getMessage());
            fail("Method threw an Exception");
        }
    }

    @Test
    @DisplayName("Get Label Method (Chart)")
    @Timeout(5)
    void getLabelChart() {
        chart.add("1", 1);
        chart.add("2", 3);
        try {
            assertEquals("1", chart.getLabel(0), "Label was not found");
            assertEquals("2", chart.getLabel(1), "Label was not found");
        } catch (Exception e) {
            fail("Method threw an Exception");
        }

    }

    @Test
    @DisplayName("Get Value Method (Chart)")
    @Timeout(5)
    void getvalueChart() {
        chart.add("1", 1);
        chart.add("2", 3);
        try {
            assertEquals(1, chart.getValue(0), "Value was incorrect");
            assertEquals(3, chart.getValue(1), "Value was incorrect");
        } catch (Exception e) {
            fail("Method threw an Exception");
        }
    }

    @Test
    @DisplayName("Get ValueOf Method (Chart)")
    @Timeout(5)
    void getvalueOfChart() {
        chart.add("1", 1);
        chart.add("2", 3);
        try {
            assertEquals(1, chart.getValueOf("1"), "Value was incorrect");
            assertEquals(3, chart.getValueOf("2"), "Value was incorrect");
        } catch (Exception e) {
            fail("Method threw an Exception");
        }
    }

    @Test
    @DisplayName("Get TotalValue Method (Chart)")
    @Timeout(5)
    void totalvalueChart() {
        chart.add("1", 1);
        chart.add("2", 3);
        try {
            assertEquals(4, chart.totalValue(), "Total value was incorrect");
        } catch (Exception e) {
            fail("Method threw an Exception");
        }
    }

    @Test
    @DisplayName("Get PercentageOf Method (Chart)")
    @Timeout(5)
    void getPercentageOfChart() {
        chart.add("1", 1);
        chart.add("2", 3);
        try {
            assertEquals(25, chart.getPercentageOf("1"), "Percentage was incorrect");
        } catch (Exception e) {
            fail("Method threw an Exception");
        }
    }

    @Test
    @DisplayName("Change Label Method (Chart)")
    @Timeout(5)
    void changeLabelChart() throws Exception {
        chart.add("1", 1);
        chart.add("2", 3);
        chart.change("1", "2");
        try {
            assertEquals(75, chart.getPercentageOf("1"), "Percentage was incorrect");
        } catch (Exception e) {
            fail("Method threw an Exception");
        }
    }

    @Test
    @DisplayName("Change Value Method (Chart)")
    @Timeout(5)
    void changeValueChart() throws Exception {
        chart.add("1", 1);
        chart.add("2", 3);
        chart.change("1", 7);
        try {
            assertEquals(70, chart.getPercentageOf("1"), "Percentage was incorrect");
        } catch (Exception e) {
            fail("Method threw an Exception");
        }
    }

    @Test
    @DisplayName("Remove Label Method (Chart)")
    @Timeout(5)
    void removeChart() throws Exception {
        chart.add("1", 1);
        chart.add("2", 3);
        chart.remove("2");
        try {
            assertEquals(100, chart.getPercentageOf("1"), "Label was not removed");
        } catch (Exception e) {
            fail("Method threw an Exception");
        }
    }

    @Test
    @DisplayName("Set Number Method (Bug)")
    @Timeout(5)
    void SetNumberBug() throws Exception {
        data.AddBug("1", null, null, null, null);
        data.AddBug("2", null, null, null, null);
        data.getBug("1").setNumber(2, data.getBugs());
        try {
            assertEquals(2, data.getBug("1").getNumber(), "Bug's number was not changed correctly");
        } catch (Exception e) {
            fail("Method threw an Exception");
        }
    }

    @Test
    @DisplayName("Set Number Method (Task)")
    @Timeout(5)
    void SetNumberTask() throws Exception {
        data.AddTask("1", null, null, 0, 0, 0);
        data.AddTask("1", null, null, 0, 0, 0);
        data.getTask("1").setNumber(2, data.getTasks());
        try {
            assertEquals(2, data.getTask("1").getNumber(), "Task's number was not changed correctly");
        } catch (Exception e) {
            fail("Method threw an Exception");
        }
    }

    @Test
    @DisplayName("Get Object Method (Data)")
    @Timeout(5)
    void getObjectData() {
        data.AddTask("2", null, null, 0, 0, 0);
        data.AddTable("2", null);
        data.AddChart("2");
        data.AddBug("2", null, null, null, null);

        try {
            assertEquals(data.getBugs().get("2"), data.getBug("2"));
        } catch (Exception e) {
            fail("Could not get the Bug");
        }
        try {
            assertEquals(data.getTables().get("2"), data.getTable("2"));
        } catch (Exception e) {
            fail("Could not get the Table");
        }
        try {
            assertEquals(data.getTasks().get("2"), data.getTask("2"));
        } catch (Exception e) {
            fail("Could not get the Task");
        }
        try {
            assertEquals(data.getCharts().get("2"), data.getChart("2"));
        } catch (Exception e) {
            fail("Could not get the Chart");
        }
    }

    @Test
    @DisplayName("Remove Object Method (Data)")
    @Timeout(50)
    void dataRemove() {

        data.AddTask("2", null, null, 0, 0, 0);
        data.remove(data.getTasks().get("2"));
        assertEquals(0, data.getTasks().size(), "Task was not removed");

        data.AddTable("2", null);
        data.remove(data.getTables().get("2"));
        assertEquals(0, data.getTables().size(), "Task was not removed");

        data.AddChart("2");
        data.remove(data.getCharts().get("2"));
        assertEquals(0, data.getCharts().size(), "Task was not removed");

        data.AddBug("2", null, null, null, null);
        data.remove(data.getBugs().get("2"));
        assertEquals(0, data.getBugs().size(), "Task was not removed");
    }

    @Test
    @DisplayName("Add Object Method (Data)")
    @Timeout(5)
    void dataAdd() {

        data.AddTable("2", null);
        assertEquals(1, data.getTables().size(), "Table not added");

        data.AddTask("2", null, null, 0, 0, 0);
        assertEquals(1, data.getTasks().size(), "Task not added");

        data.AddChart("2");
        assertEquals(1, data.getCharts().size(), "Chart not added");

        data.AddBug("2", null, null, null, null);
        assertEquals(1, data.getBugs().size(), "Bug not added");
    }

}