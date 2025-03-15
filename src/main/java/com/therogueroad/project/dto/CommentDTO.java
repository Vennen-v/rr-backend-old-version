package com.therogueroad.project.dto;

import com.therogueroad.project.models.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;


public class CommentDTO {

    private Long commentId;
    private String content;
    private String userName;
    private String displayName;
    private String profilePic;
    private List<CommentDTO> replies;
    private List<LikeDTO> likes;
    private LocalDateTime createdAt;

    public CommentDTO(Long commentId, String content, String userName, String displayName, String profilePic, List<CommentDTO> replies, List<LikeDTO> likes, LocalDateTime createdAt) {
        this.commentId = commentId;
        this.content = content;

        this.displayName = displayName;
        this.userName = userName;
        this.profilePic = profilePic;
        this.replies = replies;
        this.likes = likes;
        this.createdAt = createdAt;
    }

    public CommentDTO() {
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


    public String getUserName() {
        return userName;
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
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public List<CommentDTO> getReplies() {
        return replies;
    }

    public void setReplies(List<CommentDTO> replies) {
        this.replies = replies;
    }

    public List<LikeDTO> getLikes() {
        return likes;
    }

    public void setLikes(List<LikeDTO> likes) {
        this.likes = likes;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentDTO that = (CommentDTO) o;
        return Objects.equals(commentId, that.commentId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(commentId);
    }

    @Override
    public String toString() {
        return "CommentDTO{" +
                "commentId=" + commentId +
                ", content='" + content + '\'' +
                ", replies=" + replies +
                ", likes=" + likes +
                ", createdAt=" + createdAt +
                '}';
    }
}
