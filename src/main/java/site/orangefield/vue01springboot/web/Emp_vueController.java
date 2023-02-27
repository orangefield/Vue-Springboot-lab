package site.orangefield.vue01springboot.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.orangefield.vue01springboot.service.Emp_vueService;
import site.orangefield.vue01springboot.web.dto.Emp_vueDto;

@RequiredArgsConstructor
@RestController
public class Emp_vueController {
    
    // DI
    private final Emp_vueService emp_vueService;

    // 게시글 목록 조회하기
    @GetMapping("/emp-vue/list")
    public List<Emp_vueDto> emp_vueList() {
 
        return emp_vueService.getEmpvueList();
    }
}
