package tests;

import org.junit.jupiter.api.Test;
import state.StateHandler;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class StateTest {
    StateHandler stateHandler;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        stateHandler = new StateHandler();
    }


    @Test
    void initialStateTest() {
        //Initially the view begins with equation state
        String stateLabel = stateHandler.getState().toString();
        assertTrue(stateLabel.contains("VALUE"));
    }


    @Test
    void modifyStateTest() {
        //Validating state after the toggle switch.
        stateHandler.getState().handleViewRequest();
        String stateLabel = stateHandler.getState().toString();
        assertTrue(stateLabel.contains("EQUATION"));
    }

}
