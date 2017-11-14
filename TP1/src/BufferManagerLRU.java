import java.util.Arrays;
import java.util.Date;


public class BufferManagerLRU {
	
	private Frame bufferPool[];
	private Date lastAccess[];
	
	public BufferManagerLRU(){
		this.bufferPool = new Frame[4];
		this.lastAccess = new Date[4];
	}
	
	private void read(String page){
		int index = isInBufferPool(page);
		if( index != -1){
			Frame bufferPoolCopy[] = new Frame[4];
			bufferPoolCopy[0] = bufferPool[index];
			for(int i=0, start=1; i< this.bufferPool.length; i++){
				if (i == index){
					bufferPoolCopy[start]= bufferPool[i];
					start++;;
				}else{
					bufferPoolCopy[start]= bufferPool[i];
				}
			}
		}
		
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
		return "BufferManager [bufferPool=" + Arrays.toString(bufferPool)
				+ ", lastAccess=" + Arrays.toString(lastAccess) + "]";
	}

}
