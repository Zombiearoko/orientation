package com.bocobi2.orientation.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class MailSender {

	@Autowired
	private JavaMailSender sender;
	
	@Autowired
	private Configuration freemarkerConfig;
	
	//methode pour l'envoe d'un simple mail
	
	 public void sendSimpleEmail(String recipient, String mailContent, String subject) throws Exception{
	        MimeMessage message = sender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message);
	        helper.setTo(recipient);
	        helper.setText(mailContent);
	        helper.setSubject(subject);
	        
	        sender.send(message);
	 }	
	 
	 //methode pour l'envoie d'un mail contenant des pieces jointes
	 
	 public void sendEmailWithAttachment(String recipient, String mailContent,
			 					  String subject, List<String> listOfAttachment) throws Exception{
        MimeMessage message = sender.createMimeMessage();
        
        // Enable the multipart flag!
        MimeMessageHelper helper = new MimeMessageHelper(message,true);
        
		helper.setTo(recipient);
        helper.setText(mailContent);
        helper.setSubject(subject);
        
        for (String attachment:listOfAttachment){
        ClassPathResource file = new ClassPathResource(attachment);
        helper.addAttachment(attachment, file);
        }
        sender.send(message);
    }
	 
	 

	    public void sendEmail() throws Exception {
	        MimeMessage message = sender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message);
	        Map<String, Object> model = new HashMap();
	        model.put("user", "qpt");
	        // set loading location to src/main/resources
	        // You may want to use a subfolder such as /templates here
	        freemarkerConfig.setClassForTemplateLoading(this.getClass(), "/");
	        Template t = freemarkerConfig.getTemplate("welcome.ftl");
	        String text = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
	        helper.setTo("set-your-recipient-email-here@gmail.com");
	        helper.setText(text, true);

			// set to html
	        helper.setSubject("Hi");
	        sender.send(message);
	    }
	 
	 
	
	
}
