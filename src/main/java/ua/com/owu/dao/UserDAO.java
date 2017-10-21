package ua.com.owu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.multipart.MultipartFile;
import ua.com.owu.entity.User;

public interface UserDAO extends JpaRepository<User,Integer> {
    @Query("from User u where u.username=:username")
    User findByUserName(@Param("username")String username);

    @Query("from User busket_busketId where id=:id")
    int findBusketId(@Param("id")int id);

    @Modifying
    @Query("update User set username=:username where id=:id")
    void setNewName(@Param("username")String username,@Param("id")int id);

    @Modifying
    @Query("update User set email=:email where id=:id")
    void setNewEmail(@Param("email")String email,@Param("id")int id);

    @Modifying
    @Query("update User set avatar=:avatar where id=:id")
    void setNewAvatar(@Param("avatar")String multipartFile, @Param("id")int id);

    @Modifying
    @Query("update User set enabled=:enabled where id=:id")
    void setNewEnable(@Param("enabled")boolean enabled, @Param("id")int id);



}
