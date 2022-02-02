package com.example.woc.service;

import com.example.woc.entity.Account;
import com.example.woc.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import javax.annotation.Resource;
import java.util.List;


/**
 * @author: 風楪fy
 * @create: 2022-01-15 01:22
 **/
@Slf4j
@Service("userDetailsService")
public class UserService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;
    @Resource
    private PasswordEncoder passwordEncoder;

    public String login(Account account) {
        String username=account.getUsername();
        String password = account.getPassword();

        Account user = userMapper.selectUser(username);

        if (StringUtils.isEmpty(username)) {
            return "用户名不能为空";
        }
        if (StringUtils.isEmpty(password)) {
            return "密码不能为空";
        }
        if (user == null) {  // 没有从数据库中select到名字
            return "该用户尚未注册，请先行注册";
        }
        if (!(passwordEncoder.matches(password, user.getPassword()))) {
            return "密码错误，请重新输入";
        }
        return "登陆成功";
    }

    public String register(Account account) {
        String username=account.getUsername();
        String password = account.getPassword();
        String email = account.getEmail();
        log.info("username{}", username);
        log.info("password{}", password);
        log.info("email{}", email);

        if (StringUtils.isEmpty(username)) {
            return "用户名不能为空";
        }
        if (StringUtils.isEmpty(password)) {
            return "密码不能为空";
        }
        if (StringUtils.isEmpty(email)) {
            return "邮箱不能为空";
        }
        Account user = new Account();
        user.setUsername(username);
        Account user2=userMapper.selectOne(user);
        if (user2 != null) {
            return "用户已存在~";
        }
        int resultCount=userMapper.saveUser(username, passwordEncoder.encode(password),email);
        if (resultCount== 0) {
            return "注册失败";
        }
        return "注册成功";

    }

    public String deleteAccount(Account account) {
        String username=account.getUsername();
        String password = account.getPassword();
        String email = account.getEmail();
        if (StringUtils.isEmpty(username)) {
            return "用户名不能为空";
        }
        if (StringUtils.isEmpty(password)) {
            return "密码不能为空";
        }
        Account user = userMapper.selectUser(username);

        if (user == null) {  // 没有从数据库中select到名字
            return "该用户尚未注册，请先行注册";
        }
        if (passwordEncoder.matches(password, user.getPassword())){
            //int dee=userMapper.delete(user);
            int dee = userMapper.delByUser(username);
            if (dee != 0) {
                return "删除成功";
            }
            return "删除失败";
        }
        return "密码错误";
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return null;
    }
    public List<Account> getAmountOfAccounts(){
        return userMapper.selectAll();
    }
}

