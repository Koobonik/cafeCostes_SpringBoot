package com.cafecostes.cafe.repository;

import com.cafecostes.cafe.DB.CafePosts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.stream.Stream;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface CafePostsRepository extends CrudRepository<CafePosts, Integer> {

    CafePosts findById(int i);
    @Query("SELECT p " +
            "FROM CafePosts p " +
            "ORDER BY p.id DESC")
    Iterable<CafePosts> findAllDesc();
}