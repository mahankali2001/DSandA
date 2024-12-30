public class HashTable {
    int size;
    Node[] dataMap;

    public HashTable(int size) {
        this.size = size;
        dataMap = new Node[size];
    }

    class Node {
        String key;
        String value;
        Node next;

        Node(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public int hash(String key) {
        int hash = 0;
        for(int i = 0; i < key.length(); i++) {
            hash = (hash + key.charAt(i) * i) % size;
        }
        return hash;
    }

    public void set(String key, String value) {
        int index = hash(key);
        if(dataMap[index] == null) {
            dataMap[index] = new Node(key, value);
        } else {
            Node current = dataMap[index];
            while(current.next != null) {
                current = current.next;
            }
            current.next = new Node(key, value);
        }
    }

    public String get(String key) {
        int index = hash(key);
        Node current = dataMap[index];
        while(current != null) {
            if(current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public void printAll() {
        for(int i = 0; i < size; i++) {
            System.out.print("Index " + i + ":");
            Node current = dataMap[i];
            while(current != null) {
                System.out.print("("+current.key + ", " + current.value + ")");
                current = current.next;
            }
            System.err.println();
        }
    }

    public static void main(String[] args) {
        HashTable ht = new HashTable(10);
        ht.set("name", "John");
        ht.set("age", "25");
        ht.set("city", "New York");
        ht.set("country", "USA");
        ht.set("email", "a@a.com");
        ht.set("phone", "1234567890");
        ht.set("address", "123 Main St");
        ht.set("zip", "12345");
        ht.set("state", "NY");
        ht.set("company", "ABC Inc");
        ht.printAll();
        System.out.println("Value of key 'city': " + ht.get("city"));
        System.out.println("Value of key 'email': " + ht.get("email"));
        System.out.println("Value of key 'state': " + ht.get("state"));
    }
}
