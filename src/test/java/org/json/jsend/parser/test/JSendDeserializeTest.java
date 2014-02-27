package org.json.jsend.parser.test;

import java.io.IOException;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.json.jsend.parser.JsendResponseWrapper;

public class JSendDeserializeTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	private ObjectMapper objectMapper = new ObjectMapper();
	
	public JSendDeserializeTest(String testName) {
		super(testName);
	}
	
	public static Test suite() {
		return new TestSuite(JSendDeserializeTest.class);
	}
	
	private static void printJsonStruct(JsendResponseWrapper<?> struct) {
		System.out.println("-------------");
		System.out.println(struct.getStatus());
		System.out.println(struct.getData());
		System.out.println(struct.getMessage());
		System.out.println(struct.getCode());
		System.out.print("data type:");
		System.out.println(struct.getData().getClass().getName());
		System.out.println("-------------");
	}
	
	public void testDataAsString() throws JsonParseException, JsonMappingException, IOException {
		System.out.println("---- Start testDataAsString----");
		String test = "{\"status\":\"success\",\"data\":\"dat2\",\"message\":\"mess\",\"code\":33}";
		//No va en UNWRAP si hay mas de un key en el nivel
		//objectMapper.configure(Feature.UNWRAP_ROOT_VALUE, true);
		System.out.println(test);
		JsendResponseWrapper<String> simpleStruct = objectMapper.readValue(test, JsendResponseWrapper.class);
		printJsonStruct(simpleStruct);
		System.out.println("data > " + simpleStruct.getData());
		System.out.println("---- End testDataAsString----");
		assertTrue(simpleStruct.getData().getClass().equals(String.class));
	}
	
	public void testDataAsSimplePojo() throws JsonParseException, JsonMappingException, IOException {
		System.out.println("---- Start testDataAsSimplePojo----");
		String test = "{\"status\":\"success\",\"data\":{\"numbers\":{\"two\":2,\"one\":1,\"three\":3}}}";
		//No va en UNWRAP si hay mas de un key en el nivel
		//objectMapper.configure(Feature.UNWRAP_ROOT_VALUE, true);
		System.out.println(test);
		//JsonStructThreeNumbers pojoStruct = objectMapper.readValue(test, JsonStructThreeNumbers.class);
		JsendResponseWrapper<KeyAndThreeNumbers> pojoStruct = objectMapper.readValue(test, new TypeReference<JsendResponseWrapper<KeyAndThreeNumbers>>(){});
		printJsonStruct(pojoStruct);
		System.out.println(pojoStruct.getData().getNumbers());
		System.out.println("---- End testDataAsSimplePojo----");
		assertTrue(pojoStruct.getData().getClass().equals(KeyAndThreeNumbers.class));
	}	
	
	public void testDataAsListOfPojo() throws JsonParseException, JsonMappingException, IOException {
		System.out.println("---- Start testDataAsListOfPojo----");
		String test = "{\"status\":\"success\",\"data\":{\"numbers\":[{\"two\":\"2\",\"one\":\"1\",\"three\":\"3\"},{\"two\":\"2\",\"one\":\"1\",\"three\":\"3\"}]}}";
		//No va en UNWRAP si hay mas de un key en el nivel
		//objectMapper.configure(Feature.UNWRAP_ROOT_VALUE, true);
		System.out.println(test);
		//JsonStructListOfThreeNumbers listOfPojo = objectMapper.readValue(test, JsonStructListOfThreeNumbers.class);
		JsendResponseWrapper<ListOfKeyAndThreeNumbers> listOfPojo = objectMapper.readValue(test, new TypeReference<JsendResponseWrapper<ListOfKeyAndThreeNumbers>>(){});
		printJsonStruct(listOfPojo);
		List<ThreeNumbers> listOfThreeNumbers = listOfPojo.getData().getNumbers();
		for (ThreeNumbers threeNumbers : listOfThreeNumbers) {
			System.out.println(threeNumbers);
		}
		System.out.println("---- End testDataAsListOfPojo----");
		assertTrue(listOfPojo.getData().getNumbers().get(0).getClass().equals(ThreeNumbers.class));
	}
}
