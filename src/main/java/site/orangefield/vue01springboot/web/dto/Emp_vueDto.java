package site.orangefield.vue01springboot.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Emp_vueDto {
    
    private String emp_no;
    private String emp_name;
}
