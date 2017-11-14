import java.util.LinkedList;


public class BufferManagerLRUL {

	private LinkedList bufferPool;
	private static int BUFFER_POOL_SIZE = 4;
	
	public BufferManagerLRUL(){
		this.bufferPool = new LinkedList<Frame>();
	}
	
	public void read(String page){
		//Verif si page déjà dans le buffer
		int index = isIntheBuffer(page);
		
		//Page dans le buffer, on l'a met devant
		if(index != -1){
			Frame temp = (Frame) this.bufferPool.remove(index);
			this.bufferPool.addFirst(temp);;
		}
		
		//Le buffer n'est pas plein
		else if(bufferPool.size() < BUFFER_POOL_SIZE){
			this.bufferPool.addFirst(new Frame(false, page));
		}
		//Le buffer est plein et la page n'est pas dans le buffer
		else{
			Frame temp = (Frame) this.bufferPool.removeLast();
			this.bufferPool.addFirst(temp);
		}
		
	}
	
	public int isIntheBuffer(String page){
		for(int i=0; i < this.bufferPool.size(); i++){
			Frame pageTemp = (Frame) this.bufferPool.get(i);
			if(pageTemp.getPage().equals(page))
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
		BufferManagerLRUL bm = new BufferManagerLRUL();
		
		String listToRead[] = {"A", "B", "A", "C", "D", "C", "E", "F", "G", "A"};
		 
		for(int i = 0; i<listToRead.length; i++){
			bm.read(listToRead[i]);
			System.out.println(bm);
		}
		
		System.out.println(bm);
		
		
	}
	
}
