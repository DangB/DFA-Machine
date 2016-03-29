import java.util.ArrayList;
import java.util.NoSuchElementException;

//Iterator helps facilitate the traversing of the State list of the Machine
public class DFAMachineIterator {
	private int index;
	private ArrayList<State> stateList;

	public DFAMachineIterator (ArrayList<State> stateList) {
		index = 0;
		this.stateList = stateList;
	}

	public boolean hasNext() {
		return index < stateList.size();
	}

	public State getState() {
		return stateList.get(index);
	}

	public void next() {
		if (!this.hasNext()) {
			throw new NoSuchElementException();
		}
		index++;
	}

	public int getIndex() {
		return index;
	}
}
