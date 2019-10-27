package com.cafecostes.cafe.repository;

import com.cafecostes.cafe.DB.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface MenuRepository extends CrudRepository<Menu, Long> {


    Iterable<Menu> findAllById(int i);
    Iterable<Menu> findAllByMenuName(String i);
}