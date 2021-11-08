package mine.practice.springdemo.dao;

import mine.practice.springdemo.annotation.DS;
import mine.practice.springdemo.dataSource.DataSourceConstants;
import mine.practice.springdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : whc
 * @version : 1.0
 * 用户数据dao层
 */

@Component
public class UserDao {

    @Autowired
    private UserMapper userMapper;

    public String getUserNameById(int id) {
        return userMapper.selectNameById(id).getUserName();
    }

    @DS(DataSourceConstants.DS_SLAVE)
    public Integer getUserAgeById(int id) {
        return userMapper.selectAgeById(id).getAge();
    }
}
