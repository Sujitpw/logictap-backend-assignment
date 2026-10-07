package com.sujit.web_service_assignment;


public class CallRecord {

    private String call_id;
    private String status;
    private int duration_secs;

    public CallRecord() {
    }

    public CallRecord(String call_id, String status, int duration_secs) {
        this.call_id = call_id;
        this.status = status;
        this.duration_secs = duration_secs;
    }

    public String getCall_id() {
        return call_id;
    }

    public void setCall_id(String call_id) {
        this.call_id = call_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getDuration_secs() {
        return duration_secs;
    }

    public void setDuration_secs(int duration_secs) {
        this.duration_secs = duration_secs;
    }
}