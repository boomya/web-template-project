package org.boom.web.service.impl;

import org.boom.web.dao.UserMapper;
import org.boom.web.domain.User;
import org.boom.web.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by jiangshan on 14/8/20.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public User getUserById(int userId) {
        return userMapper.selectByPrimaryKey(userId);
    }
}
