package com.sbt.ms.movie.catalog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sbt.ms.movie.catalog.models.CatalogItem;
import com.sbt.ms.movie.catalog.models.Movie;
import com.sbt.ms.movie.catalog.models.Rating;

@Service
public class MovieInfoService {

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getFallbackCatalogItem")
	public CatalogItem getCatalogItem(Rating rating) {
		Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
		return new CatalogItem(movie.getName(), movie.getDesc(), rating.getRating());
	}

	public CatalogItem getFallbackCatalogItem(Rating rating) {

		return new CatalogItem("Movie name not found", "", rating.getRating());
	}

}
