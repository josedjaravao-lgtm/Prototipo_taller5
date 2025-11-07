package com.example.taller5.Modelo;

public class Persona {
    private String name;
    private String id;
    private Integer age;
    private String mail;
    private String phone;


    public Persona(String name, Integer age, String id, String mail, String phone) {
        this.name = name;
        this.id= id;
        this.age = age;
        this.mail =mail;
        this.phone = phone;

    }

    public String getName() { return name; }

    public void setName() { this.name=name;}

    public String getId() { return id; }

    public void setId() { this.id=id; }

    public int getAge() { return age; }

    public void setAge() { this.age=age; }

    public String getMail() { return mail; }

    public void setMail() { this.mail=mail; }

    public String getPhone() { return phone; }

    public void setPhone() { this.phone=phone; }

    @Override
    public String toString() {
        return "Nombre='" + name + '\'' +  ", Id='" + id + '\'' +
                ", Edad='" + age + '\'' + ", Correo='" + mail + '\'' +
                ", Telefono='" + phone + '\'' ;

    }

}

