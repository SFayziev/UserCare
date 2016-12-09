package com.sh.jhipster.gw.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.sh.jhipster.gw.domain.Article;
import com.sh.jhipster.gw.service.ArticleService;
import com.sh.jhipster.gw.web.rest.util.HeaderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Article.
 */
@RestController
@RequestMapping("/api")
public class ArticleResource extends AbstractResource{

    private final Logger log = LoggerFactory.getLogger(ArticleResource.class);

    @Inject
    private ArticleService articleService;

    /**
     * POST  /articles : Create a new article.
     *
     * @param article the article to create
     * @return the ResponseEntity with status 201 (Created) and with body the new article, or with status 400 (Bad Request) if the article has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @RequestMapping(value = "/articles",
        method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Article> createArticle(@Valid @RequestBody Article article) throws URISyntaxException {
        log.debug("REST request to save Article : {}", article);
        if (article.getNumber() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("article", "idexists", "A new article cannot already have an ID")).body(null);
        }
        article.setProjid(getProjectId());
        Article result = articleService.save(article);
        return ResponseEntity.created(new URI("/api/articles/" + result.getNumber()))
            .headers(HeaderUtil.createEntityCreationAlert("article", result.getNumber().toString()))
            .body(result);
    }

    /**
     * PUT  /articles : Updates an existing article.
     *
     * @param article the article to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated article,
     * or with status 400 (Bad Request) if the article is not valid,
     * or with status 500 (Internal Server Error) if the article couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @RequestMapping(value = "/articles",
        method = RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Article> updateArticle(@Valid @RequestBody Article article) throws URISyntaxException {
        log.debug("REST request to update Article : {}", article);
        if (article.getNumber() == null) {
            return createArticle(article);
        }
        Article result = articleService.save(article);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert("article", article.getNumber().toString()))
            .body(result);
    }

    /**
     * GET  /articles : get all the articles.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of articles in body
     */
    @RequestMapping(value = "/articles",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public List<Article> getAllArticles() {
        Integer projid = getProjectId();
        log.debug("REST request to get all Articles  for project {}", projid );
        return articleService.findAll(projid);
    }

    /**
     * GET  /articles/:id : get the "id" article.
     *
     * @param number the id of the article to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the article, or with status 404 (Not Found)
     */
    @RequestMapping(value = "/articles/{number}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<RestResponse<Article>> getArticle( @PathVariable Long number) {
        log.debug("REST request to get Article : {}", number);
        Article article = articleService.findOne(getProjectId(), number);

        return Optional.of(new RestResponse<Article>(0,"", article ))
            .map(result -> new ResponseEntity<>(
                result,
                HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /articles/:id : delete the "id" article.
     *
     * @param  number the id of the article to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @RequestMapping(value = "/articles/{number}",
        method = RequestMethod.DELETE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Void> deleteArticle( @PathVariable Long number) {
        log.debug("REST request to delete Article : {}", number);
        Article article=articleService.findOne(getProjectId(), number);
        if (article==null){
            return ResponseEntity.noContent().build();
        }
        else {
            articleService.delete(article.getId());
            return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("article", number.toString())).build();
        }
    }

}
