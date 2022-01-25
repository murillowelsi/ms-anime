package com.murillowelsi.springboot.repository;

import com.murillowelsi.springboot.model.domain.AnimeDomain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimeRepository extends JpaRepository<AnimeDomain, Long> {
    List<AnimeDomain> findByName(String name);
}
