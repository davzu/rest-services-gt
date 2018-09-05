package pe.edu.galaxy.training.rest.bean;

import java.util.Arrays;

public class RestResponse {

	private String[] messages;
	
	private Country[] result;

	public RestResponse() {
		super();
	}

	public String[] getMessages() {
		return messages;
	}

	public void setMessages(String[] messages) {
		this.messages = messages;
	}

	public Country[] getResult() {
		return result;
	}

	public void setResult(Country[] result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "RestResponse [messages=" + Arrays.toString(messages)
				+ ", result=" + Arrays.toString(result) + "]";
	}

}
