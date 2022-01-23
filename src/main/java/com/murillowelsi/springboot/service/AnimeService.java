package com.murillowelsi.springboot.service;

import com.murillowelsi.springboot.model.domain.AnimeDomain;
import com.murillowelsi.springboot.model.dto.request.AnimePostRequestBody;
import com.murillowelsi.springboot.model.dto.request.AnimePutRequestBody;
import com.murillowelsi.springboot.repository.AnimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AnimeService {

    private final AnimeRepository animeRepository;

    public List<AnimeDomain> findAll(){
        return animeRepository.findAll();
    }

    public AnimeDomain findByIdOrThrowBadRequestException(long id){
        return animeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Anime not found."));
    }

    public AnimeDomain createNewAnime(AnimePostRequestBody animePostRequestBody){
        return animeRepository.save(
                AnimeDomain.builder()
                        .name(animePostRequestBody.getName())
                        .build()
        );
    }

    public void updateAnimeById(AnimePutRequestBody animePutRequestBody){
        AnimeDomain savedAnime = findByIdOrThrowBadRequestException(animePutRequestBody.getId());
        AnimeDomain animeDomain = AnimeDomain.builder()
                .id(savedAnime.getId())
                .name(animePutRequestBody.getName())
                .build();

        animeRepository.save(animeDomain);
    }

    public void deleteAnimeById(long id){
        animeRepository.delete(findByIdOrThrowBadRequestException(id));
    }
}
