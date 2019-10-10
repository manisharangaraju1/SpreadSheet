package State;


public class ValueViewState extends State {

    StateHandler stateHandler;

    public ValueViewState(StateHandler stateHandler) {
        this.stateHandler = stateHandler;
    }

    @Override
    public void handleViewRequest() {
        stateHandler.setState(stateHandler.getEquationViewState());
    }

    public String toString() {
        return "EQUATION";
    }
}
