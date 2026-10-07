package com.sujit.web_service_assignment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CallControllerTest {

    @Test
    void duplicateCallIdShouldNotCreateSecondRecord() {

        CallController controller = new CallController();
        CallRecord firstCall =
                new CallRecord("abc123", "answered", 42);

        CallRecord duplicateCall =
                new CallRecord("abc123", "answered", 50);

        controller.callEnded(firstCall);
        controller.callEnded(duplicateCall);

        CallRecord storedCall =
                (CallRecord) controller.getCall("abc123").getBody();

        assertNotNull(storedCall);
        assertEquals("abc123", storedCall.getCall_id());
        assertEquals(42, storedCall.getDuration_secs());
    }
}