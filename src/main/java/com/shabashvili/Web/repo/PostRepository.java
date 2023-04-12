package com.shabashvili.Web.repo;

import com.shabashvili.Web.models.Post;

import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Integer> {

}
