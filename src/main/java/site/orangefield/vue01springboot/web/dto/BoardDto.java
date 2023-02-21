package site.orangefield.vue01springboot.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BoardDto {

    private Integer idx;
    private String title;
    private String contents;
    private String author;
    private String createdAt;
}
