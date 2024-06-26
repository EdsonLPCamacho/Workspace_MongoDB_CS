package com.workspacemongodbcs.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.workspacemongodbcs.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

}
