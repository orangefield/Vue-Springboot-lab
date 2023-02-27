package site.orangefield.vue01springboot.domain.emp_vue;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Emp_vue {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String emp_no;

    private String emp_name;

}
