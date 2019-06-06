package com.t1708m1.entity;

public class User {
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
    public User() {
        this.username = "";
        this.password = "";
        this.phone = "";
        this.email = "";
        this.address = "";
    }



    private String username;
    private String password;
    private String phone;
    private String email;
    private String address;

    //CODE STATUS
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        if (status == null) {
            status = Status.DEACTIVE;
        }
        this.status = status.getValue();
    }
    public enum Status {
        ACTIVE(1), DEACTIVE(0), DELETED(-1);
        int value;

        Status(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static Status findByValue(int value) {
            for (Status status :
                    Status.values()) {
                if (status.getValue() == value) {
                    return status;
                }
            }
            return null;
        }

    }



}
