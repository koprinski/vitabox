package com.omisoft.vitafu.entity;

import javax.persistence.Entity;

/**
 * Holds user comments
 * Created by dido on 11/4/14.
 */
@Entity
public class Comment extends BaseEntity {
    private String commentText;
    private Integer commentVotes;
    private String commentAuthor;

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Integer getCommentVotes() {
        return commentVotes;
    }

    public void setCommentVotes(Integer commentVotes) {
        this.commentVotes = commentVotes;
    }

    public String getCommentAuthor() {
        return commentAuthor;
    }

    public void setCommentAuthor(String commentAuthor) {
        this.commentAuthor = commentAuthor;
    }
}
