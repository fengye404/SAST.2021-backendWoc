package com.example.woc.mapper;

import com.example.woc.entity.Account;
//import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author: 風楪fy
 * @create: 2022-01-15 01:22
 **/
@Repository
public interface UserMapper extends Mapper<Account>{
    @Insert("insert into table_user(username,password,email) VALUES(#{username},#{password},#{email})")
        //void saveUser(Account account);
    int saveUser(@Param("username") String username,
                 @Param("password") String password,@Param("email") String email);
    /**
     * public interface UserMapper {
     *      @Insert("INSERT INTO users (id, name) VALUES(#{id}, #{name})")
     *      void insert(User user);
     *    }
     *
     * @param username
     * @return
     */

    @Select("select id,username,password,email from table_user where username=#{username}")
    Account selectUser(@Param("username") String username);


    @Delete("DELETE FROM table_user WHERE username=#{username}")
    int delByUser(@Param("username") String username);
}
