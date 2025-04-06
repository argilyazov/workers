package alfa.argilyazov.workers.domain.dto.response;
import lombok.Value;

@Value
public class WorkerResponse {
    long id;
    String name;
    String email;
    String phone;
    String surname;
    String middleName;
    String birthDate;
    Integer lockerNumber;
    boolean active;
    int salary;
}
