package alfa.argilyazov.workers.service;


import alfa.argilyazov.workers.domain.dto.request.WorkerRequest;
import alfa.argilyazov.workers.domain.dto.response.WorkerResponse;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.util.List;

public interface WorkerService {
    WorkerResponse getWorker(long id);
    WorkerResponse createWorker(WorkerRequest worker);
    WorkerResponse updateWorker(WorkerRequest worker,long id);
    void deleteWorker(long id);

    List<WorkerResponse> getWorkers(int limit, int offset, boolean isActive);
}
