package alfa.argilyazov.workers.service.factory;

import alfa.argilyazov.workers.domain.dto.request.WorkerRequest;
import alfa.argilyazov.workers.domain.dto.response.WorkerResponse;
import alfa.argilyazov.workers.domain.entity.Worker;

public interface WorkerFactory {
    public Worker workerRequestToWorker(WorkerRequest entity);
    public WorkerResponse workerToWorkerResponse(Worker worker);
}
