
public class Main {

	public static void main(String[] args) {
		BufferManagerLRUL bl = new BufferManagerLRUL();
		BufferManagerFIFO bf = new BufferManagerFIFO();
		BufferManagerClock bc = new BufferManagerClock();

		//String listToRead[] = { "A", "B", "A", "C", "D", "C", "E", "F", "G", "A" }; 
		//String listToRead2[] = { "A", "B", "A", "C", "D", "C", "G", "E", "B", "A" }; 
		//String listToReadFromSuject[] = {"A", "B", "C", "D", "E", "A", "B", "C", "D", "E"}; 
		
		String listToReadFromExo[] = { "B", "C", "B", "A", "E", "B", "D", "E", "C", "B", "D", "E", "C", "B", "D", "E", "C", "B", "E", "B"};
		//LRU:6, FIFO:7, CLOCK:6
		
		String listToReadTest1[] = {"A", "B", "C", "D", "E", "D", "C"}; //5
		
		System.out.println("--------------- LRU ------------------");
		for (int i = 0; i < listToReadFromExo.length; i++) {
			bl.read(listToReadFromExo[i]);
			System.out.println(bl);
		}
		
		System.out.println("--------------- FIFO ------------------");
		for (int i = 0; i < listToReadFromExo.length; i++) {
			bf.read(listToReadFromExo[i]);
			System.out.println(bf);
		}
		
		System.out.println("--------------- CLOCK ------------------");
		for (int i = 0; i < listToReadFromExo.length; i++) {
			bc.read(listToReadFromExo[i]);
			System.out.println(bc);
		}

		System.out.println("Nombre d'accès disk LRU: " + bl.getPageFaults());
		System.out.println("Nombre d'accès disk FIFO: " + bf.getPageFaults());
		System.out.println("Nombre d'accès disk CLOCK: " + bc.getPageFaults());
	}

}
