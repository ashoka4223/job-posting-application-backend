package com.ashok.joblisting.Repository;

import com.ashok.joblisting.Model.Post;

import java.util.List;

public interface SearchRepository {
    List<Post> findByText(String text);
}
