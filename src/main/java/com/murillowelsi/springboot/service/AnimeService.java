package com.murillowelsi.springboot.service;

import com.murillowelsi.springboot.domain.AnimeDomain;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimeService {
    private final List<AnimeDomain> animes = List.of(new AnimeDomain(1L,"DBZ"), new AnimeDomain(2L, "Sakura"));

    public List<AnimeDomain> listAll(){
        return animes;
    }

    public AnimeDomain findById(long id){
        return animes.stream()
                .filter(anime -> anime.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Anime not found."));
    }
}
