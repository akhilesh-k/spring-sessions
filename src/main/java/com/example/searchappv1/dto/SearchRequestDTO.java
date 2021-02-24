package com.example.searchappv1.dto;

public class SearchRequestDTO {
	private String searchTerm;
	private String stockLocation;

	public String getSearchTerm() {
		return searchTerm;
	}

	public String getStockLocation() {
		return stockLocation;
	}

	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}

	public void setStockLocation(String stockLocation) {
		this.stockLocation = stockLocation;
	}

	@Override
	public String toString() {
		return "SearchRequestDTO{" +
				"searchTerm='" + searchTerm + '\'' +
				", stockLocation='" + stockLocation + '\'' +
				'}';
	}
}
