package site.orangefield.vue01springboot.service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.orangefield.vue01springboot.domain.board.Board;
import site.orangefield.vue01springboot.domain.board.BoardRepository;
import site.orangefield.vue01springboot.web.dto.BoardDto;

@RequiredArgsConstructor
@Service
public class BoardService {

    // DI
    private final BoardRepository boardRepository;

    // 게시글 목록 가져오기
    public List<BoardDto> getBoardList() {

        List<Board> boards = boardRepository.findAll();
        System.out.println("게시글 목록 가져옵니까? : " + boards.size());

        List<BoardDto> boardDto = new ArrayList<>();
        for (Board board : boards) {

            boardDto.add(
                    BoardDto.builder()
                            .idx(board.getIdx())
                            .author(board.getAuthor())
                            .title(board.getTitle())
                            .contents(board.getContents())
                            .createdAt(board.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))
                            .build());
        }
        return boardDto;
    }
}
