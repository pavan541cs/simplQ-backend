package com.example.restservice.controller.model.token;

import com.example.restservice.constants.TokenStatus;
import java.util.Date;
import lombok.Data;

@Data
public class TokenDetailResponse {

  final String tokenId;
  final Integer tokenNumber;
  final TokenStatus tokenStatus;
  final String queueName;
  final String queueId;
  final Long aheadCount;
  final Boolean notifiable;
  final Date tokenCreationTimestamp;
}
