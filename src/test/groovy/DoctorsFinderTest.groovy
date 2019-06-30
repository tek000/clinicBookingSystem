import clinic.com.example.clinic.domain.DoctorFinder
import clinic.com.example.clinic.infrastructure.repository.DoctorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification
import spock.lang.Subject

@SpringBootTest
class DoctorsFinderTest extends Specification{

    @Autowired
    private DoctorRepository doctorRepository;

    @Subject
    @Autowired
    private DoctorFinder doctorFinder

def 'should finfd doctors by specialization'(){
//    given:
//    def doc1 =
//
//    when:
//
//    then:


}

}
