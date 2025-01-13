package com.arvin.spring6.payload;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PageResult<T> {
	private int index = 1;
	private int pageSize = 5;
	private int totalPage;
	private int totalRecords = 0;
	private String searchKeywords;
	private List<T> results;
	
	@JsonIgnore
	public int getStart() {
		int start = 0;
		if(getIndex() == 1) {
			start = 0;
		}else if(getIndex() > 1 && getIndex() < getTotalPage()) {
			start = getIndex() * getPageSize();
		}else if(getIndex() >= getTotalPage()) {
			start = (getTotalPage() - 1) * getPageSize();
		}
		return start;
	}

	public int getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageSize() {
		return pageSize;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getTotalPage() {
		totalPage = getTotalRecords()/getPageSize();
		if(getTotalRecords() % getPageSize() > 0) {
			totalPage = totalPage + 1;
		}
		return totalPage;
	}
	public String getSearchKeywords() {
		return searchKeywords;
	}
	public void setSearchKeywords(String searchKeywords) {
		this.searchKeywords = searchKeywords;
	}
	public List<T> getResults() {
		return results;
	}
	public void setResults(List<T> results) {
		this.results = results;
	}
}
