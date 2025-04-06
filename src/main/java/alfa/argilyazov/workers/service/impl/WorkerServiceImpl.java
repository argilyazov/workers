package alfa.argilyazov.workers.service.impl;

import alfa.argilyazov.workers.domain.dto.request.WorkerRequest;
import alfa.argilyazov.workers.domain.dto.response.WorkerResponse;
import alfa.argilyazov.workers.domain.entity.Worker;
import alfa.argilyazov.workers.repository.WorkerRepository;
import alfa.argilyazov.workers.service.WorkerService;
import alfa.argilyazov.workers.service.factory.WorkerFactory;
import jakarta.persistence.EntityNotFoundException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.AbstractPageRequest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor()
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class WorkerServiceImpl implements WorkerService {

    WorkerFactory workerFactory;
    WorkerRepository workerRepository;

    @Override
    public WorkerResponse getWorker(long id) {
        Worker worker = workerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Ресурс не найден"));
        return workerFactory.workerToWorkerResponse(worker);
    }

    @Override
    public List<WorkerResponse> getWorkers(int limit, int pageNumber, boolean isActive) {
        Pageable page = PageRequest.of(pageNumber,limit,Sort.by("id").descending());
        return workerRepository.getAllByIsActiveWithOffsetPagination(isActive, page).stream().map(workerFactory::workerToWorkerResponse).collect(Collectors.toList());
    }

    @Override
    public WorkerResponse createWorker(WorkerRequest workerRequest) {
        if (workerRepository.findByPhoneAndEmail(workerRequest.getPhone(), workerRequest.getEmail()).isPresent()) throw new DataIntegrityViolationException("Сотрудник с такими email и phone существует");
        return workerFactory.workerToWorkerResponse(workerRepository.save(workerFactory.workerRequestToWorker(workerRequest)));
    }

    @Override
    public WorkerResponse updateWorker(WorkerRequest workerRequest, long id) {
        workerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Ресурс не найден"));
        workerRepository.findByPhoneAndEmail(
                workerRequest.getPhone(), workerRequest.getEmail()).orElseThrow(
                        () -> new DataIntegrityViolationException("Сотрудник с такими email и phone существует"));
        Worker worker = workerFactory.workerRequestToWorker(workerRequest);
        worker.setId(id);
        return workerFactory.workerToWorkerResponse(workerRepository.save(worker));
    }

    @Override
    public void deleteWorker(long id) {
        workerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Ресурс не найден"));
        workerRepository.deleteById(id);
    }
}
