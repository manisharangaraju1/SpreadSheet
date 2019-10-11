package state;

/*
 *  A class to handle toggling between two states.
 *  State is changed everytime you call the current state's handleRequest() method.
 */

public class StateHandler {

    private State state;
    private State valueViewState;
    private State equationViewState;

    public StateHandler() {
        valueViewState = new ValueViewState(this);
        equationViewState = new EquationViewState(this);
        state = equationViewState;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getValueViewState() {
        return valueViewState;
    }

    public State getEquationViewState() {
        return equationViewState;
    }

    public State getState() {
        return state;
    }
}
