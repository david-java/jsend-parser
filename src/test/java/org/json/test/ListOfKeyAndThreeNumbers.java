package org.json.test;

import java.util.List;

//Existe el @JsonRootName, pero falla al activar UNWRAP_ROOT_VALUE con más de un nodo raíz
public class ListOfKeyAndThreeNumbers {
	private List<ThreeNumbers> numbers;
	
	public List<ThreeNumbers> getNumbers() {
		return numbers;
	}
	public void setNumbers(List<ThreeNumbers> numbers) {
		this.numbers = numbers;
	}
}
