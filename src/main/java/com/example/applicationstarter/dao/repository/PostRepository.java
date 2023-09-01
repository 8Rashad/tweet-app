package com.example.applicationstarter.dao.repository;

import com.example.applicationstarter.dao.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
