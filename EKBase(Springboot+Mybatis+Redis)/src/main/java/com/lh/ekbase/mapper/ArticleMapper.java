package com.lh.ekbase.mapper;

import com.lh.ekbase.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleMapper {
    Article getArticle(int id);
    List<Article> searchArticle(String str);
    List<Article> getRcmdArticle();
    List<Article> getCarousel(int cnt);
    List<String> getAllArticleContents();
    void setArticleCoverUrl(@Param("id") int id, @Param("url") String url);
}
