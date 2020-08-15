package com.example.restservice.controller;

import com.example.restservice.controller.model.queue.*;
import com.example.restservice.service.QueueService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class QueueController {

  private final QueueService queueService;

  @PostMapping(path = "/queue")
  public ResponseEntity<CreateQueueResponse> createQueue(
      @Valid @RequestBody CreateQueueRequest createQueueRequest) {
    return ResponseEntity.ok(queueService.createQueue(createQueueRequest));
  }

  @GetMapping(path = "/queues")
  public ResponseEntity<MyQueuesResponse> getMyQueues() {
    return ResponseEntity.ok(queueService.getMyQueues());
  }

  @GetMapping(path = "/queue/{queueId}")
  public ResponseEntity<QueueDetailsResponse> getQueueDetails(
      @PathVariable("queueId") String queueId) {
    return ResponseEntity.ok(queueService.getQueueDetails(queueId));
  }

  @PostMapping(path = "/queue/{queueId}")
  public ResponseEntity<UpdateQueueStatusResponse> pauseQueueRequest(
          @Valid @RequestBody PauseQueueRequest pauseQueueRequest,
          @PathVariable("queueId") String queueId) {
    return ResponseEntity.ok(queueService.pauseQueue(pauseQueueRequest, queueId));
  }

  @DeleteMapping(path = "/queue/{queueId}")
  public ResponseEntity<UpdateQueueStatusResponse> deleteQueueRequest(
          @PathVariable("queueId") String queueId) {
    return ResponseEntity.ok(queueService.deleteQueue(queueId));
  }

  @GetMapping(path = "/queue/status")
  public ResponseEntity<QueueStatusResponse> getQueueStatus(
      @RequestParam(required = false) String queueId,
      @RequestParam(required = false) String queueName) {
    if (queueId != null) {
      return ResponseEntity.ok(queueService.getQueueStatus(queueId));
    } else if (queueName != null) {
      return ResponseEntity.ok(queueService.getQueueStatusByName(queueName));
    } else {
      return new ResponseEntity(HttpStatus.BAD_REQUEST); // Todo Give reason
    }
  }
}
