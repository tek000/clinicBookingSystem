package clinic.com.example.clinic.infrastructure.entity;

import clinic.com.example.clinic.infrastructure.dto.DoctorDto;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "second_name")
    private String secondName;
    private String specialization;

    @OneToMany
    private Set<DoctorAvailability> doctrDoctDoctrAvailabilities;


    public DoctorDto toDo() {
        return DoctorDto.builder().id(id).firstName(firstName).secondName(secondName).build();
    }
}
