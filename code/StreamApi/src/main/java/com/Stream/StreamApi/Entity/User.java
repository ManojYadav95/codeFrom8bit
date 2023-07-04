package com.Stream.StreamApi.Entity;

public class User 
{
	private String name;
	private String surname;
	private String city;
	private double avgGrade;
	private int age;
	
	@Override
	public String toString() {
		return "User [name=" + name + ", surname=" + surname + ", city=" + city + ", avgGrade=" + avgGrade + ", age="
				+ age + "]";
	}
	public User(String name, String surname, String city, double avgGrade, int age) {
		this.name = name;
		this.surname = surname;
		this.city = city;
		this.avgGrade = avgGrade;
		this.age = age;
	}
	public User() {}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double getAvgGrade() {
		return avgGrade;
	}
	public void setAvgGrade(double avgGrade) {
		this.avgGrade = avgGrade;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
