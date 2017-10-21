package ua.com.owu.service;

import org.springframework.web.multipart.MultipartFile;
import ua.com.owu.entity.User;

import java.util.List;

public interface UserService {
    void save(User user);
    User findByName(String username);
    List<User>findAll();
    User findOne(int id);
    void setNewName(String username,int id);
    void setNewEmail(String email,int id);
    void setNewAvatar(String multipartFile,int id);
    int findBusketId(int id);
    void setNewEnable(boolean enable,int id);

}
