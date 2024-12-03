package doit.blog.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import doit.blog.repository.user.User;
import doit.blog.repository.user.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;
    public boolean checkDuplicateId(String id){
        List<User> findUsers= userRepository.findByUserLoginId(id);
        return !findUsers.isEmpty();
    }
    public void save(User user){
        userRepository.save(user);
    }

    public List<User> findByUserLoginId(String s) {
        return userRepository.findByUserLoginId(s);
    }

    public boolean checkValidFormat(String id) {
        return !(id.matches("^[a-zA-Z0-9]*$") && id.length() >= 5 && id.length() < 30);
    }
}
