package mine.practice.springdemo.service;

import mine.practice.springdemo.bean.User;

/**
 * @author : whc
 * @version : 1.0
 * 获取用户数据service
 */
public interface IUserService {

    /**
     * 根据id获取用户数据方法
     * @param id 用户id
     * @return
     */
    public User getUserById(int id);
}
