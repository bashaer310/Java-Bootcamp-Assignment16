package com.example.assignment16.Repository;

import com.example.assignment16.Model.Blog;
import com.example.assignment16.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {
    List<Blog> findAllByUser(User user);
    Blog findBlogByIdAndUser(Integer id,User user);
    Blog findBlogByTitleAndUser(String title,User user);

}
