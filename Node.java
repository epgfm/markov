import java.util.ArrayList;

public class Node {
    
    public String token;
    public ArrayList<Node> neighbors;
    public ArrayList<Integer> freqs;

    public Node(String token) {
        this.token = token;
        neighbors = new ArrayList<Node>();
        freqs = new ArrayList<Integer>();
    }

    public String toString() {
        return token + " " + freqs;
    }

    public void addNeighbor(Node n) {
        boolean found = false;
        int foundI = -1;
        for (int i = 0; i < neighbors.size(); i++) {
            if (n.equals(neighbors.get(i))) {
                found = true;
                foundI = i;
                break;
            }
        }
        if (found) {
            int i = foundI;
            freqs.set(i, freqs.get(i) + 1);
        }
        else {
            neighbors.add(n);
            freqs.add(1);
        }
    }

    
    public boolean equals(Node other) {
        return this.token.equals(other.token);
    }

    public int hashCode() {
        return token.hashCode();
    }

}
