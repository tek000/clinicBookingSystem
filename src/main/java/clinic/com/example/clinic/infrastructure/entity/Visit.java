package clinic.com.example.clinic.infrastructure.entity;

import clinic.com.example.clinic.infrastructure.dto.VisitDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Builder
@Getter
@NoArgsConstructor
@Entity(name = "Visit")
@Table(name = "visit")
public class Visit {

    @Id
    private VisitId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("doctorId")
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("patientId")
    private Patient patient;

    @Column(name = "specialization")
    private String specialization;

    @Column(name = "created_on")
    private Date createdOn = new Date();

    @Column(name = "visit_date")
    private Date visitDate = new Date();

    @Column(name = "plan_length")
    private Integer plannedLength;

    @Column(name = "created_by")
    private Long userId;

    @Column(name = "status")
    private VisitStatus status;


    public Visit(VisitId id, Doctor doctor, Patient patient, String specialization,
                 Date createdOn, Date visitDate, Integer plannedLength, Long userId, VisitStatus status) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.specialization = specialization;
        this.createdOn = createdOn;
        this.visitDate = visitDate;
        this.plannedLength = plannedLength;
        this.userId = userId;
        this.status = status;
    }

    public VisitDto toDto() {
        return VisitDto.builder()
                .id(id)
                .doctorId(doctor.getId())
                .doctorFirstName(doctor.getFirstName())
                .doctorLastName(doctor.getLastName())
                .specialization(doctor.getSpecialization())
                .patientFirstName(patient.getFirstName())
                .patientLastName(patient.getLastName())
                .patientAge(patient.getAge())
                .patientId(patient.getId())
                .visitDate(visitDate).build();

    }


    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Visit that = (Visit) o;
        return Objects.equals(doctor, that.doctor) &&
                Objects.equals(patient, that.patient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctor, patient);
    }
}
