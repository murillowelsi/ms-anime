package com.murillowelsi.springboot.model.domain;

import lombok.*;

@Getter
@Setter
@Builder
@Data
@AllArgsConstructor
public class AnimeDomain {
    private Long id;
    private String name;
}
