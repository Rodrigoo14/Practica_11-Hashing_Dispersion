package ejercicio01;

public class Test {
	
    public static void main(String[] args) {
        HashC<String> hashTable = new HashC<>(11);
        
        hashTable.insertSquare(34, "John");
        hashTable.insertSquare(3, "Emma");
        hashTable.insertSquare(7, "David");
        hashTable.insertSquare(30, "Sophia");
        hashTable.insertSquare(11, "Oliver");
        hashTable.insertSquare(8, "Rodrigo");
        hashTable.insertSquare(7, "Manuel");
        hashTable.insertSquare(23, "Maria");
        hashTable.insertSquare(41, "Gabriela");
        hashTable.insertSquare(16, "Daniel");
        hashTable.insertSquare(34, "Frank");
        
        System.out.println(hashTable);
    }
}