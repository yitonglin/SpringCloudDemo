package com.yitonglin.service.pojo;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "user")
public class User {
    //GeneratedValue注解设置主键的生成值策略
    //IDENTITY策略，主键由数据库生成，采用自增长（auto-increment），oracle不支持这种策略SEQUENCE策略，主键由数据库生成，通过数据库的序列产生主键，MYSQL不支持
    //设置成数据库自动生成的话，那Mapper按口里插入语句就可以不用写id那一列了
    //列如：user（username，password）value（值1，值2）
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//由于通用Mapper不知是否是id  所以此处指定为数据库自增主键策略  插入时跳过id插入
    private Integer id;
    private String email;

    private String username;


    private String password;

    private Integer status;


    private String photo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", photo='" + photo + '\'' +
                '}';
    }
}