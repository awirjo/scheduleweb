package sr.unasat.scheduleweb.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    private String regular_break;
    @OneToMany(mappedBy = "department")
    @Column
    private Set<Employees> employees;
    @ManyToMany
    @JoinTable(name = "breakTime_department"
            , joinColumns = {@JoinColumn(name = "department_id")},
            inverseJoinColumns = {@JoinColumn(name = "breakTime_id")})
    private Set<BreakTime> breakTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegular_break() {
        return regular_break;
    }

    public void setRegular_break(String regular_break) {
        this.regular_break = regular_break;
    }

    public Set<Employees> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employees> employees) {
        this.employees = employees;
    }

    public Set<BreakTime> getBreakTime() {
        return breakTime;
    }

    public void setBreakTime(Set<BreakTime> breakTime) {
        this.breakTime = breakTime;
    }
    //    public Set<BreakTime> getBreakTime() {
//        return breakTime;
//    }
//
//    public void setBreakTime(Set<BreakTime> breakTime) {
//        this.breakTime = breakTime;
//    }


    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                '}';
    }
}
