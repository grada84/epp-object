package net.lacnic.web.registro.api.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("msg")
//@XStreamConverter(value = ToAttributedValueConverter.class, strings = { "content" })
public class Message {

	@XStreamAlias("lang")
	String lang;

	String content;

	public Message() {
	}
}
