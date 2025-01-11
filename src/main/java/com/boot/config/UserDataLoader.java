package com.boot.config;


import com.boot.entity.user.User;
import com.boot.repository.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserDataLoader implements CommandLineRunner {
    private final UserRepository userRepository;

    public UserDataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Load initial data into the database
        userRepository.save(new User("Raj", "Kumar", "ENG, HINDI", "rajkumar@example.com", "Patna, Bihar"));
        userRepository.save(new User("Eswar", "Yadav","Hindi", "eswae@example.com", "Darbhanga, Bihar"));
    }
}
