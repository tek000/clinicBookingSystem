package clinic.com.example.clinic.domain;

import clinic.com.example.clinic.infrastructure.dto.DoctorDto;
import clinic.com.example.clinic.infrastructure.entity.Doctor;
import clinic.com.example.clinic.infrastructure.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DoctorService.class);

    private final DoctorRepository doctorRepository;

    public void createOrUpdate(DoctorDto dto) {

        Doctor doctor = Doctor.builder().firstName(dto.getFirstName())
                .id(dto.getId())
                .lastName(dto.getLastName())
                .specialization(dto.getSpecialization())
                .build();
        doctorRepository.save(doctor);

    }

    public void delete(Long doctorId) {
        doctorRepository.deleteById(doctorId);

    }

    @Scheduled (fixedDelay = 5000)
    public void checkIfDoctorIsAvaliable() {
        LOGGER.info("method checkIfDoctorIsAvaliable - invoked");
    }
}
