package com.codegym.repository.news;

import com.codegym.entity.about_news.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Date;

@Repository
@Transactional
public interface INewsRepository extends JpaRepository<News, Integer> {


    // Find all
//    @Query(value = "select news.news_id as newsId, news.news_title as newsTitle, news.news_brief as newsBrief, news.news_content as newsContent," +
//            " news.image_url as imageUrl, news.post_date as postDate, `type`.type_name as typeName " +
//            "from news " +
//            "inner join `type` on news.type_id = `type`.type_id", nativeQuery = true)
//    List<News> findAllNews();

    @Query(value = "select * " +
            "from news " +
            "inner join `type` on news.type_id = `type`.type_id order by news.post_date desc", nativeQuery = true)
    Page<News> findAllNews(Pageable pageable);


    // Find by id
//    @Query(value = "select news.news_id as newsId, news.news_title as newsTitle, news.news_brief as newsBrief, news.news_content as newsContent," +
//            " news.image_url as imageUrl, news.post_date as postDate, `type`.type_name as typeName " +
//            "from news " +
//            "inner join `type` on news.type_id = `type`.type_id" +
//            "where news.news_id = ?1", nativeQuery = true)
//    News findNewsById(int id);

    @Query(value = "select * " +
            "from news " +
            "inner join `type` on news.type_id = `type`.type_id" +
            " where news.news_id = ?1", nativeQuery = true)
    News findNewsById(int id);

    // Delete
    @Transactional
    @Modifying
    @Query(value = "delete from news where news.news_id = ?1", nativeQuery = true)
    void deleteNews(int id);

    // Create
    @Modifying
    @Query(value = "insert into news(news_title, news_brief,news_content," +
            "image_url,post_date,type_id) values (?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
    void saveNews(@Param("newsTitle") String newsTitle, @Param("newsBrief") String newsBrief, @Param("newsContent") String newsContent, @Param("imageUrl")
              String imageUrl, @Param("postDate") Date postDate, @Param("type") Integer type);
}
