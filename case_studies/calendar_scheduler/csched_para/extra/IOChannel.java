package conf;

import java.util.Scanner;

public class IOChannel {

    private Object owner;
    /**
     * Construct a system I/O channel with the given input policy, owned by the given owner
     */
    public IOChannel(se.chalmers.paragon.runtime.Policy pol, Object owner) {
        this.owner = owner;
    }

    /**
     * Read a line of input in with the channel's input policy
     */
    public String readLine() {
        Scanner in = new Scanner(System.in);
        try {
            String input = in.nextLine();
            in.close();
            return input;
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * Print string output to sysout at the owner's level of policy
     * 
     * @output the string to print
     */
    public void print(String output) {
        // "[" + owner.toString() + "] "+ 
        System.out.print(output);
    }

    /**
     * Print a line of output to sysout at the owner's level of policy
     * 
     * @output the string to print, not including newline
     */
    public void println(String output) {
        //"[" + owner.toString() + "] " +
        System.out.println(output);
    }

    public void println() {
        System.out.println();
    }
}