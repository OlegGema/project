package ua.com.owu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.owu.dao.UserDAO;
import ua.com.owu.entity.User;
import ua.com.owu.service.UserService;

import java.util.List;

@Service
@Transactional
public class UserSeviceImpl implements UserDetailsService,UserService{
    @Autowired
    UserDAO dao;
    @Autowired
    PasswordEncoder passwordEncoder;

    public void save(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        dao.save(user);
    }

    public User findOne(int id){
        return dao.findOne(id);
    }

    @Override
    public void setNewName(String username, int id) {
        dao.setNewName(username,id);
    }

    @Override
    public void setNewEmail(String email, int id) {
        dao.setNewEmail(email,id);
    }

    @Override
    public void setNewAvatar(String multipartFile, int id) {
        dao.setNewAvatar(multipartFile,id);
    }

    @Override
    public int findBusketId(int id) {
        return dao.findBusketId(id);
    }

    @Override
    public void setNewEnable(boolean enable, int id) {
        dao.setNewEnable(enable,id);
    }

    public List<User>findAll(){
        return dao.findAll();
    }

    public User findByName(String username){
        return dao.findByUserName(username);
    }
    

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return findByName(username);
    }
}
