package com.therogueroad.project.services;

import com.therogueroad.project.dto.PostDTO;
import com.therogueroad.project.models.Post;
import com.therogueroad.project.models.User;
import com.therogueroad.project.repositories.PostRepository;
import com.therogueroad.project.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.time.LocalDateTime;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PostDTO createPost(PostDTO postDTO) {
        Post post = modelMapper.map(postDTO, Post.class);

        User user = new User("yoshi35", "yoshi@gmail.com", "meepmoop");
        user.setDisplayName("Yoshi Vennen");
        userRepository.save(user);

        List<Post> userPost = user.getUserPosts();

        post.setTitle(postDTO.getTitle());
        post.setUser(user);
        post.setUserName(user.getUserName());
        post.setDisplayName(user.getDisplayName());
        post.setProfilePic(user.getProfilePic());
        post.setContent(postDTO.getContent());
        post.setCreatedAt(LocalDateTime.now());

        postRepository.save(post);

        userPost.add(post);

        return modelMapper.map(post, PostDTO.class);
    }

    @Override
    public List<PostDTO> getAllPost() {
        List<Post> posts = postRepository.findAll();

        List<PostDTO> postDTOS = posts.stream().map(p -> modelMapper.map(p, PostDTO.class)).toList();

        return postDTOS;
    }

    @Override
    public List<PostDTO> getPostsByUserId(Long userId) {
         User user = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("User Not Found"));

         List<Post> posts = user.getUserPosts();

        List<PostDTO> postDTOS = posts.stream().map(p -> modelMapper.map(p, PostDTO.class)).toList();

        return postDTOS;
    }

    @Override
    public void deletePost(Long postId) {
        Post deletedPost = postRepository.findById(postId).orElseThrow(()-> new RuntimeException("Post Not Found"));
        postRepository.delete(deletedPost);
    }

    @Override
    public PostDTO updatePost(PostDTO postDTO, Long postId) {
       Post post = postRepository.findById(postId).orElseThrow(()-> new RuntimeException("Post Not Found"));

       post.setPostId(postId);
       post.setTitle(postDTO.getTitle());
       post.setContent(postDTO.getContent());

       postRepository.save(post);

       return modelMapper.map(post, PostDTO.class);

    }

    // Create Get Current Users Post


}
