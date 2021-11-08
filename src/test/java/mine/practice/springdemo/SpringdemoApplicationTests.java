package mine.practice.springdemo;

import mine.practice.springdemo.annotation.DS;
import mine.practice.springdemo.bean.User;
import mine.practice.springdemo.dataSource.DataSourceConstants;
import mine.practice.springdemo.dataSource.DynamicDataSourceContextHolder;
import mine.practice.springdemo.mapper.UserMapper;
import mine.practice.springdemo.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringdemoApplicationTests {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private IUserService userServiceImpl;

	@Test
	void contextLoads() {
	}

	@Test
	public void testInsert() {
		User user = new User();
		user.setUserName("用户1");
		user.setAge(18);
		userMapper.insertUserName(user);
	}

	@Test
	public void testSelect() {
		System.out.println(userMapper.selectAll().get(0).getUserName());
	}

	@Test
	public void testDynamicDataSource() {
		User user = getOneUser();
		user.setAge(18);
		insertUserAge(user);
	}

	public User getOneUser() {
		return userMapper.selectAll().get(0);
	}

	@DS(DataSourceConstants.DS_SLAVE)
	public int insertUserAge(User user) {
		DynamicDataSourceContextHolder.setContextKey(DataSourceConstants.DS_SLAVE);
		int result = userMapper.insertUserAge(user);
		DynamicDataSourceContextHolder.removeContextKey();
		return result;
	}

	@Test
	public void testGetUser() {
		User user = userServiceImpl.getUserById(1);
		System.out.println(user.getAge());
	}

}
