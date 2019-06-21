package clinic.com.example.clinic.domain;

import clinic.com.example.clinic.infrastructure.dto.DoctorDto;
import clinic.com.example.clinic.infrastructure.dto.VisitDto;
import clinic.com.example.clinic.infrastructure.entity.*;
import clinic.com.example.clinic.infrastructure.repository.DoctorRepository;
import clinic.com.example.clinic.infrastructure.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class VisitService {

    private final VisitRepository visitRepository;

    public void createOrUpdate(VisitDto dto) {

        Doctor newDoctor = Doctor.builder()
                .id(dto.getDoctorId())
                .firstName(dto.getDoctorFirstName())
                .lastName(dto.getDoctorLastName())
                .specialization(dto.getSpecialization())
                .build();

        Patient newPatient = Patient.builder()
                .id(dto.getPatientId())
                .firstName(dto.getPatientFirstName())
                .lastName(dto.getPatientLastName())
                .build();

        Visit visit = Visit.builder()
                .id(dto.getId())
                .doctor(newDoctor)
                .patient(newPatient)
                .plannedLength(getStandardVisitLengthForSpecialization(dto.getSpecialization()))
                .visitDate(dto.getVisitDate())
                .status(VisitStatus.PLAN)
                .userId(getCreationVisitUserId())
                .createdOn(Date.from(Instant.now()))
                .specialization(dto.getSpecialization())
                .build();
        visitRepository.save(visit);

    }

    public void delete(Long visitId) {
        visitRepository.deleteById(visitId);

    }

    private Long getCreationVisitUserId() {

        //future feature
        return 1L;
    }

    private Integer getStandardVisitLengthForSpecialization(String specialization) {

        //future feature
        return 15;
    }


}
