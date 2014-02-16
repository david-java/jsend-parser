package org.json.test;

//Existe el @JsonRootName, pero falla al activar UNWRAP_ROOT_VALUE con más de un nodo raíz
public class KeyAndThreeNumbers {
	private ThreeNumbers numbers;
	
	public ThreeNumbers getNumbers() {
		return numbers;
	}
	public void setNumbers(ThreeNumbers numbers) {
		this.numbers = numbers;
	}
}
