package com.java.firebase;


import java.util.concurrent.ExecutionException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String createUser(User user) throws ExecutionException, InterruptedException {
        return userRepository.createUser(user);
    }

    public User getUser(String id) throws ExecutionException, InterruptedException {
        return userRepository.getUser(id);
    }

    public <User> String updateUser(User user) throws ExecutionException, InterruptedException {
        return userRepository.updateUser_1(user);
    }

    public String deleteUser(String id) throws ExecutionException, InterruptedException {
        return userRepository.deleteUser1(id);
    }
}

