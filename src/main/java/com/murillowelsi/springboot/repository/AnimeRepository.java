package com.murillowelsi.springboot.repository;

import com.murillowelsi.springboot.domain.AnimeDomain;

import java.util.List;

public interface AnimeRepository {
    List<AnimeDomain> listAll();
}
