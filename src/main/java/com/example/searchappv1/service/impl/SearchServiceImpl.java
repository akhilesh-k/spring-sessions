package com.example.searchappv1.service.impl;

import com.example.searchappv1.client.SearchClient;
import com.example.searchappv1.dto.ProductDTO;
import com.example.searchappv1.dto.SearchRequestDTO;
import com.example.searchappv1.dto.SearchResponseDTO;
import com.example.searchappv1.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

import static javax.swing.UIManager.get;

@Service
public class SearchServiceImpl implements SearchService {
	@Autowired
	private SearchClient searchClient;
	@Override
	public SearchResponseDTO getProducts(SearchRequestDTO request ){
		Map<String, Object> productResponse=searchClient.getProducts(request.getSearchTerm());
		Map<String, Object> locationBaseProductsResponse=searchClient.getProducts("stockLocation:"+"\""+request.getStockLocation()+"\"");

		List<Map<String,Object>> products=(List<Map<String,Object>>)((Map<String,Object>)productResponse.get("response")).get("docs");
		List<Map<String,Object>> locationBaseProducts=(List<Map<String,Object>>)((Map<String,Object>)locationBaseProductsResponse.get("response")).get("docs");

		List<ProductDTO>productDTOList=new ArrayList<>();
		for(Map<String,Object> product1:products){
			ProductDTO product=new ProductDTO();
			product.setDescription((String) product1.get("description"));
			product.setTitle((String)product1.get("nameSearch"));
			product.setSalePrice((Double) product1.get("salePrice"));
			product.setInStock((int) product1.get("isInStock") == 1? true:false);

			productDTOList.add(product);
		}

		List<ProductDTO>locationDTOList=new ArrayList<>();
		for(Map<String,Object> product2:locationBaseProducts){
			ProductDTO locationBaseProduct=new ProductDTO();
			locationBaseProduct.setDescription((String) product2.get("description"));
			locationBaseProduct.setTitle((String)product2.get("nameSearch"));
			locationBaseProduct.setSalePrice((Double) product2.get("salePrice"));
			locationBaseProduct.setInStock((int) product2.get("isInStock") == 1? true:false);

			locationDTOList.add(locationBaseProduct);
		}


		SearchResponseDTO searchResponseDTO =new SearchResponseDTO();
		searchResponseDTO.setProducts(productDTOList);
		searchResponseDTO.setLocationBaseProducts(locationDTOList);
		return searchResponseDTO;

//		SearchResponseDTO responseDTO=new SearchResponseDTO();
//		ProductDTO product=new ProductDTO();
//		product.setDescription("Samsung Galaxy S5... Blah blahhh...");
//		product.setTitle("Samsung Galaxy S5");
//		product.setInStock(true);
//		product.setSalePrice(2000);
//		responseDTO.setProducts(Arrays.asList(product));
//		return responseDTO;

	}
}
