public class State {
	public int number; //State number
	public Boolean isAccepted = false; //Accepted state - default is false
	public int ZeroTransition; //Links to state after 0 input
	public int OneTransition; //Links to state after 1 input

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
        
        //Prints details of the state - FOR DEBUGGING PURPOSES
        public void print() {
            System.out.println("------------------------");
            System.out.println("State Number: " + number +
                    "\nZero Transition: " + ZeroTransition +
                    "\nOne Transition: " + OneTransition +
                    "\nAccepted State: " + isAccepted);
            System.out.println("------------------------");
        }

}
