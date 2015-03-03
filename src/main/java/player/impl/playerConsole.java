package player.impl;

import java.util.Scanner;

/**
 * Created by alex.martinez on 2/11/15.
 */
public class PlayerConsole implements PlayerDisplayInterface {
    public String getInput() {
        String input;
        Scanner in = new Scanner(System.in);
        input = in.nextLine();
        return input;
    }
}
