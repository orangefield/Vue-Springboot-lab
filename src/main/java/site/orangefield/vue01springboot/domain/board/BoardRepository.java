package site.orangefield.vue01springboot.domain.board;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BoardRepository extends JpaRepository<Board, Integer>{
    
    @Query(value = "SELECT * FROM board ORDER BY createdat DESC", nativeQuery = true)
    List<Board> findBoardList();
}
