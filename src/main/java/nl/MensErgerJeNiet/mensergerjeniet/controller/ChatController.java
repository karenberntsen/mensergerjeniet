package nl.MensErgerJeNiet.mensergerjeniet.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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

/**
 * Created by rajeevkumarsingh on 24/07/17.
 */
@Controller
public class ChatController {
	private ArrayList<Bot> chatBots = new ArrayList<Bot>();

	public ChatController() {
		chatBots.add(new Bot() {
			@Override
			public ChatMessage reply(ChatMessage message) {

				ChatMessage chatMessage = new ChatMessage();
				chatMessage.setType(ChatMessage.MessageType.CHAT);
				chatMessage.setSender("bot");
				if (message.getContent().startsWith("!time"))
					return time(chatMessage);
				else if(message.getContent().startsWith("!random"))
					return random(message, chatMessage);
				return null;
			}

			private ChatMessage random(ChatMessage message, ChatMessage chatMessage) {
				chatMessage.setContent("Vul een max nummer in vb(!random 5)");
				try {
					int i = Integer.parseInt(message.getContent().split("!random")[1].trim());
					chatMessage.setContent("" + (int) (Math.random() * i));
				} catch (NumberFormatException e) {}
				return chatMessage;
			}

			private ChatMessage time(ChatMessage chatMessage) {
				chatMessage.setContent("Time is: " + LocalDateTime.now());
				return chatMessage;
			}
		});

		chatBots.add(new Bot() {
			@Override
			public ChatMessage reply(ChatMessage message) {
				if (message.getSender().equals("parrot"))
					return null;
				ChatMessage chatMessage = new ChatMessage();
				chatMessage.setType(ChatMessage.MessageType.CHAT);
				chatMessage.setSender("parrot");
				chatMessage.setContent(message.getContent());
				return chatMessage;
			}
		});
	}

	public void botReplys(ChatMessage message) {
		for (Bot b : chatBots) {
			ChatMessage reply = b.reply(message);
			if (reply != null) {
				new Thread(() -> {
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					messagingTemplate.convertAndSend("/channel/public", reply);
				}).start();;
				break;
			}
		}
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
