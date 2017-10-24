package nl.MensErgerJeNiet.mensergerjeniet.mail;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;

import javax.mail.internet.InternetAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import it.ozimov.springboot.mail.model.Email;
import it.ozimov.springboot.mail.model.defaultimpl.DefaultEmail;
import it.ozimov.springboot.mail.service.EmailService;

@Service
public class EmailServiceImpl {
	@Value("${server.path}")
	private String serverPath;
	
	@Autowired
	public EmailService emailService;
 
	private Collection<InternetAddress> newArrayList(InternetAddress internetAddress) {
		ArrayList<InternetAddress> list = new ArrayList<>();
		list.add(internetAddress);
		return list;
	}

	public void sendSimpleMessage(String emailaddress, String username, String secret) throws UnsupportedEncodingException {
    	System.out.println(serverPath);
		final Email email = DefaultEmail.builder()
                .from(new InternetAddress("mejnonline@gmail.com",  "Auto mejn activationcode sender"))
                .to(newArrayList(
                        new InternetAddress(emailaddress, username)))
                .subject("Activation url mejn-account")
                .body(serverPath+"/user/"+username+"/"+secret)
                .encoding("UTF-8").build();
   	 emailService.send(email);
	}

}