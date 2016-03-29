import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
   
    public static void main(String[] args) {
        DFAMachine DFA = new DFAMachine();
        
        Scanner scanner = new Scanner(System.in);
        String machineInput = "";
        String acceptingStateInput = "";
        String languageInput = "";
        String tupleRegex = "(\\d,\\d,\\d)";
        ArrayList<String> inputList = new ArrayList<String>();

        System.out.println("Enter DFA Machine States\n"
                + "Use the form {(old state, symbol, new state),"
                + "(old state, symbol, new state)...}\n"
                + "Example: {(1,1,2),(1,0,3),(2,1,3),(2,1,2)}");
        machineInput = scanner.nextLine(); //reads user input for the DFA machine

        System.out.println("Enter Accepting State(s)\n"
                + "Use the form state 1,state 2,...state n"
                + "\nExample: 2,4,6");
        acceptingStateInput = scanner.nextLine(); //reads user input for accepting states

        System.out.println("Enter Language Input"
                + "\nExample: 1010");
        languageInput = scanner.nextLine(); //reads user input for language

        Pattern pattern = Pattern.compile(tupleRegex);
        Matcher matcher = pattern.matcher(machineInput);
        
        //While user input for machine MATCHES the tuple regex form (d,d,d)
        //Add to input list in machine
        //Each element of input list is a string of form (d,d,d)
        while(matcher.find()) {
            inputList.add(matcher.group());
        }

        DFA.createMachine(inputList);
        DFA.addAcceptingStates(acceptingStateInput);
        DFA.runMachine(languageInput);
        DFA.printPath();
    }
}
