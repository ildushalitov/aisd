import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put('А', 15);
        hm.put('Б', 7);
        hm.put('В', 6);
        hm.put('Г', 6);
        hm.put('Д', 5);
        HashMap<Character, String> codes = (HashMap<Character, String>) HuffmanTree.getCodes(hm);
        for(Map.Entry<Character, String> e: codes.entrySet()){
            System.out.println(e.getKey() + " : " + e.getValue());
        }
    }
}
