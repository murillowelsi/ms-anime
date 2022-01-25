package com.murillowelsi.springboot.service;

import com.murillowelsi.springboot.model.domain.AnimeDomain;
import com.murillowelsi.springboot.model.dto.request.AnimeRequest;
import com.murillowelsi.springboot.model.mapper.AnimeMapper;
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

    public List<AnimeDomain> findAll() {
        return animeRepository.findAll();
    }

    public List<AnimeDomain> findByName(String name) {
        return animeRepository.findByName(name);
    }

    public AnimeDomain findByIdOrThrowBadRequestException(long id) {
        return animeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Anime not found."));
    }

    public AnimeDomain createNewAnime(AnimeRequest animeRequest) {
        return animeRepository.save(AnimeMapper.INSTANCE.toAnime(animeRequest));
    }

    public void updateAnimeById(long id, AnimeRequest animeRequest) {
        findByIdOrThrowBadRequestException(id);

        AnimeDomain updatedAnimeDomain = AnimeDomain.valueOf(animeRequest);
        updatedAnimeDomain.setId(id);

        animeRepository.save(updatedAnimeDomain);
    }

    public void deleteAnimeById(long id) {
        animeRepository.delete(findByIdOrThrowBadRequestException(id));
    }
}
