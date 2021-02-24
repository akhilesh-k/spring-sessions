package com.example.searchappv1.service;

import com.example.searchappv1.dto.SearchRequestDTO;
import com.example.searchappv1.dto.SearchResponseDTO;

public interface SearchService {
	SearchResponseDTO getProducts(SearchRequestDTO request);

}
