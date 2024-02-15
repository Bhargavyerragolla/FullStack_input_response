package org.example.springpostgress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DataController {

    private final UserRepository userRepository;

    @Autowired
    public DataController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/api/Resp")
    public ApiResponse processData(@RequestBody DataRequest request) {
        // Process the input data
        String message = String.format("Hello, %s! Your phone number is %s, you're located at %s, and your email is %s",
                request.getName(), request.getPhoneNumber(), request.getLocation(), request.getEmail());

        // Save the response data to the database
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(request.getName());
        userEntity.setEmail(request.getEmail());
        userEntity.setLocation(request.getLocation());
        userEntity.setPhone(request.getPhoneNumber());

        userRepository.save(userEntity);

        return new ApiResponse(message);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/api/Resp/{id}")
    public void deleteData(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
