package alfa.argilyazov.workers.repository;

import alfa.argilyazov.workers.domain.entity.Worker;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {
    Optional<Worker> findByPhoneAndEmail(String phone, String email);

    @Query("SELECT e from Worker e where e.active=:isActive")
    List<Worker> getAllByIsActiveWithOffsetPagination( boolean isActive, Pageable pageable);

}
