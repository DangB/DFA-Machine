
import java.util.ArrayList;
import java.util.StringTokenizer;


public class DFAMachine {
	private ArrayList<State> stateList;
	private String languageInput;
        private State currentState;

	public DFAMachine() {
		stateList = new ArrayList<State>();
	}
        
	public DFAMachineIterator getIterator() {
		return new DFAMachineIterator(stateList);
	}
        
        public void addState (int n) {
		stateList.add(new State(n));
	}
        
        public void setCurrentState(int n) {
            currentState = this.findState(n);
        }
        
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
        
        public void createMachine(ArrayList<String> inputList) {
            for (String str: inputList) {
                StringTokenizer st = new StringTokenizer(str, ",");
                
                int oldState = Integer.parseInt(st.nextToken());
                int symbol = Integer.parseInt(st.nextToken());
                int newState = Integer.parseInt(st.nextToken());
                
                if (!stateExist(oldState)) {
                    this.addState(oldState);
                }
                if (!stateExist(newState)) {
                    this.addState(newState);
                }
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
        
        public void addAcceptingStates(String acceptingStates) {
            int n;
            StringTokenizer st = new StringTokenizer(acceptingStates, ",");
            while (st.hasMoreTokens()) {
                n = Integer.parseInt(st.nextToken());
                findState(n).makeAccepting();
            }
        }
        
        public void runMachine(String languageInput) {
            this.setCurrentState(1); //Set starting state
            
            for (int i=0;i > languageInput.length();i++) {
                int symbol = Character.getNumericValue(languageInput.charAt(i));
                switch (symbol) {
                    case 0: setCurrentState(currentState.getZeroTransition());
                    break;
                    case 1: setCurrentState(currentState.getOneTransition());
                    break;
                    default: System.err.println("Error: No Transition available");
                }
            }
            if (currentState.isAccepted) {
                System.out.println("The language is accepted by DFA");
            } else {
                System.out.println("The language is NOT accepted by the DFA");
            }
        }
}