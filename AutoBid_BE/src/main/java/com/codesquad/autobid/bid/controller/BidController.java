package com.codesquad.autobid.bid.controller;

import com.codesquad.autobid.bid.request.BidRegisterRequest;
import com.codesquad.autobid.bid.service.BidService;
import com.codesquad.autobid.user.domain.User;
import com.codesquad.autobid.web.argumentresolver.AuthorizedUser;
import com.codesquad.autobid.websocket.domain.AuctionDtoWebSocket;
import com.codesquad.autobid.websocket.domain.BidderDto;
import com.codesquad.autobid.websocket.service.WebSocketService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class BidController {
	private final SimpMessageSendingOperations messagingTemplate;
	private final BidService bidService;
	private final WebSocketService webSocketService;

	@Autowired
	public BidController(SimpMessageSendingOperations messagingTemplate,
						 BidService bidService,
						 WebSocketService webSocketService) {
		this.messagingTemplate = messagingTemplate;
		this.bidService = bidService;
		this.webSocketService = webSocketService;
	}

	@PostMapping("/auction/bid")
	public ResponseEntity<Boolean> bidRegister(@Parameter @RequestBody BidRegisterRequest bidRegisterRequest, @Parameter(hidden = true) @AuthorizedUser User user) {
//		 boolean result = bidService.suggestBid(bidRegisterRequest, user);
//
//		if (!result) {
//		 	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
//		 }

//		Long auctionId = bidRegisterRequest.getAuctionId();
//		AuctionDtoWebSocket auctionDtoWebSocket = webSocketService.parsingDto(auctionId);
//		log.info("getUserNum : {}",auctionDtoWebSocket.getUserNumber());
//		log.info("getPrice : {}",auctionDtoWebSocket.getPrice());
//		messagingTemplate.convertAndSend("/ws/start/" + auctionId, auctionDtoWebSocket);
		return ResponseEntity.status(HttpStatus.OK).body(true);
	}
}
