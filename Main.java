import java.util.*;

	public static void main(String[] args) {
		DFAMachine DFA = new DFAMachine();
		Scanner scanner = new Scanner(System.in);
		String input = "";
		String tupleRegex = "(\\(\\d,\\d,\\d\\))";
		ArrayList<String> inputList = new ArrayList<String>();
		System.out.println("Enter DFA Machine States\n
			Use the form {(old state, transition, new state),
			(old state, transition, new state)...}\n
			Example: {(1,1,2),(1,0,3),(2,1,3),(2,1,2)}");
		input = scanner.nextLine();
		Pattern pattern = pattern.compile(tupleRegex);
		Matcher matcher = pattern.matcher(input);
		while(matcher.find()) {
    		inputList.add(matcher.group());
    	}
	}
}