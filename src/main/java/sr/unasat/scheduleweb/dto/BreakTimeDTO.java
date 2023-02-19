package sr.unasat.scheduleweb.dto;

import lombok.Getter;
import lombok.Setter;
import sr.unasat.scheduleweb.entities.Department;
import sr.unasat.scheduleweb.entities.Menu;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class BreakTimeDTO {

    private int id;
    private String serving_time;
    private LocalDate serving_date;
    private Menu menu;
    private Set<Department> department;


}
