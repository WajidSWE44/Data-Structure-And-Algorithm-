package Hashing;

class HashTableLinearProbing {
    private int[] table; // Array to store hash table elements
    private int size; // Size of the hash table

    // Constructor to initialize the hash table
    public HashTableLinearProbing(int size) {
        this.size = size;
        table = new int[size];
    }

    // Hash function: Determines the index for a given key
    private int hashFunction(int key) {
        return key % size;
    }

    // Insert a key into the hash table
    public void insert(int key) {
        int index = hashFunction(key); // Calculate hash index
        int originalIndex = index; // Save the original index for circular probing
        int i = 0; // Count the number of probes

        // Linear probing: Find the next available slot
        while (table[index] != 0) {
            index = (originalIndex + ++i) % size; // Move to the next slot
            if (i == size) { // If all slots are checked
                System.out.println("Hash table is full, cannot insert key: " + key);
                return;
            }
        }

        table[index] = key; // Insert the key at the found index
        System.out.println("Inserted " + key + " at index " + index);
    }

    // Display the contents of the hash table
    public void displayTable() {
        for (int i = 0; i < size; i++) {
            System.out.println("Index " + i + ": " + (table[i] != 0 ? table[i] : "null"));
        }
    }
}

class Test {
    public static void main(String[] args) {
        HashTableLinearProbing hashTable = new HashTableLinearProbing(10); // Create a hash table of size 10

        // Insert keys into the hash table
        hashTable.insert(5);
        hashTable.insert(15);
        hashTable.insert(25);
        hashTable.insert(35);

        // Display the contents of the hash table
        hashTable.displayTable();
    }
}
