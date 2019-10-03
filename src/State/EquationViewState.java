package State;

import Controller.StateHandler;

public class EquationViewState extends State {

    StateHandler stateHandler;

    public EquationViewState(StateHandler stateHandler) {
        this.stateHandler = stateHandler;
    }

    @Override
    public void handleViewRequest() {
        stateHandler.setState(stateHandler.getValueViewState());
    }

    public String toString() {
        return "VALUE";
    }
}
