import clinic.com.example.clinic.domain.DoctorService
import clinic.com.example.clinic.infrastructure.dto.DoctorDto
import clinic.com.example.clinic.infrastructure.entity.Doctor
import clinic.com.example.clinic.infrastructure.repository.DoctorRepository
import spock.lang.Specification
import spock.lang.Subject

class DoctorServiceSpec extends Specification {
    def repository = Mock(DoctorRepository)

    @Subject
    def sut = new DoctorService(repository)

    def 'should create doctor'() {
        given:
        def dto = DoctorDto.builder()
                .firstName("Adam")
                .lastName("Małysz")
                .specialization("okulista")
                .build()

        when:
        sut.createOrUpdate(dto)

        then:
        1 * repository.save(
                {
                    it.firstName == "Adam" &&
                    it.lastName == "Małysz"
                    it.specialization == "okulista"
                } as  Doctor

        )
    }

}
