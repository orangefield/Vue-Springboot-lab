package site.orangefield.vue01springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.orangefield.vue01springboot.domain.emp_vue.Emp_vue;
import site.orangefield.vue01springboot.domain.emp_vue.Emp_vueRepository;
import site.orangefield.vue01springboot.web.dto.Emp_vueDto;

@RequiredArgsConstructor
@Service
public class Emp_vueService {
    
    // DI
    private final Emp_vueRepository emp_vueRepository;

    // 게시글 목록 가져오기
    public List<Emp_vueDto> getEmpvueList(){
        List<Emp_vue> empVuesEntity = emp_vueRepository.findAll();
        
        List<Emp_vueDto> empVueDto = new ArrayList<>();

        for (Emp_vue empVueEntity : empVuesEntity) {
            empVueDto.add(
                Emp_vueDto.builder()
                .emp_no(empVueEntity.getEmp_no())
                .emp_name(empVueEntity.getEmp_name())
                .build());
        }
        
        return empVueDto;
    }
}
