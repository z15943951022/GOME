package service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;
import service.UserService;
import util.GetConnection;

public class UserServiceImpl implements UserService{
          Connection connection = null;
          UserDao userDao = null;
          
          public int addUser(User user) {
                    int rel = -1;
                    try {
                              connection =  GetConnection.getConnection();
                              userDao = new UserDaoImpl(connection);
                        	  rel = userDao.addUser(user);
                    } catch (SQLException e) {
                              e.printStackTrace();
                    }finally{
                              GetConnection.close(connection);
                    }
                    return rel;
          }
          
          /**
           * 根据手机号查
           */
          public User findUserByPhone(String phone){
        	  User user=new User();
        	  try {
				connection =  GetConnection.getConnection();
				userDao = new UserDaoImpl(connection);
	            user = userDao.findUserByPhone(phone);
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
                GetConnection.close(connection);
			}
			return user;
          }

          /**
           * 根据用户名查
           * @param name
           * @return
           */
          public User findUserByName(String name){
        	  User user=new User();
        	  try {
				connection =  GetConnection.getConnection();
				userDao = new UserDaoImpl(connection);
	            user = userDao.userByName(name);
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
                GetConnection.close(connection);
			}
			return user;
          }
          
          
          public int deleteUser(User user) {
                    int rel = -1;
                    try {
                              connection =  GetConnection.getConnection();
                              userDao = new UserDaoImpl(connection);
                              rel = userDao.deleteUser(user);
                    } catch (SQLException e) {
                              e.printStackTrace();
                    }finally{
                              GetConnection.close(connection);
                    } 
                    return rel;
          }

          
          @Override
          public int updateUserById(User user) {
                    int rel = -1;
                    try {
                              connection =  GetConnection.getConnection();
                              userDao = new UserDaoImpl(connection);
                              rel = userDao.updateUserById(user);
                    } catch (SQLException e) {
                              e.printStackTrace();
                    }finally{
                              GetConnection.close(connection);
                    }
                    return rel;
          }

          
          @Override
          public List<User> selectUser() {
                    List<User> listUser = new ArrayList<User>();
                    try {
                              connection =  GetConnection.getConnection();
                              userDao = new UserDaoImpl(connection);
                              listUser = userDao.selectUser();
                    } catch (SQLException e) {
                              e.printStackTrace();
                    }finally{
                              GetConnection.close(connection);
                    }
                    return listUser;
          }

          
          @Override
          public User findUserById(long userId) {
                    User user= new User();
                    try {
                              connection =  GetConnection.getConnection();
                              userDao = new UserDaoImpl(connection);
                              user = userDao.userById(userId);
                    } catch (SQLException e) {
                              e.printStackTrace();
                    }finally{
                              GetConnection.close(connection);
                    }
                    return user;
          }

          /**
           * 判断用户名是否存在
           */
          public int isExistByName(User userA) {
        	  		int i=-1;
                    User userB = null;
                    try {
                              connection =  GetConnection.getConnection();
                              userDao = new UserDaoImpl(connection);
                              userB = userDao.userByName(userA.getUserName());
                              if(null==userB){
                            	  userB =userDao.findUserByPhone(userA.getUserName());
                              }if(null==userB){
                            	  i=-1;
                              } else if(userB.getPassword().equals(userA.getPassword())){
                            	  userA.setUserId(userB.getUserId());
                            	  userA.setUserName(userB.getUserName());
                            	  userA.setPassword(userB.getPassword());
                            	  userA.setUserPetName(userB.getUserPetName());
                            	  userA.setSex(userB.getSex());
                            	  userA.setPhone(userB.getPhone());
                            	  userA.setEmail(userB.getEmail());
                            	  userA.setPicPath(userB.getPicPath());
                            	  userA.setMoney(userB.getMoney());
                            	  userA.setType(userB.getType());
                            	  i=1;//正确
                              }else{
                            	  i=0;//密码错误
                              }
                    } catch (SQLException e) {
                              e.printStackTrace();
                    }finally{
                              GetConnection.close(connection);
                    }
                    return i;
          }
		


}
