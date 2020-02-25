package com.sbt.ms.movie.catalog.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sbt.ms.movie.catalog.models.CatalogItem;
import com.sbt.ms.movie.catalog.models.Movie;
import com.sbt.ms.movie.catalog.models.UserRating;
import com.sbt.ms.movie.catalog.service.MovieInfoService;
import com.sbt.ms.movie.catalog.service.RatingInfoService;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private MovieInfoService movieInfoService;

	@Autowired
	private RatingInfoService ratingInfoService;

	/**
	 * Get movie rating details by user id
	 * 
	 * @param userId
	 * @return List of CatalogItem
	 */
	@RequestMapping("/{userId}")
	public List<CatalogItem> getMovieRatingsByUser(@PathVariable("userId") String userId) {
		UserRating userRating = ratingInfoService.getUserRating(userId);

		return userRating.getUserRating().stream().map(rating -> movieInfoService.getCatalogItem(rating))
				.collect(Collectors.toList());
	}

	/**
	 * Get all available movie information
	 * 
	 * @return List of movie details
	 */
	@RequestMapping("/all")
	public List<CatalogItem> getAllMovieRatings() {

		UserRating userRating = restTemplate.getForObject("http://movie-rating-service/rating/all", UserRating.class);

		return userRating.getUserRating().stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(),
					Movie.class);
			return new CatalogItem(movie.getName(), movie.getDesc(), rating.getRating(), rating.getUserId());
		}).collect(Collectors.toList());
	}

}
