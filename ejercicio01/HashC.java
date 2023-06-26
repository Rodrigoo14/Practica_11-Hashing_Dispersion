package ejercicio01;

import java.util.ArrayList;

public class HashC<E extends Comparable<E>> {

    protected class Element {
        int mark;
        Register<E> reg;

        public Element(int mark, Register<E> reg) {
            this.mark = mark;
            this.reg = reg;
        }
    }

    protected ArrayList<Element> table;
    protected int m;

    public HashC(int n) {
        this.m = n;
        this.table = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            this.table.add(new Element(0, null));
        }
    }

    private int functionHashModulo(int key) {
        return key % this.m;
    }

    private int functionHashSquare(int key) {
        int square = key * key;
        return square % this.m;
    }

    private int functionHashFolding(int key) {
        int sum = 0;
        while (key > 0) {
            sum += key % 100;
            key /= 100;
        }
        return sum % this.m;
    }

    private int linearProbing(int hashedAddress, int key) {
        int i = 1;
        int address = hashedAddress;

        while (table.get(address).mark == 1 && table.get(address).reg.getKey() != key) {
            address = (hashedAddress + i) % m;
            i++;
        }

        return address;
    }

    public void insertModulo(int key, E reg) {
        int hashedAddress = functionHashModulo(key);
        int address = linearProbing(hashedAddress, key);

        if (table.get(address).mark != 1) {
            table.get(address).mark = 1;
            table.get(address).reg = new Register<>(key, reg);
        }
    }

    public void insertSquare(int key, E reg) {
        int hashedAddress = functionHashSquare(key);
        int address = linearProbing(hashedAddress, key);

        if (table.get(address).mark != 1) {
            table.get(address).mark = 1;
            table.get(address).reg = new Register<>(key, reg);
        }
    }

    public void insertFolding(int key, E reg) {
        int hashedAddress = functionHashFolding(key);
        int address = linearProbing(hashedAddress, key);

        if (table.get(address).mark != 1) {
            table.get(address).mark = 1;
            table.get(address).reg = new Register<>(key, reg);
        }
    }

    public E search(int key) {
        int hashedAddress = functionHashModulo(key);
        int address = linearProbing(hashedAddress, key);

        if (table.get(address).mark == 1 && table.get(address).reg.getKey() == key) {
            return table.get(address).reg.value;
        }

        return null;
    }

    public String toString() {
        String s = "D.Real\td.Hash\tRegister\n";
        int i = 0;
        for (Element item : table) {
            s += (i++) + "-->\t";
            if (item.mark == 1)
                s += functionHashModulo(item.reg.key) + "\t" + item.reg + "\n";
            else
                s += "empty\n";
        }
        return s;
    }
}