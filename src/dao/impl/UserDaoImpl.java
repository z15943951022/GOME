package dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.GetConnection;
import dao.BaseDao;
import dao.UserDao;
import entity.User;

public class UserDaoImpl extends BaseDao implements UserDao{
          public UserDaoImpl(Connection connection) {
                    super(connection);
          }
          
          
          public int addUser(User user) throws SQLException {
                    int rel = -1;
                    String sql = "INSERT into user(userName,password,sex,phone,email,picPath,money)VALUES(?,?,?,?,?,?,?)";
                    Object []obj = {user.getUserName(),user.getPassword(),user.getSex(),user.getPhone(),user.getEmail(),user.getPicPath(),user.getMoney()};
                    rel =  this.executeUpdate(sql, obj);
                    return rel;
          }


          public int deleteUser(User user) throws SQLException {
                    int rel = -1;
                    String sql = "DELETE FROM user where userId = ?";
                    Object []obj = {user.getUserId()};
                    rel = this.executeUpdate(sql, obj);
                    return rel;
          }


          public int updateUserById(User user) throws SQLException {
                    int rel = -1;
                    String sql = "UPDATE user SET  userPetName=? , sex=? , phone=? , email=? , money=? , TYPE=?  ";
                    if(user.getPicPath()!=null){
                    	sql+=" ,picPath='"+user.getPicPath()+"' ";
                    }
                    sql+=" where userId = ?";
                   Object []obj = { user.getUserPetName() , user.getSex() , user.getPhone() , user.getEmail() , user.getMoney() , user.getType() , user.getUserId()};
                    rel = this.executeUpdate(sql, obj);
                    return rel;
          }

          
          public List<User> selectUser() {
                    List<User> listUser = new ArrayList<User>();
                    String sql = "SELECT userId,userName,password,userPetName,sex,phone,email,picPath,money,type from user";
                    Object []obj = {};
                    try {
                              rs = this.executeQuery(sql, obj);
                              User selectUser = null;
                              while(rs.next()){
                                        selectUser = new User();
                                        selectUser.setUserId(rs.getLong("userId"));
                                        selectUser.setUserName(rs.getString("userName"));
                                        selectUser.setPassword(rs.getString("password"));
                                        selectUser.setUserPetName(rs.getString("userPetName"));
                                        selectUser.setSex(rs.getInt("sex"));
                                        selectUser.setPhone(rs.getString("phone"));
                                        selectUser.setEmail(rs.getString("email"));
                                        selectUser.setPicPath(rs.getString("picPath"));
                                        selectUser.setMoney(rs.getDouble("money"));
                                        selectUser.setType(rs.getString("type"));                
                                        listUser.add(selectUser);
                              }
                    } catch (SQLException e) {
                              e.printStackTrace();
                    }finally{
                              GetConnection.close(rs,ps);
                    }
                    return listUser;
          }


          public User userById(long userId) {
                    User user = new User();
                    String sql = "SELECT userId,userName,password,userPetName,sex,phone,email,picPath,money,type FROM user where userId = ?";
                    Object []obj = {userId};
                    try {
                              rs = this.executeQuery(sql, obj);
                              if(rs.next()){
                                        user.setUserId(rs.getLong("userId"));
                                        user.setUserName(rs.getString("userName"));
                                        user.setPassword(rs.getString("password"));
                                        user.setUserPetName(rs.getString("userPetName"));
                                        user.setSex(rs.getInt("sex"));
                                        user.setPhone(rs.getString("phone"));
                                        user.setEmail(rs.getString("email"));
                                        user.setPicPath(rs.getString("picPath"));
                                        user.setMoney(rs.getDouble("money"));
                                        user.setType(rs.getString("type"));                
                              }
                    } catch (SQLException e) {
                              e.printStackTrace();
                    }finally{
                              GetConnection.close(rs,ps);
                    }
                    return user;
          }


          public User userByName(String userName) {
                    User user = null;
                    String sql = "SELECT userId,userName,password,userPetName,sex,phone,email,picPath,money,type FROM user where userName = ?";
                    Object []obj = {userName};
                    try {
                              rs = this.executeQuery(sql, obj);
                                        while(rs.next()){
                                        user = new User();
                                        user.setUserId(rs.getLong("userId"));
                                        user.setUserName(rs.getString("userName"));
                                        user.setPassword(rs.getString("password"));
                                        user.setUserPetName(rs.getString("userPetName"));
                                        user.setSex(rs.getInt("sex"));
                                        user.setPhone(rs.getString("phone"));
                                        user.setEmail(rs.getString("email"));
                                        user.setPicPath(rs.getString("picPath"));
                                        user.setMoney(rs.getDouble("money"));
                                        user.setType(rs.getString("type"));   
                              }
                    } catch (SQLException e) {
                              e.printStackTrace();
                    }finally{
                              GetConnection.close(rs,ps);
                    }           
                    return user;
          }

		public User findUserByPhone(String phone) {
			 User user = null;
             String sql = "SELECT userId,userName,password,userPetName,sex,phone,email,picPath,money,type FROM user where phone = ?";
             Object []obj = {phone};
             try {
                       rs = this.executeQuery(sql, obj);
                                 while(rs.next()){
                                 user = new User();
                                 user.setUserId(rs.getLong("userId"));
                                 user.setUserName(rs.getString("userName"));
                                 user.setPassword(rs.getString("password"));
                                 user.setUserPetName(rs.getString("userPetName"));
                                 user.setSex(rs.getInt("sex"));
                                 user.setPhone(rs.getString("phone"));
                                 user.setEmail(rs.getString("email"));
                                 user.setPicPath(rs.getString("picPath"));
                                 user.setMoney(rs.getDouble("money"));
                                 user.setType(rs.getString("type"));   
                       }
             } catch (SQLException e) {
                       e.printStackTrace();
             }finally{
                       GetConnection.close(rs,ps);
             }           
             return user;
		}
          
        

}
