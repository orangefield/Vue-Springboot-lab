package site.orangefield.vue01springboot.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        List<Board> boardsEntity = boardRepository.findAll();
        // System.out.println("게시글 목록 가져옵니까? : " + boardsEntity.size());

        List<BoardDto> boardDto = new ArrayList<>();
        for (Board boardEntity : boardsEntity) {

            boardDto.add(
                    BoardDto.builder()
                            .idx(boardEntity.getIdx())
                            .author(boardEntity.getAuthor())
                            .title(boardEntity.getTitle())
                            .contents(boardEntity.getContents())
                            .createdAt(
                                    boardEntity.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))
                            .build());
        }
        return boardDto;
    }

    // 게시글 한 건 상세조회
    public BoardDto getBoard(Integer id) {
        Optional<Board> boardOp = boardRepository.findById(id);
        if (boardOp.isPresent()) {
            Board boardEntity = boardOp.get();
            // System.out.println("boardEntity 상세조회 : " + boardEntity);

            return BoardDto.builder()
                    .idx(boardEntity.getIdx())
                    .title(boardEntity.getTitle())
                    .contents(boardEntity.getContents())
                    .author(boardEntity.getAuthor())
                    .createdAt(boardEntity.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))
                    .build();
        } else {
            throw new RuntimeException("게시글을 찾을 수 없습니다");
        }
    }

    // 게시글 쓰기
    @Transactional
    public Board writeBoard(BoardDto boardDto) {
        Board boardEntity = Board.builder()
                .title(boardDto.getTitle())
                .contents(boardDto.getContents())
                .author(boardDto.getAuthor())
                .createdAt(LocalDateTime.now())
                .build();

        return boardRepository.save(boardEntity);
    }

    // 게시글 수정하기
    @Transactional
    public Board updateBoard(BoardDto boardDto) {
        Optional<Board> boardOp = boardRepository.findById(boardDto.getIdx());
        if (boardOp.isPresent()) {
            Board boardEntity = boardOp.get();
            // System.out.println("boardEntity 수정 : " + boardEntity);

            boardEntity.setTitle(boardDto.getTitle());
            boardEntity.setContents(boardDto.getContents());
            
            return boardRepository.save(boardEntity);
        } else {
            throw new RuntimeException("게시글을 찾을 수 없습니다");
        }
    }

    // 게시글 삭제하기
    @Transactional
    public void deleteBoard(Integer id){
        Optional<Board> boardOp = boardRepository.findById(id);
        if(boardOp.isPresent()) {
            Board boardEntity = boardOp.get();
            // System.out.println("boardEntity 삭제 : " + boardEntity);

            boardRepository.delete(boardEntity);
        }
    }

}
