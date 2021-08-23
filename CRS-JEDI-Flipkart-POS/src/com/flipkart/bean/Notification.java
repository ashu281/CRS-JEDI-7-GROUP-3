package com.flipkart.bean;

public class Notification {

    float refId;
    int paymentId;
    int studentId;
    String notificationMessage;

    public float getRefId() {
        return refId;
    }

    public void setRefId(float refId) {
        this.refId = refId;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getNotificationMessage() {
        return notificationMessage;
    }

    public void setNotificationMessage(String notificationMessage) {
        this.notificationMessage = notificationMessage;
    }
}
