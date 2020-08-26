package com.example.trevt.navigationbar.API_LOGIN;

import java.util.List;

public class WisatawanListt {
        Integer status;
        boolean error;
        String message;
        Wisatawann wisatawan;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Wisatawann getWisatawan() {
        return wisatawan;
    }

    public void setWisatawan(Wisatawann wisatawan) {
        this.wisatawan = wisatawan;
    }
}
