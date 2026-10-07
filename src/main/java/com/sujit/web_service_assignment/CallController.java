package com.sujit.web_service_assignment;

import com.sujit.web_service_assignment.CallRecord;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

@RestController
public class CallController {

    private final Map<String, CallRecord> calls = new ConcurrentHashMap<>();

    @PostMapping("/call-ended")
    public ResponseEntity<?> callEnded(@RequestBody CallRecord call) {

        // Check if call_id is missing
        if (call.getCall_id() == null || call.getCall_id().trim().isEmpty()) {
            return ResponseEntity
                    .badRequest()
                    .body(Map.of("error", "call_id is required"));
        }

        // Store only if call_id doesn't already exist
        calls.putIfAbsent(call.getCall_id(), call);

        // Successful response even if duplicate
        return ResponseEntity.ok(
                Map.of(
                        "message", "Call record accepted",
                        "call_id", call.getCall_id()
                )
        );
    }

    @GetMapping("/calls/{callId}")
    public ResponseEntity<?> getCall(@PathVariable String callId) {

        CallRecord call = calls.get(callId);

        if (call == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(Map.of(
                            "error", "Call record not found",
                            "call_id", callId
                    ));
        }

        return ResponseEntity.ok(call);
    }
}