package com.example.demo.dto;
 

public class OutputResponseDto {
    private boolean status;
    private Object data;
    private String message;
    private String statusCode;

    // Default Constructor
    public OutputResponseDto() {}

    // Parameterized Constructor
    public OutputResponseDto(boolean status, Object data, String message, String statusCode) {
        this.status = status;
        this.data = data;
        this.message = message;
        this.statusCode = statusCode;
    }

    // Getters and Setters
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    // toString Method
    @Override
    public String toString() {
        return "OutputResponseDto{" +
                "status=" + status +
                ", data=" + data +
                ", message='" + message + '\'' +
                ", statusCode='" + statusCode + '\'' +
                '}';
    }
}
