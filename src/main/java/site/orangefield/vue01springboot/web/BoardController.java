package site.orangefield.vue01springboot.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.orangefield.vue01springboot.domain.board.Board;
import site.orangefield.vue01springboot.service.BoardService;
import site.orangefield.vue01springboot.web.dto.BoardDto;

@RequiredArgsConstructor
@RestController
public class BoardController {
    
    // DI
    private final BoardService boardService;

    // 게시글 목록 조회하기
    @GetMapping("/board/list")
    public List<BoardDto> boardList() { 

        return boardService.getBoardList();
    }

    // 게시글 한 건 상세조회
    @GetMapping("/board/{id}")
    public BoardDto getBoard(@PathVariable Integer id) {
        
        return boardService.getBoard(id);
    }

    // 게시글 쓰기
    @PostMapping("/board")
    public Board write(@RequestBody BoardDto boardDto){

        return boardService.writeBoard(boardDto);
    }
}
