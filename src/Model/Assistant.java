package Model;

public class Assistant {

    public static String process(String input) {

        String[] words = input.split(" ");
        String returnval = "";

        switch (words[1].toLowerCase()) {
            case "help":
                returnval = " [] = UserData, {} = optional UserData./n/nPossible comannds: "
                        .concat(getPossibleCommands());
                return returnval;
            case "Make":
                return null;
            case "Create":
            return null;
        }
        return null;
    }

    private static String getPossibleCommands() {

        String table = " - Table:/n".concat("   - Make/Create (a) [Table] {Name}/n")
                .concat("   - ChangeTableName [TableName] [NewName]/n")
                .concat("   - AddColumn [ColumnName] (to) [TableName]/n")
                .concat("   - AddRow [RowElements seperated by a comma] (to) [Table]/n")
                .concat("   - DisplayTable [TableName]/n")
                .concat("   - ChangeHeader [TableName] [HeaderToChange] (to) [NewHeader]/n")
                .concat("   - ChangeValue [RowNumber] (in) [ColumnName] (in) [TableName]/n")
                .concat("   - ClearTable [TableName]/n").concat("   - Remove/Delete [Table] [TableName]");

        String chart = " - Chart:/n".concat("   - Make/Create (a) [Chart] {Name}/n")
                .concat("   - ChangeChartName [ChartName] [NewName]/n")
                .concat("   - AddValue [Label] [Value] (to) [ChartName]/n")
                .concat("   - ChamgeLabel [Label] [newLabel] (in) [ChartName]/n")
                .concat("   - ChangeValue [Label] [NewValue] (in) [ChartName]/n")
                .concat("   - Remove [Label] (in) [ChartName]/n").concat("   - TotalValue (of) [ChartName]/n")
                .concat("   - ValueOf [Label] (in) [ChartName]/n")
                .concat("   - PercentageOf [Label] (in) [ChartName]/n").concat("   - DisplayChart [ChartName]/n")
                .concat("   - Remove/Delete [Chart] [ChartName]/n");

        String bug = " - Bug:/n".concat("Make/Create (a) [Bug] {Name}/n")
                .concat("   - ChangeBugName [BugName] [NewName]/n").concat("   - SetBugProblem [BugName] [Problem]/n")
                .concat("   - SetBugPlatform [BugName] [WINDOWS, MACOS, LINUX, XBOXONE, PS4, ANDROID, IOS, NA]/n")
                .concat("   - SetBugPriority [BugName] [EXTREME, HIGH, MEDIUM, LOW, NON]/n")
                .concat("   - SetBugNote [BugName] [Note]/n").concat("   - Remove/Delete [Bug] [BugName]/n");

        String task = " - Task:/n".concat("Make/Create (a) [Task] {Name}/n")
                .concat("   - ChangeTaskName [TaskName] [NewName]/n")
                .concat("   - SetTaskProblem [TaskName] [Problem]/n")
                .concat("   - SetTaskPriority [TaskName] [EXTREME, HIGH, MEDIUM, LOW, NON]/n")
                .concat("   - SetTaskNote [TaskName] [Note]/n").concat("   - Remove/Delete [Task] [TaskName]/n")
                .concat("   - SetDueDate [TaskName] [Year,Month,Day]");

        return table + chart + bug + task;
    }
}