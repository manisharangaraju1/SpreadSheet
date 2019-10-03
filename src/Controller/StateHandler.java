package Controller;

import State.*;

public class StateHandler {

    private  State state;
    private State valueViewState;
    private State equationViewState;

    public StateHandler() {
        valueViewState = new ValueViewState(this);
        equationViewState = new EquationViewState(this);
        state = valueViewState;
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

    public  State getState() {
        return state;
    }
}
