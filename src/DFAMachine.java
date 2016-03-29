
import java.util.ArrayList;
import java.util.StringTokenizer;


public class DFAMachine {
	private ArrayList<State> stateList; //holds all the states
	private String languageInput; //User input of the language to be read by the machine
        private State currentState; //Current state
        private ArrayList<Integer> path; //Holds a record of all the states traversed
	
	//Constructor for Machine
	public DFAMachine() {
		stateList = new ArrayList<State>();
                path = new ArrayList<Integer>();
	}
        
        //Factory method for Iterator
	public DFAMachineIterator getIterator() {
		return new DFAMachineIterator(stateList);
	}
        
        //Add state to machine
        public void addState (int n) {
		stateList.add(new State(n));
	}
        
        //Set the current state
        public void setCurrentState(int n) {
            currentState = this.findState(n);
        }
        
        //Records current state to path
        public void addPath() {
            path.add(currentState.getNumber());
        }
        
        //Prints path
        public void printPath() {
            System.out.println("DFA State Path");
            for (int i=0;i<path.size();i++) {
                System.out.print("(" + path.get(i) + ")" + " ");
            }
        }
        
        //Checks if a state exists in the machine
        public boolean stateExist(int n) {
		//Return true is stateList is empty
		if (stateList.isEmpty()) {
			return false;
		}

		DFAMachineIterator itr = this.getIterator();
		while (itr.hasNext()) {
			State current = itr.getState();
			if (current.getNumber() == n) {
				return true;
			}
			itr.next();
		}
		return false;
	}
        
        //Finds a specific state and return it
        public State findState(int n) {
            DFAMachineIterator itr = this.getIterator();
            State s = null;
            while (itr.hasNext()) {
                State current = itr.getState();
                if (current.getNumber() == n) {
                    s = current;
                    break;
                }
                itr.next();
            }
            return s;
        }
        
        //Parses User input commands and creates and add new states based on input
        public void createMachine(ArrayList<String> inputList) {
            for (String str: inputList) {
                StringTokenizer st = new StringTokenizer(str, ",");
                
                int oldState = Integer.parseInt(st.nextToken());
                int symbol = Integer.parseInt(st.nextToken());
                int newState = Integer.parseInt(st.nextToken());
                
                //Creates state if state does not currently exists
                if (!stateExist(oldState)) {
                    this.addState(oldState);
                }
                if (!stateExist(newState)) {
                    this.addState(newState);
                }
                
                //Adds transition information to state
                switch (symbol) {
                    case 0: findState(oldState).setZeroTransition(newState);
                    break;
                    case 1: findState(oldState).setOneTransition(newState);
                    break;
                    default: System.err.println("Error: "
                            + "Transition must be a 0 or 1");
                }
            }
        }
        
        //Reads user input and sets state(s) as accepting.
        public void addAcceptingStates(String acceptingStates) {
            int n;
            StringTokenizer st = new StringTokenizer(acceptingStates, ",");
            while (st.hasMoreTokens()) {
                n = Integer.parseInt(st.nextToken());
                findState(n).makeAccepting();
            }
        }
        
        //Reads user language input;
        //Assumes State 1 is always starting State
        //Checks the current state ZERO or ONE transition against user input
        //Moves the current state to the transition state
        public void runMachine(String languageInput) {
            this.setCurrentState(1); //Set starting state
            this.addPath();
            for (int i=0;i < languageInput.length();i++) {
                int symbol = Character.getNumericValue(languageInput.charAt(i));
                switch (symbol) {
                    case 0: setCurrentState(currentState.getZeroTransition());
                    break;
                    case 1: setCurrentState(currentState.getOneTransition());
                    break;
                    default: System.err.println("Error: No Transition available");
                }
                this.addPath();
            }
            
            //Checks if current state is accepted
            if (currentState.isAccepted) {
                System.out.println("The language is accepted by DFA");
            } else {
                System.out.println("The language is NOT accepted by the DFA");
            }
        }
}
