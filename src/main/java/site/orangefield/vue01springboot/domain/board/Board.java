package site.orangefield.vue01springboot.domain.board;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Board {
    
    @Id
    @GeneratedValue
    private Integer idx;

    private String title;
    private String contents;
    private String author;
    private LocalDateTime createdAt;

}
