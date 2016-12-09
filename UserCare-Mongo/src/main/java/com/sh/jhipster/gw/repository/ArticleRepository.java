package com.sh.jhipster.gw.repository;

import com.sh.jhipster.gw.domain.Article;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;

/**
 * Spring Data MongoDB repository for the Article entity.
 */
@SuppressWarnings("unused")
public interface ArticleRepository extends MongoRepository<Article,String> {

}
