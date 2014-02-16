package org.json.jsend.parser;

/**
 * Class for Deserializing JSend JSON
 * Examples in Junit test package
 * @see http://labs.omniti.com/labs/jsend
 * @author David Bayo
 *
 */
public class JsendResponseWrapper<T> {
	private JsendStatusEnum status;
	private T data;
	private String message;
	private Integer code;
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public JsendStatusEnum getStatus() {
		return status;
	}
	
	public void setStatus(JsendStatusEnum status) {
		this.status = status;
	}
}
