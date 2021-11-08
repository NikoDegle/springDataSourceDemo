package mine.practice.springdemo.service.impl;

import mine.practice.springdemo.bean.User;
import mine.practice.springdemo.dao.UserDao;
import mine.practice.springdemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : whc
 * @version : 1.0
 * 用户service实例
 */

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(int id) {
        User user = new User();
        user.setUserName(userDao.getUserNameById(id));
        user.setAge(userDao.getUserAgeById(id));
        return user;
    }
}
