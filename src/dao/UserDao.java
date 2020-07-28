package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import entity.User;


public interface UserDao {
          /**
           * 增加一条用户信息
           * @param user
           * @return
         * @throws SQLException 
           */
          public int addUser(User user) throws SQLException;
          
          /**
           * 根据用户id删除一条用户信息
           * @param user
           * @return
         * @throws SQLException 
           */
          public int deleteUser(User user) throws SQLException;
            
          /**
           * 根据用户id修改用户所有信息
           * @param user
           * @return
         * @throws SQLException 
           */
          public int updateUserById(User user) throws SQLException;
          
          /**
           * 查询所有用户的信息
           * @return
           */
          public List<User> selectUser();
          
          /**
           * 根据用户id查询用户所有信息
           * @param user
           * @return
           */
          public User userById(long userId);
          
          /**
           * 根据用户名查询用户所有信息
           * @param userName
           * @return
           */
          public User userByName(String userName);
          
          /**
           * 根据手机号
           * @param phone
           * @return
           */
          public User findUserByPhone(String phone);
          
         

		
          
}
