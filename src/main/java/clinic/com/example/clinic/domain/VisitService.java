package clinic.com.example.clinic.domain;

import clinic.com.example.clinic.infrastructure.dto.VisitDto;
import clinic.com.example.clinic.infrastructure.entity.Doctor;
import clinic.com.example.clinic.infrastructure.entity.Patient;
import clinic.com.example.clinic.infrastructure.entity.Visit;
import clinic.com.example.clinic.infrastructure.entity.VisitStatus;
import clinic.com.example.clinic.infrastructure.repository.DoctorRepository;
import clinic.com.example.clinic.infrastructure.repository.PatientRepository;
import clinic.com.example.clinic.infrastructure.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class VisitService {

    @Autowired
    private VisitRepository visitRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;

    public void createOrUpdate(VisitDto dto) {


        Doctor foundDoctor = doctorRepository
                .findById(dto.getDoctorId())
                .orElseThrow(() -> new IllegalStateException("Nie ma takiego doktora"));

        Patient foundPtient = patientRepository
                .findById(dto.getPatientId())
                .orElseThrow(() -> new IllegalStateException("Nie ma takiego doktora"));

        Visit visit = Visit.builder()
                .id(dto.getId())
                .doctor(foundDoctor)
                .patient(foundPtient)
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
