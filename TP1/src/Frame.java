
public class Frame {
	
	private int pinCount;
	private boolean dirty;
	private String page;
	
	public Frame(int pinCount, boolean dirty, String page){
		this.pinCount = pinCount;
		this.dirty = dirty;
		this.page = page;		
	}

	public int getPinCount() {
		return pinCount;
	}

	public void setPinCount(int pinCount) {
		this.pinCount = pinCount;
	}

	public boolean isDirty() {
		return dirty;
	}

	public void setDirty(boolean dirty) {
		this.dirty = dirty;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}
	
	@Override
	public String toString() {
		return "Frame [pinCount=" + pinCount + ", dirty=" + dirty + ", page="
				+ page + "]";
	}

	
}
