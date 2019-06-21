package clinic.com.example.clinic.infrastructure.entity;


import clinic.com.example.clinic.infrastructure.dto.DoctorDto;
import clinic.com.example.clinic.infrastructure.dto.PatientDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "patient")
public class Patient {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "pesel")
    private Long pesel;

    public PatientDto toDto() {
        return PatientDto.builder().id(id)
                .firstName(firstName)
                .lastName(lastName)
                .age(getAge())
                .build();
    }


    public Integer getAge() {

        //future feature
        return 25;
    }
}
