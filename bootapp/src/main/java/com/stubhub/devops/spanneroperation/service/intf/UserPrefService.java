package com.stubhub.devops.spanneroperation.service.intf;

import com.stubhub.devops.spanneroperation.datamodel.entity.Order;
import com.stubhub.devops.spanneroperation.datamodel.entity.UserCommPref;

import java.util.List;

/**
 * @Author: Longgui Wang
 * @Date: 2021/1/18 10:45 AM
 */

public interface UserPrefService {

    public List<UserCommPref> getUserPrefByUserGuid(String userGuid);
}
