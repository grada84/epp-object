package net.lacnic.web.registro.api.response;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("epp")
public class ResponseObject {

	private Response response;
	
	public ResponseObject(){
		this.response = new Response();
	}

	@Override
	public String toString() {
		return "ResponseObject [response=" + response + "]";
	}

	public ResponseObject(ResData resData, Extension extension) {
		this.setResponse(new Response(resData, extension));
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}
	
	public ResponseObject merge(ResponseObject other) {
		/*
		 *  TODO faltan fusionar
		 *  ResData resData;
		 *  Extension extension;
		 *  TrId trID;
		 */
		final List<Result> otherResult = other.getResponse().getResult();
		if(otherResult == null)
			return this;
		
		this.getResponse().getResult().addAll(otherResult);
		return this;
	}
}
