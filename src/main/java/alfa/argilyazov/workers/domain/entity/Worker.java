package alfa.argilyazov.workers.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="workers", uniqueConstraints = {@UniqueConstraint(columnNames = {"phone","email"})})
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;
    String email;
    String phone;
    String surname;
    @Column(name = "middle_name",nullable = true)
    String middleName;
    String birthdate;
    @Column(name = "locker_naumber",nullable = true)
    Integer lockerNumber;
    boolean active;
    int salary;
}
