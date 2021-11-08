package mine.practice.springdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mine.practice.springdemo.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author : whc
 * @version : 1.0
 * 用户类mapper
 */
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from t_user")
    List<User> selectAll();

    @Insert("insert into t_user (user_name) values (#{user.userName})")
    Integer insertUserName(@Param("user") User user);

    @Insert("insert into t_user_age (id, user_age) values (#{user.id}, #{user.age})")
    Integer insertUserAge(@Param("user") User user);

    @Select("select * from t_user where id=#{id}")
    User selectNameById(@Param("id") int id);

    @Select("select * from t_user_age where id=#{id}")
    User selectAgeById(@Param("id") int id);
}
