public class State {
	private int number;
	public Boolean isAccepted;
	private int ZeroTransition;
	private int OneTransition;

	public State (int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setZeroTransition(int n) {
		ZeroTransion = n;
	}

	public void setOneTransition(int n) {
		OneTransition = n;
	}

	public int getZeroTransition() {
		return ZeroTransion;
	}

	public int getOneTransition() {
		return OneTransition;
	}

}