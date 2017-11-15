import java.util.LinkedList;

public class BufferManagerFIFO {

	@SuppressWarnings("rawtypes")
	private LinkedList bufferPool;
	private static int BUFFER_POOL_SIZE = 4;

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
			} else {
				// Le buffer est plein et la page n'est pas dans le buffer
				bufferPool.removeLast();
				this.bufferPool.addFirst(new Frame(0, page));
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

			for (int i = 0; i < listToRead.length; i++) {
				bm.read(listToRead2[i]);
				System.out.println(bm);
			}

			
		}
	
}
