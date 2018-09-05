package org.numismat.springboot.model;

import com.github.pagehelper.Page;

public class DataTableResultInfo {
	
	private Page<Coin> data;
    private int draw;
    private int length;
    private long recordsTotal;
    private long recordsFiltered;    
    
	public DataTableResultInfo(Page<Coin> data, int draw, int length, long recordsTotal, long recordsFiltered) {
		super();
		this.data = data;
		this.draw = draw;
		this.length = length;
		this.recordsTotal = recordsTotal;
		this.recordsFiltered = recordsFiltered;
	}	
	public DataTableResultInfo() {
	}
	public Page<Coin> getData() {
		return data;
	}
	public void setData(Page<Coin> data) {
		this.data = data;
	}
	public int getDraw() {
		return draw;
	}
	public void setDraw(int draw) {
		this.draw = draw;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public long getRecordsTotal() {
		return recordsTotal;
	}
	public void setRecordsTotal(long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
	public long getRecordsFiltered() {
		return recordsFiltered;
	}
	public void setRecordsFiltered(long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

    
}
