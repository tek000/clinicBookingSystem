package clinic.com.example.clinic.infrastructure.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "patient")
public class Visits {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "doctor_id")
    private Long doctor_id;

    @Column(name = "patient_id")
    private Long patient_id;
}
