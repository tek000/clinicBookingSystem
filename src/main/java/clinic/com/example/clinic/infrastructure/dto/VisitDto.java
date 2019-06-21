package clinic.com.example.clinic.infrastructure.dto;

import clinic.com.example.clinic.infrastructure.entity.VisitId;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VisitDto {

    private Long id;
    private Long doctorId;
    private String doctorFirstName;
    private String doctorLastName;
    private String specialization;
    private Long patientId;
    private String patientFirstName;
    private String patientLastName;
    private Integer patientAge;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date visitDate;
}
