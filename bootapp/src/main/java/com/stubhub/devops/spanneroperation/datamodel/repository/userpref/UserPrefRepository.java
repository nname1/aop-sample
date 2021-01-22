package com.stubhub.devops.spanneroperation.datamodel.repository.userpref;

import com.stubhub.devops.spanneroperation.datamodel.entity.UserCommPref;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Longgui Wang
 * @Date: 2021/1/18 10:45 AM
 */

@Repository
public interface UserPrefRepository extends CrudRepository<UserCommPref,String> {

    @Query(value = "select u.usr_comm_pref_id,u.usr_guid,u.domain_id,u.created_by from usr_comm_pref u where u.usr_guid=:userGuid",
            nativeQuery = true)
    List<UserCommPref> findByUserGuid(@Param("userGuid") String userGuid);
}
