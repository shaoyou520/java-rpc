package com.demo.service.Impl;

import com.demo.entry.Blog;
import com.demo.service.BlogService;

public class BlogServiceImpl implements BlogService {
    @Override
    public Blog getBlogById(Integer id) {
        return new Blog(id, "name:" + id, "desc:" + id);
    }
}
