package hash;

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
		this.table = new ArrayList<Element>(m);
		for (int i = 0; i < m; i++) {
			this.table.add(new Element(0, null));
		}
	}
	
	private int functionHash(int key) {
		return key % this.m;
	}
	
	private int linearPorbing(int dressHash, int key) {
	    int i = 1;
	    int address = dressHash;
	    while (table.get(address).mark != 0 && table.get(address).reg.getKey() != key) {
	        address = (dressHash + i) % m;
	        i++;
	    }
	    return address;
	}
	
	public void insert(int key, E reg) {
	    int hashedAddress = functionHash(key);
	    int address = linearPorbing(hashedAddress, key);
	    
	    table.get(address).mark = 1;
	    table.get(address).reg = new Register<>(key, reg);
	}
	
	public E search(int key) {
		int hashedAddress = functionHash(key);
	    int address = linearPorbing(hashedAddress, key);
	    
	    if (table.get(address).mark == 1) {
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
				s += functionHash(item.reg.key) + "\t" + item.reg + "\n";
			else
				s += "empty\n";
		}
		return s;
	}
	
}
