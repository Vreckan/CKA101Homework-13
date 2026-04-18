package hw7;

import java.io.Serializable;

public class Animal implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	public Animal(String name) {
		this.setName(name);
	}

	public Animal() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void sleep() {
		System.out.println("Animal sleep");
	}
}
