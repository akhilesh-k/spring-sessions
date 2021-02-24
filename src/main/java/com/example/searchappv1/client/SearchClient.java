package com.example.searchappv1.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

//	http://10.177.68.40:8983/solr/productCollection/browse?q=Samsung
@FeignClient (name = "search-client",url = "http://10.177.68.77:8983/")
public interface SearchClient {
@RequestMapping(method = RequestMethod.GET,path = "/solr/productCollection/select")
	public Map<String, Object> getProducts(@RequestParam("q") String query);


}
