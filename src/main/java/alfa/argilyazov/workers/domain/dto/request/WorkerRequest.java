package alfa.argilyazov.workers.domain.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Value;
import org.springframework.data.annotation.CreatedDate;

@Value
public class WorkerRequest {
    @Size(min = 1, max = 12)
    @NotNull
    String name;
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$")
    String email;
    @Pattern(regexp = "^79\\d{9}$")
    @NotNull
    String phone;
    @Size(min = 1, max = 12)
    @NotNull
    String surname;
    @Size(min = 1, max = 12)
    String middleName;
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$")
    @NotNull
    String birthDate;
    Integer lockerNumber;
    boolean active;
    @NotNull
    int salary;
}
