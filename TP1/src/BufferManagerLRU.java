import java.util.Arrays;
import java.util.Date;


public class BufferManagerLRU {
	
	private Frame bufferPool[];
	private String storageDisk[] = {"A","B","C","D","E","F","G"};
	
	private int numberOfElementsBuffer;
	
	private static int BUFFER_POOL_SIZE = 4;
	
	public BufferManagerLRU(){
		this.bufferPool = new Frame[BUFFER_POOL_SIZE];
		//this.lastAccess = new Date[4];
	}
	
	private void read(String page){
		Frame bufferPoolCopy[] = new Frame[BUFFER_POOL_SIZE];
		int index = isInBufferPool(page);
		
		if(numberOfElements() < BUFFER_POOL_SIZE){
			bufferPoolCopy[0] = new Frame(false, page);
			
		}
		
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
		return numberOfElementsBuffer;		
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
