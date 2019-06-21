package clinic.com.example.clinic.infrastructure.dto;

import clinic.com.example.clinic.infrastructure.entity.VisitId;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VisitDto {

    private VisitId id;
    private Long doctorId;
    private String doctorFirstName;
    private String doctorLastName;
    private String specialization;
    private Long patientId;
    private String patientFirstName;
    private String patientLastName;
    private Integer patientAge;
    private Date visitDate;
}
