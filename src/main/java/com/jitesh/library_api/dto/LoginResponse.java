package com.jitesh.library_api.dto;

public class LoginResponse {

    private String token;
    private String username;
    private String role;

    public LoginResponse() {
    }

    public LoginResponse(String token, String username, String role) {
        this.token = token;
        this.username = username;
        this.role = role;
    }

    public String getToken(){
        return token;
    }
    public String getUserName(){
        return username;
    }
    public String getRole(){
        return role;
    }

    public void setToken(String token){
        this.token=token;
    }

    public void setUserName(String username){
        this.username=username;
    }

    public void setRole(String role){
        this.role=role;
    }
}