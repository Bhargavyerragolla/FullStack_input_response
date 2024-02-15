// DataController.java
package org.example.responsebacked;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/api/Resp")
    public ApiResponse processData(@RequestBody DataRequest request) {
        // Process the input data
        String message = String.format("Hello, %s! Your phone number is %s, you're located at %s, and your email is %s",
                request.getName(), request.getPhoneNumber(), request.getLocation(), request.getEmail());
        return new ApiResponse(message);
    }
}


