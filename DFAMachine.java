
public class DFAMachine {
	private ArrayList<State> stateList;
	private State currentState;
	private String languageInput;

	public DFAMachine {
		stateList = new ArrayList<State>();
	}

	public DFAMachineIterator getIterator() {
		return new DFAMachineIterator(stateList);
	}

	public boolean stateExist(int n) {
		//Return true is stateList is empty
		if stateList.isEmpty() {
			return false;
		}

		DFAMachineIterator itr = this.getIterator();
		while itr.hasNext() {
			State current = itr.getState();
			if current.getNumber == n {
				return true
			}
			itr.next();
		}
		return false;
	}

	public void addState (int n) {
		stateList.add(new State(n));
	}

}