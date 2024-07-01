package com.workspacemongodbcs.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.workspacemongodbcs.DTO.AuthorDTO;
import com.workspacemongodbcs.DTO.CommentDTO;
import com.workspacemongodbcs.domain.Post;
import com.workspacemongodbcs.domain.User;
import com.workspacemongodbcs.repository.PostRepository;
import com.workspacemongodbcs.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        // Clear Database collections
        userRepository.deleteAll();
        postRepository.deleteAll();

        User paul = new User(null, "Paul Anka", "paul@paul.test");
        User elvis = new User(null, "Elvis Presley", "elvis@elvis.test");

        // Save all User Collection
        userRepository.saveAll(Arrays.asList(paul, elvis));

     
     // Create a sample post with comments
        Post post0 = new Post(null, 
        		sdf.parse("26/06/2024"), 
                "I Love God",
                "I pray to God every day!", 
                new AuthorDTO(paul));

     // Create a sample comment
        CommentDTO cmt0 = new CommentDTO("Nice job!", 
        		sdf.parse("01/06/2024"), 
        		 new AuthorDTO(elvis));
        
        
        //Association        
        post0.getComments().addAll(Arrays.asList(cmt0));

        // Save all Post Collection
        postRepository.saveAll(Arrays.asList(post0));


        // Associate posts with users
        paul.getPosts().addAll(Arrays.asList(post0));
        userRepository.save(paul);
    }
}
