package com.example.searchappv1.controller;

import com.example.searchappv1.dto.SearchRequestDTO;
import com.example.searchappv1.dto.SearchResponseDTO;
import com.example.searchappv1.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {
	public SearchController(SearchService searchService ){
		this.searchService=searchService;
	}
	@Autowired
	private SearchService searchService;

	@PostMapping(path="/search")
	public SearchResponseDTO search(@RequestBody SearchRequestDTO searchRequestDTO)
	{
		return searchService.getProducts(searchRequestDTO);
	}


}
