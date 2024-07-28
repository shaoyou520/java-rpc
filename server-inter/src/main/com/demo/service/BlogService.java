package com.demo.service;

import com.demo.entry.Blog;

import java.util.List;

public interface BlogService {

    Blog getBlogById(Integer id);

    List<Blog> getBlogs();

    void printDate();
}
