package clinic.com.example.clinic.domain;

import clinic.com.example.clinic.infrastructure.dto.VisitDto;
import clinic.com.example.clinic.infrastructure.entity.Visit;
import clinic.com.example.clinic.infrastructure.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VisitFinder {

    private final VisitRepository visitRepository;

    public List<VisitDto> findByDoctorId(Long doctorId) {
        return visitRepository.findByDoctorId(doctorId)
                .stream()
                .map(Visit::toDto)
                .collect(Collectors.toList());

    }

    public List<VisitDto> findBySpecialization(String specialization) {
        return visitRepository.findBySpecialization(specialization)
                .stream()
                .map(Visit::toDto)
                .collect(Collectors.toList());

    }

    public List<VisitDto> findByDoctorIdAndSpecialization(Long doctorId, String specialization) {
        return visitRepository.findByDoctorIdAndSpecialization(doctorId, specialization)
                .stream()
                .map(Visit::toDto)
                .collect(Collectors.toList());

    }

    public List<VisitDto> findAll() {
        return visitRepository.findAll()
                .stream()
                .map(Visit::toDto)
                .collect(Collectors.toList());

    }
}
