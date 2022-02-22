package com.asiana.lawgic.lawgic.vo;

import com.asiana.lawgic.lawgic.entity.CarType;

import java.sql.Date;

public class ClientVO
{
    private Long clientId;
    private String address;
    private Date birthday;
    private CarType carType;
    private String email;
    private int gender;
    private String name;
    private String password;
    private String phone;


    public ClientVO(Long clientId, String address, Date birthday, CarType carType, String email, int gender,
                    String name, String password, String phone) {
        super();
        this.clientId = clientId;
        this.address = address;
        this.birthday = birthday;
        this.carType = carType;
        this.email = email;
        this.gender = gender;
        this.name = name;
        this.password = password;
        this.phone = phone;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "ClientVO [clientId=" + clientId + ", address=" + address + ", birthday=" + birthday + ", carType="
                + carType + ", email=" + email + ", gender=" + gender + ", name=" + name + ", password=" + password
                + ", phone=" + phone + "]";
    }




}
