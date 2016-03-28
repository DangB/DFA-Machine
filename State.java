public class State {
	public int number;
	public Boolean isAccepted = false;
	public int ZeroTransition;
	public int OneTransition;

	public State (int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setZeroTransition(int n) {
		ZeroTransition = n;
	}

	public void setOneTransition(int n) {
		OneTransition = n;
	}
        
        public void makeAccepting() {
            isAccepted = true;
        }

	public int getZeroTransition() {
		return ZeroTransition;
	}

	public int getOneTransition() {
		return OneTransition;
	}
        
        public void print() {
            System.out.println("State Number: " + number +
                    "\nZero Transition: " + ZeroTransition +
                    "\nOne Transition: " + OneTransition +
                    "\nAccepted State: " + isAccepted);
        }

}