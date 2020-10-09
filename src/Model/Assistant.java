package Model;

import java.util.ArrayList;

public class Assistant {

    Data model;

    public Assistant() {
        model = new Data();
    }

    public String process(String input) throws Exception {

        String[] words = input.split(" ");
        String returnval = "Invalid Input";

        if (words.length == 1 && !words[0].equals("help"))
            return returnval;

        if (words[0].toLowerCase().equals("help")) {
            returnval = " [] = UserData, {} = optionalData.\n\nPossible comannds: ".concat(getPossibleCommands());
            return returnval;
        }

        switch (words[0].toLowerCase()) {
            /************************************** */
            case "make":
                if (words.length != 3)
                    return returnval;
                switch (words[1].toLowerCase()) {
                    case "table":
                        model.AddTable(words[2], null);
                        returnval = "New Table created with name: " + words[2];
                        return returnval;
                    case "chart":
                        model.AddChart(words[2]);
                        returnval = "New Chart created with name: " + words[2];
                        return returnval;
                    case "bug":
                        model.AddBug(words[2], null, null, null, null);
                        returnval = "New Table created with name: " + words[2];
                        return returnval;
                    case "task":
                        model.AddTask(words[2], null, null, 0, 0, 0);
                        returnval = "New Table created with name: " + words[2];
                        return returnval;
                }

            case "create":
                if (words.length != 3)
                    return returnval;
                switch (words[1].toLowerCase()) {
                    case "table":
                        model.AddTable(words[2], null);
                        returnval = "New Table created with name: " + words[2];
                        return returnval;
                    case "chart":
                        model.AddChart(words[2]);
                        returnval = "New Chart created with name: " + words[2];
                        return returnval;
                    case "bug":
                        model.AddBug(words[2], null, null, null, null);
                        returnval = "New Table created with name: " + words[2];
                        return returnval;
                    case "task":
                        model.AddTask(words[2], null, null, 0, 0, 0);
                        returnval = "New Table created with name: " + words[2];
                        return returnval;
                }
                /************************************** */
            case "remove":
                if (words.length != 3)
                    return returnval;
                switch (words[1].toLowerCase()) {
                    case "table":
                        model.remove(model.getTable(words[2]));
                        returnval = "Table: " + words[2] + " has been removed";
                        return returnval;
                    case "chart":
                        model.remove(model.getChart(words[2]));
                        returnval = "chart: " + words[2] + " has been removed";
                        return returnval;
                    case "bug":
                        model.remove(model.getBug(words[2]));
                        returnval = "bug: " + words[2] + " has been removed";
                        return returnval;
                    case "task":
                        model.remove(model.getTask(words[2]));
                        returnval = "task: " + words[2] + " has been removed";
                        return returnval;
                }

            case "delete":
                if (words.length != 3)
                    return returnval;
                switch (words[1].toLowerCase()) {
                    case "table":
                        model.remove(model.getTable(words[2]));
                        returnval = "Table: " + words[2] + " has been removed";
                        return returnval;
                    case "chart":
                        model.remove(model.getChart(words[2]));
                        returnval = "chart: " + words[2] + " has been removed";
                        return returnval;
                    case "bug":
                        model.remove(model.getBug(words[2]));
                        returnval = "bug: " + words[2] + " has been removed";
                        return returnval;
                    case "task":
                        model.remove(model.getTask(words[2]));
                        returnval = "task: " + words[2] + " has been removed";
                        return returnval;
                }
                /************************************** */
            case "changetablename":
                if (words.length != 3)
                    return returnval;

                model.getTable(words[1]).setName(words[2]);

                return returnval;
            case "addcolumn":
                if (words.length != 3)
                    return returnval;

                model.getTable(words[2]).addColumn(words[1]);

                return returnval;
            case "addrow":
                if (words.length < 3)
                    return returnval;

                ArrayList<String> inerStrings = new ArrayList<String>();
                for (int i = 0; i < words.length - 1; i++) {
                    if (words[i].equals(","))
                        inerStrings.add(words[i + 1]);
                }

                model.getTable(words[words.length - 1]).addRow(inerStrings);

                return returnval;
            case "displaytable":
                if (words.length != 3)
                    return returnval;

                model.getTable(words[1]).display();

                return returnval;
            case "changeheader":
                if (words.length != 4)
                    return returnval;

                model.getTable(words[1]).changeHeader(words[2], words[3]);

                return returnval;
            case "changevalue":
                if (words.length != 5)
                    return returnval;

                model.getTable(words[3]).changeValue(Integer.parseInt(words[1]), words[2], words[3]);

                return returnval;
            case "cleartable":
                if (words.length != 3)
                    return returnval;

                model.getTable(words[2]).addColumn(words[3]);

                return returnval;
            /************************************** */
            case "changechartname":
                if (words.length != 3)
                    return returnval;

                model.getChart(words[1]).setName(words[2]);

                return returnval;
            case "addvalue":
                if (words.length != 4)
                    return returnval;

                model.getChart(words[3]).add(words[1], Double.parseDouble(words[2]));

                return returnval;
            case "chamgelabel":
                if (words.length != 4)
                    return returnval;

                model.getChart(words[3]).change(words[1], words[2]);

                return returnval;
            case "changevalueof":
                if (words.length != 4)
                    return returnval;

                model.getChart(words[3]).change(words[1], Double.parseDouble(words[2]));

                return returnval;
            case "removelabel":
                if (words.length != 3)
                    return returnval;

                model.getChart(words[2]).remove(words[1]);

                return returnval;
            case "valueof":
                if (words.length != 3)
                    return returnval;

                model.getChart(words[2]).getValueOf(words[1]);

                return returnval;
            case "displaychart":
                if (words.length != 3)
                    return returnval;

                model.getChart(words[1]).display();

                return returnval;
            case "totalvalue":
                if (words.length < 3)
                    return returnval;

                model.getChart(words[words.length - 1]).totalValue();

                return returnval;
            case "percentageof":
                if (words.length != 3)
                    return returnval;

                model.getChart(words[2]).getPercentageOf(words[1]);

                return returnval;
            /************************************** */
            case "changebugname":
                if (words.length != 3)
                    return returnval;

                model.getBug(words[1]).setName(words[2]);

                return returnval;
            case "setbugplatform":
                if (words.length != 3)
                    return returnval;

                Platform plat = null;

                switch (words[2].toUpperCase()) {
                    case "WINDOWS":
                        plat = plat.WINDOWS;
                        return returnval;
                    case "MACOS":
                        plat = plat.MACOS;
                        return returnval;
                    case "LINUX":
                        plat = plat.LINUX;
                        return returnval;
                    case "XBOXONE":
                        plat = plat.XBOXONE;
                        return returnval;
                    case "PS4":
                        plat = plat.PS4;
                        return returnval;
                    case "ANDROID":
                        plat = plat.ANDROID;
                        return returnval;
                    case "IOS":
                        plat = plat.IOS;
                        return returnval;
                    case "NA":
                        plat = plat.NA;
                        return returnval;

                    default:
                        plat = plat.NA;

                }

                model.getBug(words[1]).setPlatform(plat);

                return returnval;
            case "setbugpriority":

                if (words.length != 3)
                    return returnval;

            {
                Priority pri = null;

                switch (words[2].toUpperCase()) {
                    case "EXTREME":
                        pri = pri.EXTREME;
                        return returnval;
                    case "HIGH":
                        pri = pri.HIGH;
                        return returnval;
                    case "MEDIUM":
                        pri = pri.MEDIUM;
                        return returnval;
                    case "LOW":
                        pri = pri.LOW;
                        return returnval;
                    case "NON":
                        pri = pri.NON;
                        return returnval;

                    default:
                        pri = pri.NON;

                }
                model.getBug(words[1]).setPriority(pri);
            }

                return returnval;
            case "setbugnote":
                if (words.length != 3)
                    return returnval;

                model.getBug(words[1]).setNote(words[2]);
                ;

                return returnval;
            case "setbugproblem":
                if (words.length != 3)
                    return returnval;

                model.getBug(words[1]).setProblem(words[2]);

                return returnval;
            /************************************** */
            case "changetaskname":
                if (words.length != 3)
                    return returnval;

                model.getTask(words[1]).setName(words[2]);

                return returnval;
            case "settaskpriority":
                if (words.length != 3)
                    return returnval;

            {
                Priority pri = null;

                switch (words[2].toUpperCase()) {
                    case "EXTREME":
                        pri = pri.EXTREME;
                        return returnval;
                    case "HIGH":
                        pri = pri.HIGH;
                        return returnval;
                    case "MEDIUM":
                        pri = pri.MEDIUM;
                        return returnval;
                    case "LOW":
                        pri = pri.LOW;
                        return returnval;
                    case "NON":
                        pri = pri.NON;
                        return returnval;

                    default:
                        pri = pri.NON;

                }

                model.getTask(words[1]).setPriority(pri);
            }

                return returnval;
            case "settasknote":
                if (words.length != 3)
                    return returnval;

                model.getTask(words[1]).setNote(words[2]);
                ;

                return returnval;
            case "setduedate":
                if (words.length != 3)
                    return returnval;

                String[] date = words[2].split(",");

                model.getTask(words[1]).setDueDate(Integer.parseInt(date[0]), Integer.parseInt(date[1]),
                        Integer.parseInt(date[2]));

                return returnval;
            /************************************** */
            default:
                return returnval;
        }

    }

