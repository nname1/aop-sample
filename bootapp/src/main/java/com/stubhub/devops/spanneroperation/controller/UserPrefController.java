package com.stubhub.devops.spanneroperation.controller;

import com.stubhub.devops.spanneroperation.datamodel.entity.UserCommPref;
import com.stubhub.devops.spanneroperation.service.intf.UserPrefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

/**
 * @Author: Longgui Wang
 * @Date: 2021/1/18 10:45 AM
 */

@RestController
public class UserPrefController {

    @Autowired
    private UserPrefService userPrefService;

    @RequestMapping(value = "/userpref/get", method = RequestMethod.GET)
    @ResponseStatus(OK)
    @ResponseBody
    public List<UserCommPref> getUserPref(@RequestParam("userGuid") String userGuid){
        try {
            List<UserCommPref> userCommPrefList = userPrefService.getUserPrefByUserGuid(userGuid);
            return userCommPrefList;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
