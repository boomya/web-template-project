package org.boom.web.service.impl;

import org.boom.share.manager.BoomMapperLocators;
import org.boom.share.manager.dao.UserMapper;
import org.boom.share.manager.domain.UserDO;
import org.boom.web.domain.User;
import org.boom.web.service.UserService;

/**
 * Created by jiangshan on 14/8/20.
 */
public class UserServiceImpl implements UserService {

    private UserMapper userMapper = BoomMapperLocators.getUserMapper();

    @Override
    public User getUserById(int userId) {
        UserDO userDO = userMapper.selectByPrimaryKey(userId);
        User user = new User();
        user.setId(userDO.getId());
        user.setAge(userDO.getAge());
        user.setUserName(userDO.getUserName());
        user.setPassword(userDO.getPassword());
        return user;
    }
}