    private String getPossibleCommands() {

        String table = " - Table:\n".concat("   - Make/Create [Table] {Name}" + "\n")
                .concat("   - ChangeTableName [TableName] [NewName]\n")
                .concat("   - AddColumn [ColumnName] [TableName]\n")
                .concat("   - AddRow [RowElements seperated by a comma] to [Table]\n")
                .concat("   - DisplayTable [TableName]\n")
                .concat("   - ChangeHeader [TableName] [HeaderToChange] [NewHeader]\n")
                .concat("   - ChangeValue [RowNumber] [ColumnName] [TableName] [NewValue]\n")
                .concat("   - ClearTable [TableName]\n").concat("   - Remove/Delete [Table] [TableName]\n");

        String chart = " - Chart:\n".concat("   - Make/Create [Chart] {Name}\n")
                .concat("   - ChangeChartName [ChartName] [NewName]\n")
                .concat("   - AddValue [Label] [Value] to [ChartName]\n")
                .concat("   - ChamgeLabel [Label] [newLabel] [ChartName]\n")
                .concat("   - ChangeValueOf [Label] [NewValue] [ChartName]\n")
                .concat("   - RemoveLabel [Label] [ChartName]\n").concat("   - TotalValue of [ChartName]\n")
                .concat("   - ValueOf [Label] [ChartName]\n").concat("   - PercentageOf [Label] [ChartName]\n")
                .concat("   - DisplayChart [ChartName]\n").concat("   - Remove/Delete [Chart] [ChartName]\n");

        String bug = " - Bug:\n".concat("Make/Create (a) [Bug] {Name}\n")
                .concat("   - ChangeBugName [BugName] [NewName]\n").concat("   - SetBugProblem [BugName] [Problem]\n")
                .concat("   - SetBugPlatform [BugName] [WINDOWS, MACOS, LINUX, XBOXONE, PS4, ANDROID, IOS, NA]\n")
                .concat("   - SetBugPriority [BugName] [EXTREME, HIGH, MEDIUM, LOW, NON]\n")
                .concat("   - SetBugNote [BugName] [Note]\n").concat("   - Remove/Delete [Bug] [BugName]\n");

        String task = " - Task:\n".concat("Make/Create (a) [Task] {Name}\n")
                .concat("   - ChangeTaskName [TaskName] [NewName]\n")
                .concat("   - SetTaskPriority [TaskName] [EXTREME, HIGH, MEDIUM, LOW, NON]\n")
                .concat("   - SetTaskNote [TaskName] [Note]\n").concat("   - Remove/Delete [Task] [TaskName]\n")
                .concat("   - SetDueDate [TaskName] [Year,Month,Day] \n");

        return table + chart + bug + task;
    }
}