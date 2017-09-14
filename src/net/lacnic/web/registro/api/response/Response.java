package net.lacnic.web.registro.api.response;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("response")
public class Response {

	@XStreamAlias("result")
	List<Result> result;

	@XStreamAlias("resData")
	ResData resData;

	@XStreamAlias("extension")
	Extension extension;

	@XStreamAlias("trID")
	TrId trID;

	public Response() {
		this.result = new ArrayList<Result>();
	}

	@Override
	public String toString() {
		return "Response [result=" + result + ", resData=" + resData + ", extension=" + extension + ", trID=" + trID + "]";
	}

	public Response(ResData resData, Extension extension) {
		this.resData = resData;
		this.extension = extension;
	}

	public List<Result> getResult() {
		return result;
	}

	public ResData getResData() {
		return resData;

	}

	public Extension getExtension() {
		return extension;
	}

	public void setExtension(Extension extension) {
		this.extension = extension;
	}
}
