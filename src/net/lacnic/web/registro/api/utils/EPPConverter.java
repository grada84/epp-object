package net.lacnic.web.registro.api.utils;

import java.io.FileNotFoundException;

import net.lacnic.web.registro.api.response.ContactCreData;
import net.lacnic.web.registro.api.response.Extension;
import net.lacnic.web.registro.api.response.Frame;
import net.lacnic.web.registro.api.response.Message;
import net.lacnic.web.registro.api.response.OrgCreData;
import net.lacnic.web.registro.api.response.ResData;
import net.lacnic.web.registro.api.response.Response;
import net.lacnic.web.registro.api.response.ResponseObject;
import net.lacnic.web.registro.api.response.Result;
import net.lacnic.web.registro.api.response.TrId;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EPPConverter {
	
	public static ResponseObject convertResponseObject(Frame frame, ResData resData, Extension extension) throws FileNotFoundException
	{
		XStream xStream = new XStream(new DomDriver());
		xStream.processAnnotations(ResponseObject.class);
		xStream.processAnnotations(ResData.class);
		xStream.processAnnotations(Extension.class);
//		xStream.processAnnotations(OrgCreExtension.class);
//		xStream.processAnnotations(OrgResData.class);
		xStream.processAnnotations(OrgCreData.class);
		xStream.processAnnotations(ContactCreData.class);
		xStream.processAnnotations(Result.class);
		xStream.processAnnotations(Response.class);
		xStream.processAnnotations(Message.class);
		xStream.processAnnotations(TrId.class);

		ResponseObject eppBase = new ResponseObject(resData, extension);
		
		final String xml = frame.getFrame();
		xStream.fromXML(xml, eppBase);

		return eppBase;
	}
}