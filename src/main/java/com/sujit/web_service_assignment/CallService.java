package com.sujit.web_service_assignment;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CallService {

    private final Map<String, CallRecord> calls = new ConcurrentHashMap<>();

    public void saveCall(CallRecord call) {
        calls.putIfAbsent(call.getCall_id(), call);
    }

    public CallRecord getCall(String callId) {
        return calls.get(callId);
    }
}