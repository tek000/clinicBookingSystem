package clinic.com.example.clinic.infrastructure.entity;

import clinic.com.example.clinic.infrastructure.dto.PatientDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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
    private Long pesel;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient", cascade = CascadeType.REMOVE)
//    @JoinColumn(name = "visitId")
            List<Visit> visits;

    public PatientDto toDto() {
        return PatientDto.builder().id(id)
                .firstName(firstName)
                .lastName(lastName)
                .pesel(pesel)
                .age(getAge(Long.toString(pesel)))
                .build();
    }

    public Integer getAge(String pesel) {
        Pesel pesel1 = new Pesel(pesel);
        return pesel1.getAge();
    }
}
