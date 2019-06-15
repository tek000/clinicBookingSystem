package clinic.com.example.clinic.domain;


import clinic.com.example.clinic.infrastructure.dto.DoctorDto;
import clinic.com.example.clinic.infrastructure.entity.Doctor;
import clinic.com.example.clinic.infrastructure.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoctorFinder {
    private final DoctorRepository doctorRepository;

    public List<DoctorDto> findBySpecialization(String specialization) {
        return doctorRepository.findBySpecialization(specialization).stream()
                .map(Doctor::toDo)
                .collect(Collectors.toList());
    }

}
