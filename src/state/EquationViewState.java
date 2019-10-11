package state;


public class EquationViewState implements State {

    StateHandler stateHandler;
    private final String LABEL = "CLICK TO MOVE TO VALUE VIEW";

    public EquationViewState(StateHandler stateHandler) {
        this.stateHandler = stateHandler;
    }

    @Override
    public void handleViewRequest() {
        stateHandler.setState(stateHandler.getValueViewState());
    }

    // Returns the label that is used to display on the state view button and to uniquely identify the state.
    public String toString() {
        return LABEL;
    }
}
