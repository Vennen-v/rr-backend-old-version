package com.therogueroad.project.models;

import jakarta.persistence.*;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String userName;

    private String displayName;

    private String profilePic;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @OneToMany
    @JoinColumn(name = "parent_id")
    private List<Comment> replies;

    @OneToMany(mappedBy = "comment")
    private List<Like> likes = new ArrayList<>();

    private LocalDateTime createdAt;

    public Comment(Long commentId, String content, User user, String userName, String displayName, String profilePic, Post post, List<Comment> replies, List<Like> likes, LocalDateTime createdAt) {
        this.commentId = commentId;
        this.content = content;
        this.user = user;
        this.userName = userName;
        this.displayName = displayName;
        this.profilePic = profilePic;
        this.post = post;
        this.replies = replies;
        this.likes = likes;
        this.createdAt = createdAt;
    }

    public Comment() {
    }

    public void addCommentReply(Comment comment){
        if (replies == null) {
            replies = new ArrayList<>();
        }
        replies.add(comment);
    }



    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getProfilePic() {
        return this.profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public List<Comment> getReplies() {
        return replies;
    }

    public void setReplies(List<Comment> replies) {
        this.replies = replies;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", content='" + content + '\'' +
                ", user=" + user +
                ", post=" + post +
                ", replies=" + replies +
                ", likes=" + likes +
                ", createdAt=" + createdAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(commentId, comment.commentId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(commentId);
    }
}
