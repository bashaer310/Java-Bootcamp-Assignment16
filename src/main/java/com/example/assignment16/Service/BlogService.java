package com.example.assignment16.Service;


import com.example.assignment16.Api.ApiException;
import com.example.assignment16.Model.Blog;
import com.example.assignment16.Model.User;
import com.example.assignment16.Repository.AuthRepository;
import com.example.assignment16.Repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;
    private final AuthRepository authRepository;

    public List<Blog> getAll(){
        return  blogRepository.findAll();
    }
    public void add(User user, Blog blog){

        blog.setUser(user);
        blogRepository.save(blog);
    }
    public void update(Blog blog,Integer id,User user){
        Blog oldBlog=blogRepository.findBlogByIdAndUser(id,user);

        if(oldBlog == null)
            throw new ApiException("Id or User not found");
        oldBlog.setTitle(blog.getTitle());
        oldBlog.setBody(blog.getBody());
        blogRepository.save(oldBlog);
    }
    public void delete(Integer id,User user){
        Blog blog=blogRepository.findBlogByIdAndUser(id,user);

        if(blog == null)
            throw new ApiException("Id or User not found");
        blogRepository.delete(blog);
    }

    public List<Blog> getUserBlog(User user){
        List<Blog> blogs=blogRepository.findAllByUser(user);

        if(blogs == null)
            throw new ApiException("Blogs not found");

        return blogs;
    }
    public Blog getBlogById(User user,Integer blogId){
        Blog blog=blogRepository.findBlogByIdAndUser(blogId,user);

        if(blog == null)
            throw new ApiException("Blog not found");

        return blog;
    }
    public Blog getBlogByTitle(User user,String title){
        Blog blog=blogRepository.findBlogByTitleAndUser(title,user);

        if(blog == null)
            throw new ApiException("Blog not found");

        return blog;
    }


}
