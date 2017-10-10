package nl.MensErgerJeNiet.mensergerjeniet.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.messaging.MessageSecurityMetadataSourceRegistry;
import org.springframework.security.config.annotation.web.socket.AbstractSecurityWebSocketMessageBrokerConfigurer;

@Configuration
public class WebSocketSecurityConfig
      extends AbstractSecurityWebSocketMessageBrokerConfigurer { 

    protected void configureInbound(MessageSecurityMetadataSourceRegistry messages) {
    	messages.anyMessage().authenticated();
    }
    
    @Override
	protected boolean sameOriginDisabled() {
		//disable CSRF for websockets for now...
		return true;
	}
}