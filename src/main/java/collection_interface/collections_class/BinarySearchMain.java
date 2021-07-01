package collection_interface.collections_class;

import java.util.ArrayList;
import java.util.Collections;

public class BinarySearchMain {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(-1);
        list.add(77);
        list.add(-18768);
        list.add(543534);

        Collections.sort(list);

        int searchRes = Collections.binarySearch(list, -77);

        System.out.println(searchRes >= 0 ? searchRes : "not found");
    }
}
