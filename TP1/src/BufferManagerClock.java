import java.util.LinkedList;

public class BufferManagerClock {

	private Frame[] bufferPool;
	private int needlePos = 0; // Position de l'aiguille

	private static int BUFFER_POOL_SIZE = 4;

	public BufferManagerClock() {
		this.bufferPool = new Frame[BUFFER_POOL_SIZE];
		this.needlePos = 0;
	}

	public void read(String page) {
		int index = isIntheBuffer(page);

		if(this.sizeBuffer() < BUFFER_POOL_SIZE){
			//Le buffer n'est pas plein
			if(index != -1){
				//La page existe
				this.bufferPool[index].setFlag(1);
			}else{
				//La page n'existe pas
				this.bufferPool[this.sizeBuffer()] = new Frame(0, page);
			}
		}else {
			//Le buffer est PLEIN
			if(index == -1){
				//La page n'est pas dans le buffer
				if(this.bufferPool[needlePos].getFlag() == 0){
					//Le flag est à 0
					this.remplace(page);
				}else{
					//Le flag est à 1
					do {
						this.bufferPool[needlePos].setFlag(0);
						this.next();
					}while(this.bufferPool[needlePos].getFlag() == 1);
					this.remplace(page);					
				}
			}else{
				//La page est dans le buffer
				this.bufferPool[index].setFlag(1);
			}
		}
	}

	public int isIntheBuffer(String page) {
		for (int i = 0; i < this.sizeBuffer(); i++) {
			Frame pageTemp = (Frame) this.bufferPool[i];
			if (pageTemp.getPage().equals(page))
				return i;
		}
		return -1;
	}
	
	public int sizeBuffer(){
		int cpt=0; 
		for(int i = 0; i <this.bufferPool.length; i++){
			if(this.bufferPool[i] != null)
				cpt++;
		}
		return cpt;
	}
	
	public void remplace(String page){
		this.bufferPool[needlePos] = new Frame(0, page);
		this.next();
	}
	
	public void next(){
		if(needlePos == BUFFER_POOL_SIZE-1){
			needlePos = 0;
		}else{
			needlePos++;
		}
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Needle : P" + this.needlePos + "\n");
		for (int i = 0; i < this.sizeBuffer(); i++) {
			Frame pageTemp = (Frame) this.bufferPool[i];
			sb.append("P" + i + " " + pageTemp.getPage() + " " + pageTemp.getFlag() + "\r\n");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		BufferManagerClock bm = new BufferManagerClock();

		String listToRead[] = { "A", "B", "A", "C", "D", "C", "E", "F", "G", "A" };
		String listToReadFromSuject[] = {"A", "B", "C", "D", "E", "A", "B", "C", "D", "E"};
		String listToRead2[] = { "2", "3", "2", "1", "5", "2", "4", "5", "3", "2", "4", "5", "3", "2", "4", "5", "3", "2", "5", "2"};

		for (int i = 0; i < listToRead2.length; i++) {
			bm.read(listToRead2[i]);
			System.out.println(bm);
		}

	}

}
