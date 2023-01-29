package com.messenger.fileservice.api.dto.image;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ImageDto {
    private Long id;
    private String filename;
    private String originalFilename;
    private Integer size;
    private Integer width;
    private Integer height;
    private String link;
}
