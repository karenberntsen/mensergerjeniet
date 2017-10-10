package nl.MensErgerJeNiet.mensergerjeniet.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import nl.MensErgerJeNiet.mensergerjeniet.config.security.CustomUserDetails;
import nl.MensErgerJeNiet.mensergerjeniet.game.model.MensErgerJeNiet;

/**
 * Created by rajeevkumarsingh on 24/07/17.
 */
@Controller
public class ChatController {

	private MensErgerJeNiet mejn = new MensErgerJeNiet();

	public void botReplys(ChatMessage message) {
		if (!message.getType().equals(ChatMessage.MessageType.GAME))
			return;

		if (SecurityContextHolder.getContext().getAuthentication().getName()
				.equals(mejn.getCurrentPlayer().getName())) {
			if (message.getContent().equals("throw")) {
				int dice = mejn.throwDice();
				int[] options = mejn.getPlayOptions();
				message.setContent(getContentString(dice,options));
				
			} else if (message.getContent().startsWith("pion")) {
				mejn.doOption(Integer.parseInt(message.getContent().split("pion")[1].trim()));
			} else if (message.getContent().equals("start")) {
				mejn.startGame();
			}
		}
	}

	private String getContentString(int dice, int[] options) {
		StringBuilder builder = new StringBuilder();
		builder.append("{ \"dice\":").append(dice).append(" , \"options\": [");
		for(int i = 0; i < options.length; ++i) {
			builder.append(options[i]);
			if(i < options.length-1) {
				builder.append(",");
			}
		}
		builder.append("]}");
		return builder.toString();
	}

	private String getOptionsString(int[] options) {
		
		return null;
	}

	@MessageMapping("/chat.sendMessage")
	@SendTo("/channel/public")
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
		botReplys(chatMessage);
		return chatMessage;
	}

	@MessageMapping("/chat.addUser")
	@SendTo("/channel/public")
	public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
		chatMessage.setSender(SecurityContextHolder.getContext().getAuthentication().getName());
		mejn.addUser(chatMessage.getSender());
		return chatMessage;
	}

	@RequestMapping("/chat")
	public String chatPage(ModelMap model) {
		CustomUserDetails details = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		model.addAttribute("username", details.getUsername());
		return "chat";
	}

	@RequestMapping("/chattest")
	public String testChatPage(ModelMap model) {
		model.addAttribute("username", "TEST ACCOUNT");
		return "chat";
	}

	public static HttpSession session() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		return attr.getRequest().getSession(true); // true == allow create
	}

	@Autowired
	private SimpMessageSendingOperations messagingTemplate;

}
