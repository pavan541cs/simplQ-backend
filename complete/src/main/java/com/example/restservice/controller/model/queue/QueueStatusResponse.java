package com.example.restservice.controller.model.queue;

import com.example.restservice.constants.QueueStatus;
import lombok.Data;

@Data
public class QueueStatusResponse {

  final String queueId;
  final String queueName;
  final QueueStatus status;

  final Long numberOfActiveTokens;
  final Long totalNumberOfTokens;
}
