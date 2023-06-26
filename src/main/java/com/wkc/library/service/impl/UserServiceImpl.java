package com.wkc.library.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wkc.library.mapper.UserMapper;
import com.wkc.library.service.UserService;
import com.wkc.library.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author xiaoniao
 * @date 2023/2/17 13:33
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
