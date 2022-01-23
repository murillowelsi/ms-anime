package com.murillowelsi.springboot.service;

import com.murillowelsi.springboot.model.domain.AnimeDomain;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


@Service
public class AnimeService {
    private static final List<AnimeDomain> animes;

    static {
        animes = new ArrayList<>(List.of(new AnimeDomain(1L,"DBZ"), new AnimeDomain(2L, "Sakura")));
    }

    public List<AnimeDomain> findAll(){
        return animes;
    }

    public AnimeDomain findById(long id){
        return animes.stream()
                .filter(anime -> anime.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Anime not found."));
    }

    public AnimeDomain createNewAnime(AnimeDomain animeDomain){
        animeDomain.setId(ThreadLocalRandom.current().nextLong(3,100));
        animes.add(animeDomain);

        return animeDomain;
    }

    public void updateAnimeById(AnimeDomain animeDomain){
        deleteAnimeById(animeDomain.getId());
        animes.add(animeDomain);
    }

    public void deleteAnimeById(long id){
        animes.remove(findById(id));
    }
}
