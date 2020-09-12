package Model;

public class Assistant {

    public static String process(String input) {

        String[] words = input.split(" ");
        String returnval = "";

        switch (words[1].toLowerCase()) {
            case "help":
                returnval = "Possible comannds: " + getPossibleCommands();
                return returnval;
        }
        return null;
    }

    private static String getPossibleCommands() {
        return "/n    - Create/Make {DataType} {Name}: to create a new datatype./n"
                .concat("   - Delete/Remove: to wipe a datatype from existance/n    -")
                .concat("   - Change    -");
    }
}