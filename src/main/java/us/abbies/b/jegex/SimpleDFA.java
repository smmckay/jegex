package us.abbies.b.jegex;

import us.abbies.b.uax29.GraphemeCluster;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class SimpleDFA implements DFA {
    private final State startState;

    @Override
    public boolean evaluate(String text) {
        Iterator<GraphemeCluster> clusters = GraphemeCluster.parse(text);
        State current = startState;
        while (clusters.hasNext()) {
            Optional<State> maybeNextState = current.evaluate(clusters.next());
            if (maybeNextState.isEmpty()) {
                return false;
            }
            current = maybeNextState.get();
        }
        return current.isAccepting();
    }

    public static class State {
        private final boolean accepting;
        private final List<Transition> transitions;

        public State(boolean accepting, List<Transition> transitions) {
            this.accepting = accepting;
            this.transitions = transitions;
        }

        boolean isAccepting() {
            return accepting;
        }

        Optional<State> evaluate(GraphemeCluster c) {
            for (Transition transition : transitions) {
                if (transition.matches(c)) {
                    State nextState = transition.nextState();
                    if (nextState == null) {
                        nextState = this;
                    }
                    return Optional.of(nextState);
                }
            }

            return Optional.empty();
        }
    }

    public static class Transition {
        private final State nextState;

        public Transition(State nextState) {
            this.nextState = nextState;
        }

        boolean matches(GraphemeCluster c) {

        }

        State nextState() {
            return nextState;
        }
    }
}
