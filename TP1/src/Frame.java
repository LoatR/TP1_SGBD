
public class Frame {
	
	private boolean dirty;
	private String page;
	
	public Frame(boolean dirty, String page){
		this.dirty = dirty;
		this.page = page;		
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
		return "Frame [dirty=" + dirty + ", page=" + page + "]";
	}

	
}
