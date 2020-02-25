package com.sbt.ms.movie.catalog.models;

public class Rating {

	private int userId;
	private String movieId;
	private int rating;

	public Rating() {

	}

	public Rating(String movieId, int rating) {
		super();
		this.movieId = movieId;
		this.rating = rating;
	}

	public Rating(int userId, String movieId, int rating) {
		super();
		this.userId = userId;
		this.movieId = movieId;
		this.rating = rating;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
