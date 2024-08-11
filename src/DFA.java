
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author CHINMAY GOPE
 */
public class DFA {

    public static String input;
    public static HashSet<String> setOfStates;
    public static String startState;
    public static String acceptState;
    public static ArrayList<String[]> transition;
    private HashMap<String, Node> map = new HashMap<>();

    public DFA(HashSet<String> setOfStates, String startState, String acceptState, ArrayList<String[]> transition) {
        DFA.setOfStates = setOfStates;
        DFA.startState = startState;
        DFA.acceptState = acceptState;
        DFA.transition = transition;

        for (String stateName : DFA.setOfStates) {
            if (startState.equals(acceptState)) {
                Node node = new Node();
                node.changeToAcceptedState();
                this.map.put(stateName, node);
            } else {
                this.map.put(stateName, new Node());
            }
        }
        for (int i = 0; i < transition.size(); i++) {
            String[] t = transition.get(i);
            Node fromState = this.map.get(t[0]);
            String value = t[1];
            Node toState = this.map.get(t[2]);
            Edge edgeValue = new Edge(value, toState);
            fromState.addEdge(edgeValue);
//            enables the dot feature
            fromState.addEdge(new Edge(".", toState));
        }

    }

    boolean run(String input) {
        DFA.input = input;
        boolean match = false;
        Node curr = this.map.get(DFA.startState);
        for (int i = 0; i < DFA.input.length(); i++) {
            String c = String.valueOf(input.charAt(i));
            curr = curr.goToNext(c);
            if (curr == null) {
                break;
            }
        }
        if (curr != null && curr.isAcceptedState) {
            match = true;
        }

        return match;
    }

    public static void main(String[] args) {
        startState = "a";
        acceptState = "c";
        
        setOfStates = new HashSet<>(Arrays.asList("a", "b", "c"));
        
        transition.add(new String[]{"a", "0", "b"});
        transition.add(new String[]{"b", "1", "c"});
        transition.add(new String[]{"c", "0", "c"});
        transition.add(new String[]{"c", "1", "c"});
        
        input = "01.0111";
        
        DFA dfa = new DFA(setOfStates, startState, acceptState, transition);
        System.out.println(dfa.run(input));           
    }

}

class Node {

    ArrayList<Edge> edges;
    boolean isAcceptedState;

    public Node() {
        this.edges = new ArrayList<>();
        this.isAcceptedState = false;
    }

    Node goToNext(String c) {
        for (int i = 0; i < this.edges.size(); i++) {
//            goto next st if the current char matches or the val is dot
            if (this.edges.get(i).val.equals(c) || this.edges.get(i).val.equals(".")) {
                return this.edges.get(i).pointsTo;
            }
        }

        return null;
    }

    void addEdge(Edge e) {
        this.edges.add(e);
    }

    void changeToAcceptedState() {
        this.isAcceptedState = true;
    }

    boolean isAcceptedState() {
        return this.isAcceptedState;
    }

}

class Edge {

    String val;
    Node pointsTo;

    public Edge(String val, Node to) {
        this.val = val;
        this.pointsTo = to;
    }

}
