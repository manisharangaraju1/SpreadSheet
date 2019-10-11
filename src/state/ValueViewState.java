package state;


public class ValueViewState implements State {

    StateHandler stateHandler;
    private final String LABEL = "CLICK TO MOVE TO EQUATION VIEW";

    public ValueViewState(StateHandler stateHandler) {
        this.stateHandler = stateHandler;
    }

    @Override
    public void handleViewRequest() {
        stateHandler.setState(stateHandler.getEquationViewState());
    }

    // Returns the label that is used to display on the state view button and to uniquely identify the state.
    public String toString() {
        return LABEL;
    }
}
