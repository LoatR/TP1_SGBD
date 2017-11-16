import java.util.LinkedList;

public class BufferManagerFIFO {

	@SuppressWarnings("rawtypes")
	private LinkedList bufferPool;
	private static int BUFFER_POOL_SIZE = 4;
	
	private static int pageFaults = 0;

	public BufferManagerFIFO() {
		this.bufferPool = new LinkedList<Frame>();
	}

	@SuppressWarnings("unchecked")
	public void read(String page) {
		
		int index = isIntheBuffer(page);
		
		if (index == -1){
			if (bufferPool.size() < BUFFER_POOL_SIZE) {
				// Si page pas dans le buffer et buffer pas plein
				this.bufferPool.addFirst(new Frame(0, page));
				pageFaults++;
			} else {
				// Le buffer est plein et la page n'est pas dans le buffer
				bufferPool.removeLast();
				this.bufferPool.addFirst(new Frame(0, page));
				pageFaults++;
			}
		}
	}

	public int isIntheBuffer(String page) {
		for (int i = 0; i < this.bufferPool.size(); i++) {
			Frame pageTemp = (Frame) this.bufferPool.get(i);
			if (pageTemp.getPage().equals(page))
				return i;
		}
		return -1;

	}

	 @Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			for(int i=0; i < this.bufferPool.size(); i++){
				Frame pageTemp = (Frame) this.bufferPool.get(i);
				sb.append("P"+ i + " " + pageTemp.getPage() + "\r\n");
			}
			return sb.toString();
		}

	 public static void main(String[] args) {
			BufferManagerFIFO bm = new BufferManagerFIFO();
			
			String listToRead[] = {"A", "B", "A", "C", "D", "C", "E", "F", "G", "A"};
			String listToRead2[] = { "A", "B", "A", "C", "D", "C", "G", "E", "B", "A" };
			String listToReadFromSuject[] = {"A", "B", "C", "D", "E", "A", "B", "C", "D", "E"};
			
			String listToReadTest1[] = {"A", "B", "C", "D", "E", "A"};

			for (int i = 0; i < listToReadTest1.length; i++) {
				bm.read(listToReadFromSuject[i]);
				System.out.println(bm);
			}
			
			System.out.println("Nombre d'accès disk : " + pageFaults);

			
		}
	
}
