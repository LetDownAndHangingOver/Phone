package com.benali;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

public class WebSocketChatEventListener {
	
	@Autowired
	private SimpMessageSendingOperations simpMessageSendingOperations;
	
	@EventListener
	public void handleWebSocketConnectListener(SessionConnectedEvent e) {
		System.out.println("New connection socket");
	}
	
	@EventListener
	public void hqndleWebSocketDisconnectListener(SessionDisconnectEvent e) {
		StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(e.getMessage());
		
		String userName = (String) headerAccessor.getSessionAttributes().get("username");
		
		if(userName != null) {
			WebSocketChatMessage chatMessage = new WebSocketChatMessage();
			
			chatMessage.setSender(userName);
			chatMessage.setType("Leave");
			
			simpMessageSendingOperations.convertAndSend("/topic/public", chatMessage);
			
		}
	}

}
