package com.stackroute.newz.repository;

import com.stackroute.newz.model.News;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NewsRepository {

	/* Declare a variable called "newsList" to store all the news. */
	private int deleteid;
	
	@Autowired
	private List<News> newsList = new ArrayList<>();

	public NewsRepository() {
	}

	public NewsRepository(List<News> newsList) {
		super();
		this.newsList = newsList;
	}

	/* This method should return all the news in the list */
	public List<News> getNewsList() {
		return newsList;
	}

	/* This method should set the list variable with new list of news */
	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}

	/*
	 * This method should News object as argument and add the new news object into
	 * list
	 */
	public void addNews(News news) {
		news.setPublishedAt(LocalDateTime.now());
		
		newsList.add(news);
		
	}

	/* This method should return the list of news */
	public List<News> getAllNews() {
		return newsList;
	}

	/* This method should delete a specified news from the list */
	public boolean deleteNews(int newsId) {
		newsList.removeIf(news -> news.getNewsId() == newsId);
		return true;
	}
}
