package com.example.servletjspdemo.domain;

public class Person {
	
	private String firstName = "unknown";
	private int yob = 1900;
	private String plec = "brak";
	private String hobby = "";
	private String opisSiebie = "mlody niski";
	private String wyksztalcenie = "brak";
	
	
	public Person() {
		super();
	}
	
	
	public Person(String firstName, int yob, String plec, String hobby,
			String opisSiebie, String wyksztalcenie) {
		super();
		this.firstName = firstName;
		this.yob = yob;
		this.plec = plec;
		this.hobby = hobby;
		this.opisSiebie = opisSiebie;
		this.wyksztalcenie = wyksztalcenie;
	}


	public String getPlec() {
		return plec;
	}


	public void setPlec(String plec) {
		this.plec = plec;
	}


	public String getHobby() {
		return hobby;
	}


	public void setHobby(String hobby) {
		this.hobby = hobby;
	}


	public String getOpisSiebie() {
		return opisSiebie;
	}


	public void setOpisSiebie(String opisSiebie) {
		this.opisSiebie = opisSiebie;
	}


	public String getWyksztalcenie() {
		return wyksztalcenie;
	}


	public void setWyksztalcenie(String wyksztalcenie) {
		this.wyksztalcenie = wyksztalcenie;
	}


	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public int getYob() {
		return yob;
	}
	public void setYob(int yob) {
		this.yob = yob;
	}
}
