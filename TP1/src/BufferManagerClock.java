import java.util.LinkedList;

public class BufferManagerClock {

	private LinkedList bufferPool;
	private int needlePos; // Position de l'aiguille

	private static int BUFFER_POOL_SIZE = 4;

	public BufferManagerClock() {
		this.bufferPool = new LinkedList<Frame>();
		this.needlePos = 0;
	}

	public void read(String page) {
		//TODO
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
		for (int i = 0; i < this.bufferPool.size(); i++) {
			Frame pageTemp = (Frame) this.bufferPool.get(i);
			sb.append("P" + i + " " + pageTemp.getPage() + "\r\n");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		BufferManagerClock bm = new BufferManagerClock();

		String listToRead[] = { "A", "B", "A", "C", "D", "C", "E", "F", "G", "A" };
		String listToRead2[] = { "A", "B", "A", "C", "D", "C", "A", "E", "B", "A" };

		for (int i = 0; i < listToRead.length; i++) {
			bm.read(listToRead2[i]);
			System.out.println(bm);
		}

		System.out.println(bm);

	}

}
