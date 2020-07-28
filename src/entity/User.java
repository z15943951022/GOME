package entity;

public class User {
          private long userId;
          private String userName;
          private String password;
          private String userPetName;
          private int sex;
          private String phone;
          private String email;
          private String picPath;
          private double money;
          private String  type;
          
          
          public long getUserId() {
                    return userId;
          }
          public void setUserId(long userId) {
                    this.userId = userId;
          }
          public String getUserName() {
                    return userName;
          }
          public void setUserName(String userName) {
                    this.userName = userName;
          }
          public String getPassword() {
                    return password;
          }
          public void setPassword(String password) {
                    this.password = password;
          }
          public String getUserPetName() {
                    return userPetName;
          }
          public void setUserPetName(String userPetName) {
                    this.userPetName = userPetName;
          }
          public int getSex() {
                    return sex;
          }
          public void setSex(int sex) {
                    this.sex = sex;
          }
          public String getPhone() {
                    return phone;
          }
          public void setPhone(String phone) {
                    this.phone = phone;
          }
          public String getEmail() {
                    return email;
          }
          public void setEmail(String email) {
                    this.email = email;
          }
          public String getPicPath() {
                    return picPath;
          }
          public void setPicPath(String picPath) {
                    this.picPath = picPath;
          }
          public double getMoney() {
                    return money;
          }
          public void setMoney(double money) {
                    this.money = money;
          }
          public String getType() {
                    return type;
          }
          public void setType(String type) {
                    this.type = type;
          }
}
