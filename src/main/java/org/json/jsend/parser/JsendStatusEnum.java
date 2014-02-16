package org.json.jsend.parser;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

/**
 * Enum for JSend Status representation Examples in Junit test package
 * 
 * @see http://labs.omniti.com/labs/jsend
 * @author David Bayo
 * 
 */
public enum JsendStatusEnum {

	SUCCESS("success"), FAIL("fail"), ERROR("error");
	private final String status;

	private static final Map<String, JsendStatusEnum> map = new HashMap<String, JsendStatusEnum>();

	static {
		for (JsendStatusEnum item : JsendStatusEnum.values()) {
			map.put(item.status, item);
		}
	}

	private JsendStatusEnum(final String status) {
		this.status = status;
	}

	public String getStatus() {
		return this.status;
	}

	@JsonValue
	@Override
	public String toString() {
		return this.status.toLowerCase();
	}

	@JsonCreator
	public static JsendStatusEnum forValue(String value) {
		if (map.containsKey(value)) {
			return map.get(value);
		}
		throw new NoSuchElementException(value + " not found");
	}

}