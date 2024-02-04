package com.boot.service.user;

import com.boot.entity.product.Product;
import com.boot.entity.user.User;
import com.boot.repository.user.UserRepository;
import com.boot.service.CrudService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("UserServiceImpl")
@Slf4j
@AllArgsConstructor
public class UserServiceImpl implements CrudService<User> {

    @Autowired
    private UserRepository userRepository;
    @Override
    public ResponseEntity<User> save(User saveObject) {
        return ResponseEntity.ok(userRepository.save(saveObject));
    }

    @Override
    public ResponseEntity<List<User>> fetchAll() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    @Override
    public ResponseEntity<Optional<User>> fetchById(Long id) {
        Optional<User> userById = userRepository.findById(id);
        if (userById.isPresent()) {
            return ResponseEntity.ok(userById);
        } else {
            return ResponseEntity.of(Optional.of(userById));
        }
    }

    @Override
    public ResponseEntity<User> update(Long id, User updateObject) {
        return null;
    }

    @Override
    public ResponseEntity<String> delete(Long id) {
        return null;
    }
}
