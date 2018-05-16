package com.example.mpdatabs.dao;

import com.example.mpdatabs.dto.UserMsg;
import com.example.mpdatabs.entity.UserMsgDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IUserBaseDao {
    /**
     * 插入新的用户信息，使用Replace Into
     * @param phone
     * @param userName
     * @return
     */
    int insertUserMsg(@Param("phone") String phone,
                      @Param("userName") String userName);
}
