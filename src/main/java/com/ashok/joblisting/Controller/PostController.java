package com.ashok.joblisting.Controller;

import com.ashok.joblisting.Model.Post;
import com.ashok.joblisting.Repository.PostRepository;
import com.ashok.joblisting.Repository.SearchRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private SearchRepository searchRepository;
    @ApiIgnore
    @ResponseBody
    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException {
      response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/allPosts")
    public List<Post> getAllPosts(){
     return postRepository.findAll();
    }


    @GetMapping("/posts/{text}")
    public List<Post> search(@PathVariable String text){
        return searchRepository.findByText(text);
    }

    @PostMapping("/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public Post addPost(@RequestBody Post post){
     return postRepository.save(post);
    }
}