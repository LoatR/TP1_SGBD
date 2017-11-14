
public class Frame {
	
	private int flag;
	private String page;
	
	public Frame(int flag, String page){
		this.flag = flag;
		this.page = page;		
	}


	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}
	
	@Override
	public String toString() {
		return "Frame [dirty=" + flag + ", page=" + page + "]";
	}

	
}
