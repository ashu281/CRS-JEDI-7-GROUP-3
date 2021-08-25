package com.flipkart.bean;

public class Notification {

    float refID;
    int paymentID;
    int studentID;
    String notificationMessage;

    public Notification(String s) {
        this.notificationMessage = s;
    }

    /**
     * Method to get reference ID
     *
     * @return reference ID
     */
    public float getRefID() {
        return refID;
    }

    /**
     * Method to set reference ID
     *
     * @param refID
     */
    public void setRefID(float refID) {
        this.refID = refID;
    }

    /**
     * Method to get payment ID
     *
     * @return payment ID
     */
    public int getPaymentID() {
        return paymentID;
    }

    /**
     * Method to set payment ID
     *
     * @param paymentID
     */
    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    /**
     * Method to get student ID
     *
     * @return student ID
     */
    public int getStudentID() {
        return studentID;
    }

    /**
     * Method to set student ID
     *
     * @param studentID
     */
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    /**
     * Method to get notification message
     *
     * @return notification message
     */
    public String getNotificationMessage() {
        return notificationMessage;
    }

    /**
     * Method to set notification message
     *
     * @param notificationMessage
     */
    public void setNotificationMessage(String notificationMessage) {
        this.notificationMessage = notificationMessage;
    }
}
