package com.therogueroad.project.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class PostDTO {

    private Long postId;
    private String title;
    private String content;
    private String userName;
    private String displayName;
    private String profilePic;
    private List<LikeDTO> likes = new ArrayList<>();
    private List<CommentDTO> comments = new ArrayList<>();
    private Long saves = null;
    private LocalDateTime createdAt;

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public List<LikeDTO> getLikes() {
        return likes;
    }

    public void setLikes(List<LikeDTO> likes) {
        this.likes = likes;
    }

    public List<CommentDTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentDTO> comments) {
        this.comments = comments;
    }

    public Long getSaves() {
        return saves;
    }

    public void setSaves(Long saves) {
        this.saves = saves;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public PostDTO(Long postId, String title, String content, List<LikeDTO> likes, List<CommentDTO> comments, Long saves, LocalDateTime createdAt) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.likes = likes;
        this.comments = comments;
        this.saves = saves;
        this.createdAt = createdAt;
    }

    public PostDTO() {
    }

    @Override
    public String toString() {
        return "PostDTO{" +
                "postId=" + postId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", likes=" + likes +
                ", comments=" + comments +
                ", saves=" + saves +
                ", createdAt=" + createdAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostDTO postDTO = (PostDTO) o;
        return Objects.equals(postId, postDTO.postId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(postId);
    }
}
