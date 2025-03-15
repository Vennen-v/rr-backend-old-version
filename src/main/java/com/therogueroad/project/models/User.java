package com.therogueroad.project.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    private String displayName;

    private String userName;

    @Email
    private String email;

    private String password;

    private String profilePic = "default.png";

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @Column(name = "user_posts")
    private List<Post> userPosts = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Post> savedPosts = new ArrayList<>();

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<Like> likedPosts = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "following_id")
    private List<User> following = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "follower_id")
    private List<User> followers = new ArrayList<>();

    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public User(Long userId, String displayName, String userName, String email, String password, String profilePic, List<Post> savedPosts, List<Like> likedPosts, List<User> following, List<User> followers) {
        this.userId = userId;
        this.displayName = displayName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.profilePic = profilePic;
        this.savedPosts = savedPosts;
        this.likedPosts = likedPosts;
        this.following = following;
        this.followers = followers;
    }

    public User() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public List<Post> getUserPosts() {
        return userPosts;
    }

    public void setUserPosts(List<Post> posts) {
        this.userPosts = posts;
    }

    public List<Post> getSavedPosts() {
        return savedPosts;
    }

    public void setSavedPosts(List<Post> savedPosts) {
        this.savedPosts = savedPosts;
    }

    public List<Like> getLikedPosts() {
        return likedPosts;
    }

    public void setLikedPosts(List<Like> likedPosts) {
        this.likedPosts = likedPosts;
    }

    public List<User> getFollowing() {
        return following;
    }

    public void setFollowing(List<User> following) {
        this.following = following;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    @Override
    public String toString() {
        return "User{" +
                ", displayName='" + displayName + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", profilePic='" + profilePic + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(userId);
    }
}
