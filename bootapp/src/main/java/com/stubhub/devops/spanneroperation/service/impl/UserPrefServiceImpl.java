package com.stubhub.devops.spanneroperation.service.impl;

import com.stubhub.devops.spanneroperation.datamodel.entity.UserCommPref;
import com.stubhub.devops.spanneroperation.datamodel.repository.userpref.UserPrefRepository;
import com.stubhub.devops.spanneroperation.service.intf.UserPrefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Longgui Wang
 * @Date: 2021/1/21 10:47 AM
 */

@Service
public class UserPrefServiceImpl implements UserPrefService {

    @Autowired
    private UserPrefRepository userPrefRepository;

    @Override
    public List<UserCommPref> getUserPrefByUserGuid(String userGuid) {
        return userPrefRepository.findByUserGuid(userGuid);
    }
}
