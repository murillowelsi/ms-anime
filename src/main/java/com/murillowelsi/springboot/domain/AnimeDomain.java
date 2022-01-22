package com.murillowelsi.springboot.domain;

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
