package alfa.argilyazov.workers.web.controller.impl;

import alfa.argilyazov.workers.domain.dto.request.WorkerRequest;
import alfa.argilyazov.workers.domain.dto.response.WorkerResponse;
import alfa.argilyazov.workers.service.WorkerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
//a
@RestController
@RequestMapping("workers")
@RequiredArgsConstructor
public class WorkerController {

    @Autowired
    WorkerService workerService;


    @DeleteMapping("{id}")
    public ResponseEntity deleteEntity(@PathVariable long id) {
        workerService.deleteWorker(id);
        return ResponseEntity.ok().build();
    }


    @PutMapping("{id}")
    public WorkerResponse updateEntity(@Valid @RequestBody WorkerRequest worker, @PathVariable long id) {
        return workerService.updateWorker(worker,id);
    }


    @PostMapping
    public WorkerResponse addEntity(@Valid @RequestBody WorkerRequest worker) {
        return workerService.createWorker(worker);
    }


    @GetMapping
    public List<WorkerResponse> getEntities(@RequestParam(required=false) Optional<Integer> limit, @RequestParam(required=false) Optional<Integer> pageNumber, @RequestParam(required=false) boolean isActive) {
        int limitPage = limit.orElse(10);
        int pageNumberPage = pageNumber.orElse(0);
        return workerService.getWorkers(limitPage,pageNumberPage,isActive);
    }


    @GetMapping("{id}")
    public WorkerResponse getEntity(@PathVariable long id) {
        return workerService.getWorker(id);
    }
}
