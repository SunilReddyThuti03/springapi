package com.springapi.springapi.dto;

public class StudentDto {
    private Long id;
    private String name;
    private String email;

    public StudentDto(Long id, String name, String email) {
        this.email = email;
        this.name = name;
        this.id = id;
    }

    public StudentDto(){

    }

    //getters
    public Long getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }

    //setters
    public void setId(Long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setEmail(String email){
        this.email = email;
    }

}
