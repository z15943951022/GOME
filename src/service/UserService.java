package service;

import java.util.List;

import entity.User;

public interface UserService {
          /**
           * 增加一条用户信息
           * @param user
           * @return
           */
          public int addUser(User user);
          
          /**
           * 根据用户id删除一条用户信息
           * @param user
           * @return
           */
          public int deleteUser(User user);
            
          /**
           * 根据用户id修改用户所有信息
           * @param user
           * @return
           */
          public int updateUserById(User user);
          
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
          public User findUserById(long id);
          
          /**
           * 根据用户名查询用户所有信息
           * @param userName
           * @return
           */
          public int isExistByName(User user) ;
          
          /**
           * 根据电话号查询用户
           * @param phone
           * @return
           */
          User findUserByPhone(String phone);
          
          /**
           * 根据用户名查询用户所有信息
           * @param userName
           * @return
           */
          public User findUserByName(String userName);

}
