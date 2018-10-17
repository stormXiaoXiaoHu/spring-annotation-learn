package com.atguigu.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sound.midi.Soundbank;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public void inserUser() {
        userDao.insert();
        //otherDao.other()； XXXX
        System.out.println("插入完成...");
        int i = 10/0;
    }

}
