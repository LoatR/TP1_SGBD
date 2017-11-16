public class Main {

	public static void main(String[] args) {
		BufferManagerLRUL bl = new BufferManagerLRUL();
		BufferManagerFIFO bf = new BufferManagerFIFO();
		BufferManagerClock bc = new BufferManagerClock();

		String listToReadTest1[] = { "B", "C", "B", "A", "E", "B", "D", "C", "B", "D", "E", "C"};
		// LRU:6, FIFO:7, CLOCK:6
		// LRU:6, CLOCK:6, FIFO:7
		
		String listToReadTest2[] = { "B", "C", "B", "A", "E", "B", "D", "C"};
		// LRU:6, FIFO:5, CLOCK:6
		// FIFO:5, LRU:6, CLOCK:6
		
		String listToReadTest3[] ={"B", "C", "B", "A", "D", "C", "E", "A"};
		// LRU:5, FIFO:5, CLOCK:6
		// FIFO:5, LRU:5, CLOCK:6
		
		String listToReadTest4[] ={"B", "C", "B", "A", "E", "B", "D", "C", "B", "D","E", "B", "E", "C", "C", "G", "E"};
		// LRU:7, FIFO:9, CLOCK:8
		// LRU:7, CLOCK:8, FIFO:9
		

		System.out.println("--------------- LRU ------------------");
		for (int i = 0; i < listToReadTest4.length; i++) {
			bl.read(listToReadTest4[i]);
			System.out.println(bl);
		}

		System.out.println("--------------- FIFO ------------------");
		for (int i = 0; i < listToReadTest4.length; i++) {
			bf.read(listToReadTest4[i]);
			System.out.println(bf);
		}

		System.out.println("--------------- CLOCK ------------------");
		for (int i = 0; i < listToReadTest4.length; i++) {
			bc.read(listToReadTest4[i]);
			System.out.println(bc);
		}

		System.out.println("Nombre d'accès disk LRU: " + bl.getPageFaults());
		System.out.println("Nombre d'accès disk FIFO: " + bf.getPageFaults());
		System.out.println("Nombre d'accès disk CLOCK: " + bc.getPageFaults());
	}

}
