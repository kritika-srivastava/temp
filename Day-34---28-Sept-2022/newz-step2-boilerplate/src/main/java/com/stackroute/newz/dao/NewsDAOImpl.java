package com.stackroute.newz.dao;

import com.stackroute.newz.model.News;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/*
 * This class is implementing the NewsDAO interface. This class has to be annotated with @Repository
 * annotation.
 * @Repository - is an annotation that marks the specific class as a Data Access Object, thus
 * 				 clarifying it's role.
 * @Transactional - The transactional annotation itself defines the scope of a single database
 * 					transaction. The database transaction happens inside the scope of a persistence
 * 					context.
 * */

@Repository
@Transactional
public class NewsDAOImpl implements NewsDAO {

  /*
   * Autowiring should be implemented for the SessionFactory.
   */

  @Autowired
  private SessionFactory sessionFactory;

  public NewsDAOImpl(SessionFactory sessionFactory) {}

  /*
   * Save the news in the database(news) table.
   */
  @Override
  @Transactional
  public boolean addNews(News news) {
    sessionFactory.getCurrentSession().save(news);
    return true;
  }

  /*
   * retrieve all existing news sorted by created Date in descending order(showing
   * latest news first)
   */
  @Override
  @Transactional
  public List<News> getAllNews() {
    String hql = "from News order by publishedAt desc";
    @SuppressWarnings("unchecked")
    List<News> newsList = sessionFactory
      .getCurrentSession()
      .createQuery(hql)
      .getResultList();
    return newsList;
  }

  /*
   * retrieve specific news from the database(news) table
   */
  @Override
  @Transactional
  public News getNewsById(int newsId) {
    String hql = "from News n where n.newsId=" + newsId;
    @SuppressWarnings("unchecked")
    List<News> newsList = sessionFactory
      .getCurrentSession()
      .createQuery(hql)
      .getResultList();
    return newsList.get(0);
  }

  @Override
  @Transactional
  public boolean updateNews(News news) {
    sessionFactory.getCurrentSession().update(news);
    return true;
  }

  /*
   * Remove the news from the database(news) table.
   */
  @Override
  @Transactional
  public boolean deleteNews(int newsId) {
    News news = getNewsById(newsId);
    // System.out.println(news.getAuthor() + " " + news.getName());
    sessionFactory.getCurrentSession().delete(news);

    return true;
  }
}
