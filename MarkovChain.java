import java.util.HashMap;

public class MarkovChain {
    

    Node start;
    Node end;

    HashMap<String, Node> nodes;

    public MarkovChain() {
        start = new Node("[[[START]]]");
        end = new Node("[[[END]]]");
        nodes = new HashMap<String, Node>();
    }

    public void addSentence(String sentence) {
        String[] tokens = sentence.split(" ");
        if (tokens.length == 0) {
            return;
        }
        Node prev = start;
        Node n;
        for (int i = 0; i < tokens.length; i++) {
            if (nodes.containsKey(tokens[i])) {
                n = nodes.get(tokens[i]);
            }
            else {
               n = new Node(tokens[i]);
               nodes.put(tokens[i], n);
            }
            prev.addNeighbor(n);
            prev = n;
        }
        prev.addNeighbor(end);
    }


    public String generateSentence() {
        String out = "";
        Node current = start;
        while (!current.equals(end)) {
            out += current;
            int target = (int)(Math.random() * current.neighbors.size());
            current = current.neighbors.get(target);
        }
        return out;
    }


    public String toString() {
        return start + " " + nodes + " " + end;
    }


}
