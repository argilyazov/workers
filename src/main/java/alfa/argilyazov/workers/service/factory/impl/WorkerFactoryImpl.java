package alfa.argilyazov.workers.service.factory.impl;

import alfa.argilyazov.workers.domain.dto.request.WorkerRequest;
import alfa.argilyazov.workers.domain.dto.response.WorkerResponse;
import alfa.argilyazov.workers.domain.entity.Worker;
import alfa.argilyazov.workers.service.factory.WorkerFactory;
import org.springframework.stereotype.Component;

@Component
public class WorkerFactoryImpl implements WorkerFactory {
    @Override
    public Worker workerRequestToWorker(WorkerRequest workerRequest) {
        if (workerRequest == null) return null;
        Worker worker = new Worker();
        worker.setActive(workerRequest.isActive());
        worker.setName(workerRequest.getName());
        worker.setEmail(workerRequest.getEmail());
        worker.setPhone(workerRequest.getPhone());
        worker.setLockerNumber(workerRequest.getLockerNumber());
        worker.setBirthdate(workerRequest.getBirthDate());
        worker.setSalary(workerRequest.getSalary());
        worker.setSurname(workerRequest.getSurname());
        worker.setMiddleName(workerRequest.getMiddleName());
        return worker;
    }

    @Override
    public WorkerResponse workerToWorkerResponse(Worker worker) {
        if (worker == null) return null;
        return new WorkerResponse(
                worker.getId(),
                worker.getName(),
                worker.getEmail(),
                worker.getPhone(),
                worker.getSurname(),
                worker.getMiddleName(),
                worker.getBirthdate(),
                worker.getLockerNumber(),
                worker.isActive(),
                worker.getSalary());
    }
}
