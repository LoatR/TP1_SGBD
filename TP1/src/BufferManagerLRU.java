import java.util.Arrays;
import java.util.Date;


public class BufferManagerLRU {
	
	private Frame bufferPool[];
	//private Date lastAccess[];
	private String storageDisk[] = {"A","B","C","D","E","F","G"};
	
	public BufferManagerLRU(){
		this.bufferPool = new Frame[4];
		//this.lastAccess = new Date[4];
	}
	
	private void read(String page){
		Frame bufferPoolCopy[] = new Frame[4];
		int index = isInBufferPool(page);
		
		
		if( index != -1){	
			bufferPoolCopy[0] = bufferPool[index];
			for(int i=0, start=1; i< this.bufferPool.length; i++){
				if (i != index){
					bufferPoolCopy[start]= bufferPool[i];
					start++;;
				}else{
					bufferPoolCopy[start]= bufferPool[i];
				}
			}
		}else{
			bufferPoolCopy[0] = new Frame(false, page);
			for(int i=0, start =1; i<bufferPoolCopy.length-1; i++, start++){
				bufferPoolCopy[start]= bufferPool[i];
			}
		}
		this.bufferPool = bufferPoolCopy;
	}
	
	private int numberOfElements(){
		int cpt = 0;
		for(int i=0; i<this.bufferPool.length; i++){
			if(this.bufferPool[i] != null)
				cpt++;
		}
		return cpt;
		
	}
	
	
	private int isInBufferPool(String page){
		for(int i=0; i < this.bufferPool.length; i++){
			if(this.bufferPool[i].getPage().equals(page))
				return i;
		}
		return -1;
	}

	@Override
	public String toString() {
		return "BufferManager [bufferPool=" + Arrays.toString(bufferPool) + "]";
	}
	
	public static void main(String[] args) {
		
		 
		 BufferManagerLRU bm = new BufferManagerLRU();
		 bm.read("A");
		 System.out.println(bm);
	}

}
