package com.example.mpdatabs.dao;

import com.example.mpdatabs.dto.AdminMsg;
import com.example.mpdatabs.entity.AdminMsgDO;
import com.example.mpdatabs.entity.IssueDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IAdminBaseDao {
    /**
     * 登录管理员账户
     * @param adminMsg
     * @return
     */
    List<AdminMsgDO> login(@Param("adminMsg") AdminMsg adminMsg);

    /**
     * 获取管理员信息
     * @param adminId
     * @return
     */
    List<AdminMsgDO> listAdmin(@Param("adminId") Integer adminId);

    /**
     * 修改管理员密码
     * @param adminMsg
     * @return
     */
    int updatePassword(@Param("adminMsg") AdminMsg adminMsg);

    /**
     * 获取所有问题
     * @param adminId
     * @param issueSource
     * @return
     */
    List<IssueDO> listIssues(@Param("adminId")Integer adminId,
                             @Param("issueSource")String issueSource);

    /**
     * 删除问题
     * @param issueId
     * @return
     */
    int deleteIssue(@Param("issueId")Integer issueId);
}
