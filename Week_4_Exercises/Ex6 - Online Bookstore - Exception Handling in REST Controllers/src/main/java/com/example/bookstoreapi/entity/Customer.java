package com.example.bookstoreapi.entity;

public class Customer {
    private Long id;
    private String name;
    private String email;
    
    public Customer() {}

    public Customer(Long id, String name, String email) {
        setId(id);
        setName(name);
        setEmail(email);
    }    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

    
}
