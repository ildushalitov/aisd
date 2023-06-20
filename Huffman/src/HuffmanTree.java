import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanTree {


    public static Node getTree(Map<Character, Integer> counts) {
        PriorityQueue<Node> freeNodes = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> e : counts.entrySet()) {
            freeNodes.offer(new Node(e.getValue(), e.getKey()));
        }
        while (freeNodes.size() > 1) {
            Node n1 = freeNodes.poll();
            Node n2 = freeNodes.poll();
            freeNodes.offer(new Node(n1.count + n2.count, '木', n1, n2));
            for(Node n: freeNodes){
                System.out.println(n.character);
                System.out.println();
            }
        }
        return freeNodes.peek();
    }

    public static void getCodeRecursion(Node root, Map<Character, String> codes, String code) {
        if (root == null) return;
        if (root.character != '木') codes.put(root.character, code);
        getCodeRecursion(root.firstSon, codes, code + "0");
        getCodeRecursion(root.secondSon, codes, code + "1");
    }

    public static Map<Character, String> getCodesByRoot(Node root) {
        Map<Character, String> codes = new HashMap<>();
        getCodeRecursion(root, codes, "");
        return codes;
    }

    public static Map<Character, String> getCodes(Map<Character, Integer> counts){
        return getCodesByRoot(getTree(counts));
    }
}
