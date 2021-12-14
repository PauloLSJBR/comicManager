package org.zup.paulo.comicmanager.restclient.response;

import java.util.List;

public class ResultsResponse {
	private Long id;
	private String title;
	private String description;
	private CreatorList creators;
	private String isbn;
	private List<ComicPrice> prices;

	public String getIsbn() {
		return isbn;
	}

	public String getDescription() {
		return description;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public CreatorList getCreators() {
		return creators;
	}

	public List<ComicPrice> getPrices() {
		return prices;
	}
}

