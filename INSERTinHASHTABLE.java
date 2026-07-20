package Hashing;

import java.util.LinkedList;

class INSERTinHASHTABLE {
    int size = 10;
    LinkedList<Integer>[] table;
    INSERTinHASHTABLE() {
        table = new LinkedList[10];
        for (int i = 0; i < table.length; i++) {
            table[i] = new LinkedList<Integer>();
        }
    }
    public int hashDivisionFunction(int key) {
        return key % 10;
    }
    public void insert(int key) {
        int hash = hashDivisionFunction(key);
        table[hash].add(key);
    }
    public void display() {
        for (int i = 0; i < table.length; i++) {
            System.out.println(table[i]);
        }
    }
    public static void main(String[] args) {
        INSERTinHASHTABLE table = new INSERTinHASHTABLE();
        table.insert(3);
        table.insert(14);
        table.insert(55);
        table.insert(105);
        table.display();
    }
}

