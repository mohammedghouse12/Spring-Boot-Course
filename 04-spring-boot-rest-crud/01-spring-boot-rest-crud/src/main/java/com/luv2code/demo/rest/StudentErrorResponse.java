package com.luv2code.demo.rest;

public class StudentErrorResponse {
    private int errorCode;
    private String errorMessage;
    private long timeStamp;

    public StudentErrorResponse() {
    }

    public StudentErrorResponse(int errorCode, String errorMessage, long timeStamp) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.timeStamp = timeStamp;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
