package Main;

import java.util.Scanner;

import Misc.Logger;
import Model.Assistant;
import View.BasicView;

public class Main {
    public static void main(String[] args) throws Exception {
        Logger.Declare("Program Start");
        Logger.show = false;
        var assis = new Assistant();

        Scanner sc = new Scanner(System.in);

        while (true) {
            var c = sc.nextLine();
            System.out.println(assis.process(c));
        }

        // new BasicView();

    }

}