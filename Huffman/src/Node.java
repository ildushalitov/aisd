public class Node implements Comparable<Node> {

    int count;
    char character;
    Node firstSon;
    Node secondSon;

    @Override
    public int compareTo(Node node) {
        return count - node.count;
    }

    public Node(int count, char character) {
        this.count = count;
        this.character = character;
    }

    public Node(int count, char character, Node firstSon, Node secondSon) {
        this.count = count;
        this.character = character;
        this.firstSon = firstSon;
        this.secondSon = secondSon;
    }
}
