package com.murillowelsi.springboot.controller;

import com.murillowelsi.springboot.model.domain.AnimeDomain;
import com.murillowelsi.springboot.model.dto.request.AnimePostRequestBody;
import com.murillowelsi.springboot.model.dto.request.AnimePutRequestBody;
import com.murillowelsi.springboot.service.AnimeService;
import com.murillowelsi.springboot.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("animes")
@Log4j2
@RequiredArgsConstructor
public class AnimeController {
    private final DateUtil dateUtil;
    private final AnimeService animeService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<AnimeDomain> list(){
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return animeService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AnimeDomain findById(@PathVariable long id){
        return animeService.findByIdOrThrowBadRequestException(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public AnimeDomain createNewAnime(@RequestBody AnimePostRequestBody animePostRequestBody){
        return animeService.createNewAnime(animePostRequestBody);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAnimeById(@RequestBody AnimePutRequestBody animePutRequestBody){
        animeService.updateAnimeById(animePutRequestBody);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAnimeById(@PathVariable long id){
        animeService.deleteAnimeById(id);
    }
}
