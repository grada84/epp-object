package net.lacnic.web.registro.api.response;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("result")
public class Result {
	@XStreamAsAttribute
	String code; // attribute
	
	@XStreamAlias("msg")
	Message msg;
	
	@Override
	public String toString() {
		return "Result [code=" + code + ", msg=" + msg + ", values=" + values + ", extValues=" + extValues + ", resData=" + resData + "]";
	}

	@XStreamAlias("value")
	public List<Value> values;
	@XStreamAlias("extValue")
	List<ExtValue> extValues;
	
	@XStreamAlias("resData")
	ResData resData;
	
	
//	EPPExtension extension;
	
	public Result() {
	}
	
	public void addValue(Value value) {
		values.add(value);
}
	
	public void addExtValue(ExtValue extValue) {
		extValues.add(extValue);
}

	
	

}
