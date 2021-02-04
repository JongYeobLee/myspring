package org.zerock.domain;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {
	
	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	
	private int displayPageNum = 10;
	
	private Criteria cri;

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		calcData();
	}
	
	private void calcData() {
		setEndPage((int)(Math.ceil(cri.getPage()/(double)displayPageNum) * displayPageNum));
		
		setStartPage((getEndPage() - displayPageNum) + 1);
		
		int tempEndPage = (int) (Math.ceil(totalCount / (double)cri.getPerPageNum()));
		
		if(getEndPage() > tempEndPage) {
			setEndPage(tempEndPage);
		}
		
		setPrev(getStartPage() == 1 ? false : true);
		
		setNext(getEndPage() * cri.getPerPageNum() >= totalCount ? false : true);
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return "Criteria [page=" + cri.getPage() + ", " + "perPageNum=" + cri.getPerPageNum() + "]";
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	public String makeQuery(int page) {
		
		UriComponents uriComponents =
				UriComponentsBuilder.newInstance()
				.queryParam("page",  page)
				.queryParam("perPageNum",  cri.getPerPageNum())
				.build();
		
		return uriComponents.toUriString();
	}
	
	public String makeSearch(int page) {
		
		UriComponents uriComponents =
				UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("perPageNum",  cri.getPerPageNum())
				.queryParam("searchType",  ((SearchCriteria)cri).getSearchType())
				.queryParam("keyword",  ((SearchCriteria)cri).getKeyword())
				.build();
		
		return uriComponents.toUriString();
		
	}

}
