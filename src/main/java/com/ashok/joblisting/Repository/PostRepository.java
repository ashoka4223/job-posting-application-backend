package com.ashok.joblisting.Repository;

import com.ashok.joblisting.Model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {

}
