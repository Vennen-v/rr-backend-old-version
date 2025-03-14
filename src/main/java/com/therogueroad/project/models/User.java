package com.therogueroad.project.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    @OneToMany(mappedBy = "user")
    private List<Post> savedPosts;

    @OneToMany(mappedBy = "user")
    private List<Like> likedPosts;

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

}
