package zjc.Study01.hashmap;

public class main {
    public static void main(String[] args) {
        Hashmap.LRUCache obj = new Hashmap.LRUCache(2);
        obj.put(1, 1);
        obj.put(2, 2);
        obj.get(1);
        obj.put(3, 3);
        obj.get(2);
        obj.put(4, 4);
        obj.get(1);
        obj.get(3);
        obj.get(4);
    }
}
