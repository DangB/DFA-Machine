
import java.util.ArrayList;
import java.util.StringTokenizer;


public class DFAMachine {
	private ArrayList<State> stateList;
        private ArrayList<String> inputList;
	private State currentState;
	private String languageInput;

	public DFAMachine() {
		stateList = new ArrayList<State>();
                inputList = new ArrayList<String>();
	}

	public DFAMachineIterator getIterator() {
		return new DFAMachineIterator(stateList);
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
            this.inputList = inputList;
            for (String str: inputList) {
                StringTokenizer st = new StringTokenizer(str, ",");
                
                int oldState = Integer.parseInt(st.nextToken());
                int transition = Integer.parseInt(st.nextToken());
                int newState = Integer.parseInt(st.nextToken());
                
                System.out.println(oldState);
                System.out.println(transition);
                System.out.println(newState);
                
                if (!stateExist(oldState)) {
                    this.addState(oldState);
                    findState(oldState).print();
                }
                if (!stateExist(newState)) {
                    this.addState(newState);
                    findState(newState).print();
                }
                switch (transition) {
                    case 0: findState(oldState).setZeroTransition(newState);
                    break;
                    case 1: findState(oldState).setOneTransition(newState);
                    break;
                    default: System.err.println("Error: Transition must be a 0 or 1");
                }
            }
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

	public void addState (int n) {
		stateList.add(new State(n));
	}

}