package clinic.com.example.clinic.infrastructure.entity;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
//
//@NoArgsConstructor
//@AllArgsConstructor
//@Setter
//@Embeddable
public class VisitId implements Serializable {

//    @Column(name = "doctor_id")
//    private Long doctorId;
//
//    @Column(name = "patient_id")
//    private Long patientId;
//
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//
//        if (o == null || getClass() != o.getClass())
//            return false;
//
//        VisitId that = (VisitId) o;
//        return Objects.equals(doctorId, that.doctorId) &&
//                Objects.equals(patientId, that.patientId);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(doctorId, patientId);
//    }
}