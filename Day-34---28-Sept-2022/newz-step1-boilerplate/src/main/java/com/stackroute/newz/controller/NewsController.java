package com.stackroute.newz.controller;

import com.stackroute.newz.model.News;
import com.stackroute.newz.repository.NewsRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * Annotate the class with @Controller annotation. @Controller annotation is used to mark
 * any java class as a controller so that Spring can recognize this class as a Controller
 */
@Controller
public class NewsController {

	/*
	 * Get the application context from resources/beans.xml file using
	 * ClassPathXmlApplicationContext() class. Retrieve the News object from the
	 * context. Retrieve the NewsRepository object from the context.
	 */
	static ApplicationContext app = new ClassPathXmlApplicationContext("beans.xml");

	News news = app.getBean(News.class);
	static NewsRepository newsRepository = app.getBean(NewsRepository.class);

	/*
	 * Define a handler method to read the existing news by calling the
	 * getNewsList() method of the NewsRepository class and add it to the ModelMap
	 * which is an implementation of Map for use when building model data for use
	 * with views. it should map to the default URL i.e. "/"
	 */
	@RequestMapping("/")
	public static String getNewsList(Model model) {
		model.addAttribute("newsList", newsRepository.getAllNews());
		// System.out.println(newsRepository.getAllNews().size());
		return "index";
	}

	/*
	 * Define a handler method which will read the News data from request parameters
	 * and save the news by calling the addNews() method of NewsRepository class.
	 * Please note that the createdAt field should always be auto populated with
	 * system time and should not be accepted from the user. Also, after saving the
	 * news, it should show the same along with existing news elements. Hence,
	 * reading news has to be done here again. This handler method should map to the
	 * URL "/saveNews".
	 */
	@RequestMapping("/saveData")
	public String saveData(@ModelAttribute("news") News news) {
		newsRepository.addNews(news);
		return "redirect:/";
	}

	/*
	 * Define a handler method to delete an existing news by calling the
	 * deleteNews() method of the NewsRepository class This handler method should
	 * map to the URL "/deleteNews"
	 */
	/*
	 * @RequestMapping(method = RequestMethod.GET,value="/deleteNews") public String
	 * deleteNews(@ModelAttribute("newsid") News news1) {
	 * System.out.println(newsRepository.getAllNews().size());
	 * newsRepository.deleteNews(news1.getNewsId());
	 * System.out.println(newsRepository.getAllNews().size());
	 * System.out.println(true); return "redirect:/";
	 */

	@RequestMapping(method = RequestMethod.GET, value = "/deleteNews")
	public String deleteNews(@RequestParam(value = "newsId") int newsId) {
		System.out.println(newsRepository.getAllNews().size());
		newsRepository.deleteNews(newsId);
		System.out.println(newsRepository.getAllNews().size());
		System.out.println(newsId);

		return "redirect:/";
	}
}
