import java.util.LinkedList;
import java.util.List;


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
		return "BufferManagerLRUL [bufferPool=" + bufferPool + "]";
	}

	public static void main(String[] args) {
		BufferManagerLRUL bm = new BufferManagerLRUL();
		
		bm.read("A");
		bm.read("B");
		bm.read("A");
		bm.read("B");
		
		System.out.println(bm);
		
		
	}
	
}
