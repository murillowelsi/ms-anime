package com.murillowelsi.springboot.model.mapper;

import com.murillowelsi.springboot.model.domain.AnimeDomain;
import com.murillowelsi.springboot.model.dto.request.AnimeRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class AnimeMapper {

    public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);

    public abstract AnimeDomain toAnime(AnimeRequest animeRequest);

}
