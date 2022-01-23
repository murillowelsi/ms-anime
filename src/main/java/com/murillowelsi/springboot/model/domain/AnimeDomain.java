package com.murillowelsi.springboot.model.domain;

import com.murillowelsi.springboot.model.dto.request.AnimeRequest;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AnimeDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public static AnimeDomain valueOf(AnimeRequest animeRequest) {
        return builder()
                .name(animeRequest.getName())
                .build();
    }
}
