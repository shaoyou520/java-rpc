package com.demo.service.Impl;

import com.demo.entry.Blog;
import com.demo.service.BlogService;

import java.util.List;

public class BlogServiceImpl implements BlogService {
    @Override
    public Blog getBlogById(Integer id) {
        return new Blog(id, "name:" + id, "desc:" + id);
    }

    @Override
    public List<Blog> getBlogs() {
        return List.of(new Blog(0, "xx", "pp"), new Blog(1, "张三", "张三你好"));
    }

    @Override
    public void printDate() {
        System.out.println("void 测试");
    }
}
