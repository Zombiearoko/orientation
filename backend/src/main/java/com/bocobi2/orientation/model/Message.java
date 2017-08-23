package com.bocobi2.orientation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "message")
public class Message {

	@Id
	private String idMessage;
	private String messageAuthor;
	private String messageContent;
	private String sendingMessageDate;
	
	public Message(){}
	
	public Message(String messageAuthor, String messageContent, String sendingMessageDate) {
		super();
		this.messageAuthor = messageAuthor;
		this.messageContent = messageContent;
		this.sendingMessageDate = sendingMessageDate;
	}

	public String getMessageAuthor() {
		return messageAuthor;
	}

	public void setMessageAuthor(String messageAuthor) {
		this.messageAuthor = messageAuthor;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public String getSendingMessageDate() {
		return sendingMessageDate;
	}

	public void setSendingMessageDate(String sendingMessageDate) {
		this.sendingMessageDate = sendingMessageDate;
	}
	
	
	public String toString(){
		 return String.format(
	                "{\"idMessage\":%s, \"messageAuthor\":'%s', \"messageContent\":'%s', \"sendingMessageDate\":'%s'}",
	                idMessage, messageAuthor, messageContent,sendingMessageDate);
	}
}
