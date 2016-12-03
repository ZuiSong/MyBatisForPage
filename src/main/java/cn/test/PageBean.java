package cn.test;
import java.util.ArrayList;

public class PageBean<T> {
	private ArrayList<T> datas;

	// private int toalPage;
	private int pageCode;

	private int pagesSize;

	private int totalRecord;

	public ArrayList<T> getDatas() {
		return datas;
	}

	public int getPageCode() {
		return pageCode;
	}

	public int getPagesSize() {
		return pagesSize;
	}

	public int getToalPage() {
		return (totalRecord % pagesSize == 0) ? (totalRecord / pagesSize)
				: (totalRecord / pagesSize + 1);
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setDatas(ArrayList<T> datas) {
		this.datas = datas;
	}
	public void setPageCode(int pageCode) {
		this.pageCode = pageCode;
	}
	public void setPagesSize(int pagesSize) {
		this.pagesSize = pagesSize;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

}
