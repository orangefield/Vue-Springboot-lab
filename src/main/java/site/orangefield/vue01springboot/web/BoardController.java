package site.orangefield.vue01springboot.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.orangefield.vue01springboot.service.BoardService;
import site.orangefield.vue01springboot.web.dto.BoardDto;

@RequiredArgsConstructor
@RestController
public class BoardController {
    
    // DI
    private final BoardService boardService;

    @GetMapping("/board/list")
    public List<BoardDto> boardList() { 

        return boardService.getBoardList();
    }

    @GetMapping("/board/{id}")
    public BoardDto getBoard(@PathVariable Integer id) {
        
        return boardService.getBoard(id);
    }

}
