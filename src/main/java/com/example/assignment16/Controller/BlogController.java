package com.example.assignment16.Controller;


import com.example.assignment16.Api.ApiResponse;
import com.example.assignment16.Model.Blog;
import com.example.assignment16.Model.User;
import com.example.assignment16.Service.BlogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/blog")
public class BlogController {

    private final BlogService blogService;


    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(blogService.getAll());
    }


    @PostMapping("/add")
    public ResponseEntity add(@AuthenticationPrincipal User user, @RequestBody @Valid Blog blog){
        blogService.add(user, blog);
        return ResponseEntity.status(200).body(new ApiResponse("Blog added"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity update(@AuthenticationPrincipal User user,@RequestBody @Valid Blog blog,@PathVariable Integer id){
        blogService.update(blog,id,user);
        return ResponseEntity.status(200).body(new ApiResponse("Blog updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@AuthenticationPrincipal User user, @PathVariable Integer id){
        blogService.delete(id,user);
        return ResponseEntity.status(200).body(new ApiResponse("Blog deleted"));
    }

    @GetMapping("/getUserBlogs")
    public ResponseEntity getUserBlogs(@AuthenticationPrincipal User user){
        return ResponseEntity.status(200).body(blogService.getUserBlog(user));
    }

    @GetMapping("/getBlogById/{id}")
    public ResponseEntity getBlogById(@AuthenticationPrincipal User user,@PathVariable Integer id){
        return ResponseEntity.status(200).body(blogService.getBlogById(user,id));
    }
    @GetMapping("/getBlogByTitle/{title}")
    public ResponseEntity getBlogByTitle(@AuthenticationPrincipal User user,@PathVariable String title){
        return ResponseEntity.status(200).body(blogService.getBlogByTitle(user,title));
    }



}
