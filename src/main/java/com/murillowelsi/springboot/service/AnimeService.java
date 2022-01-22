package com.murillowelsi.springboot.service;

import com.murillowelsi.springboot.domain.AnimeDomain;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeService {
    public List<AnimeDomain> listAll(){
        return List.of(new AnimeDomain(1L,"DBZ"), new AnimeDomain(2L, "Sakura"));
    }
}
