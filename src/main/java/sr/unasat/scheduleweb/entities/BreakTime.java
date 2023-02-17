package sr.unasat.scheduleweb.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
//@ToString
@Setter
@Getter
@Entity
@JsonIgnoreProperties({"menu", "department"})
public class BreakTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column (unique = false)
    private String serving_time;
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private LocalDate serving_date;
    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;
    @ManyToMany
    @JoinTable(name = "breakTime_department"
            , joinColumns = {@JoinColumn(name = "breakTime_id")},
            inverseJoinColumns = {@JoinColumn(name = "department_id")})
    private Set<Department> department;



    // add department set.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServing_time() {
        return serving_time;
    }

    public void setServing_time(String serving_time) {
        this.serving_time = serving_time;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Set<Department> getDepartment() {
        return department;
    }

    public void setDepartment(Set<Department> department) {
        this.department = department;
    }

    public LocalDate getServing_date() {
        return serving_date;
    }

    public void setServing_date(LocalDate serving_date) {
        this.serving_date = serving_date;
    }

    @Override
    public String toString() {
        return "BreakTime{" +
                "serving_time='" + serving_time + '\'' +
                ", serving_date=" + serving_date +
                ", menu=" + menu +
                ", department=" + department +
                '}';
    }
}
