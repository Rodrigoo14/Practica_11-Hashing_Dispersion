package hash;

public class Test01 {

	public static void main(String[] args) {
		HashA<String> hashTable = new HashA<>(7);
		
        hashTable.insert(34, "John");
        hashTable.insert(3, "Emma");
        hashTable.insert(7, "David");
        hashTable.insert(30, "Sophia");
        hashTable.insert(11, "Oliver");
        hashTable.insert(8, "Rodrigo");
        hashTable.insert(7, "Manuel");
        hashTable.insert(23, "Maria");
        hashTable.insert(41, "Gabriela");
        hashTable.insert(16, "Daniel");
        hashTable.insert(34, "Frank");
        
        System.out.println(hashTable);
	}

}
