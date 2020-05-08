package com.revature.beans;

public class User {
    //fields
    private int userId;
    private String userName;
    private String password;
    private boolean isEmployee;

    //Constructors
    public User() {
        super();
    }

    public User(int userId, String userName, String password, boolean isEmployee) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.isEmployee = isEmployee;
    }

    //Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEmployee() {
        return isEmployee;
    }

    public void setEmployee(boolean employee) {
        isEmployee = employee;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", isEmployee=" + isEmployee +
                '}';
    }
}