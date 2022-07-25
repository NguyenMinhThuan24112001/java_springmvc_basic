package com.learnSpringMVC.repository;

import com.learnSpringMVC.entity.NewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewRepository extends JpaRepository<NewEntity,Long> {
}
