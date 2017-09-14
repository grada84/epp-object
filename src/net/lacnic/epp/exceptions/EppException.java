package net.lacnic.epp.exceptions;

import net.lacnic.web.registro.api.response.Frame;

public class EppException extends Exception {

	private static final long serialVersionUID = 1L;

	public EppException(String e) {
		super(e);
	}
	
	public static EppException eppException(Frame frame) {
		String s = frame.getFrame();
		String[] spliteados = s.split("<reason>");
		String exceptionTexto = "";
		for (int i = 1; i < spliteados.length; i++)
			exceptionTexto += spliteados[i].split("</reason>")[0] + "\n";
		System.err.println(exceptionTexto);
		return new EppException(s);
	}
}
