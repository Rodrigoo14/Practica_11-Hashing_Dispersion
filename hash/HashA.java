package hash;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashA<E extends Comparable<E>> {
    private int m;
    private List<LinkedList<Register<E>>> table;

    public HashA(int n) {
        this.m = n;
        this.table = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            this.table.add(new LinkedList<>());
        }
    }

    private int functionHash(int key) {
        return key % this.m;
    }

    public void insert(int key, E value) {
        int hash = functionHash(key);
        LinkedList<Register<E>> list = table.get(hash);
        Register<E> newRegister = new Register<>(key, value);
        list.add(newRegister);
    }

    public E search(int key) {
        int hash = functionHash(key);
        LinkedList<Register<E>> list = table.get(hash);

        for (Register<E> register : list) {
            if (register.getKey() == key) {
                return register.value;
            }
        }

        return null;
    }

    public String toString() {
        String s = "D.Real\td.Hash\tRegister\n";
        int i = 0;
        for (LinkedList<Register<E>> list : table) {
            s += (i++) + "-->\t";
            if (!list.isEmpty()) {
                for (Register<E> register : list) {
                    s += functionHash(register.getKey()) + "\t" + register + " -> ";
                }
                s += "null\n";
            } else {
                s += "empty\n";
            }
        }
        return s;
    }
}
