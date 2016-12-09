package com.sh.jhipster.gw.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.sh.jhipster.gw.domain.Comments;
import com.sh.jhipster.gw.service.CommentsService;
import com.sh.jhipster.gw.web.rest.util.HeaderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Comments.
 */
@RestController
@RequestMapping("/api/articles/{articid}/")
public class CommentsResource  extends AbstractResource{

    private final Logger log = LoggerFactory.getLogger(CommentsResource.class);

    @Inject
    private CommentsService commentsService;

    /**
     * POST  /comments : Create a new comments.
     *
     * @param comments the comments to create
     * @return the ResponseEntity with status 201 (Created) and with body the new comments, or with status 400 (Bad Request) if the comments has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @RequestMapping(value = "/comments",
        method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Comments> createComments(@PathVariable String articid ,  @Valid @RequestBody Comments comments) throws URISyntaxException {
        log.debug("REST request to save Comments : {}", comments);
        if (comments.getNumber() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("comments", "idexists", "A new comments cannot already have an ID")).body(null);
        }
        Comments result = commentsService.save(getProjectId(), Long.valueOf(articid), comments);
        return ResponseEntity.created(new URI("/api/comments/" + result.getNumber()))
            .headers(HeaderUtil.createEntityCreationAlert("comments", result.getNumber().toString()))
            .body(result);
    }

    /**
     * PUT  /comments : Updates an existing comments.
     *
     * @param comments the comments to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated comments,
     * or with status 400 (Bad Request) if the comments is not valid,
     * or with status 500 (Internal Server Error) if the comments couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @RequestMapping(value = "/comments",
        method = RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Comments> updateComments(@PathVariable String articid , @Valid @RequestBody Comments comments) throws URISyntaxException {
        log.debug("REST request to update Comments : {}", comments);
        if (comments.getNumber() == null) {
            return createComments(articid, comments);
        }
        Comments result = commentsService.save(getProjectId(), Long.valueOf(articid), comments);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert("comments", comments.getNumber().toString()))
            .body(result);
    }

    /**
     * GET  /comments : get all the comments.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of comments in body
     */
    @RequestMapping(value = "/comments",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public List<Comments> getAllComments(@PathVariable long articid ) {
        log.debug("REST request to get all Comments");
        return commentsService.findAll(getProjectId(), articid);
    }

    /**
     * GET  /comments/:id : get the "id" comments.
     *
     * @param number the id of the comments to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the comments, or with status 404 (Not Found)
     */
    @RequestMapping(value = "/comments/{number}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Comments> getComments(@PathVariable long articid ,@PathVariable long number) {
        log.debug("REST request to get Comments : {}", number);
        Comments comments = commentsService.findOne(getProjectId(), articid,  number);
        return Optional.ofNullable(comments)
            .map(result -> new ResponseEntity<>(
                result,
                HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /comments/:number : delete the "number" comments.
     *
     * @param number the number of the comments to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @RequestMapping(value = "/comments/{number}",
        method = RequestMethod.DELETE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Void> deleteComments(@PathVariable long  articid , @PathVariable Long number) {
        log.debug("REST request to delete Comments : {}", number);
        final int  count= commentsService.delete(getProjectId(), articid, number);
        if (count>0){
            return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("comments", number.toString())).build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
