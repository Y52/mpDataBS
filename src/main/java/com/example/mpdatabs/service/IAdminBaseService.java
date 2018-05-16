package com.example.mpdatabs.service;

import com.example.mpdatabs.dto.AdminMsg;
import com.example.mpdatabs.entity.AdminMsgDO;
import com.example.mpdatabs.entity.IssueDO;

import java.util.List;

public interface IAdminBaseService {
    /**
     * 管理员登录
     * @param adminMsg
     * @return
     */
    List<AdminMsgDO> login(AdminMsg adminMsg);

    /**
     * 修改管理员密码
     * @param adminMsg
     * @return
     */
    boolean updatePassword(AdminMsg adminMsg);

    /**
     * 获取所有问题
     * @param adminId
     * @param issueSource
     * @return
     */
    List<IssueDO> listIssues(Integer adminId,
                             String  issueSource);

    /**
     * 删除消息
     * @param adminId
     * @param issueId
     */
    void deleteIssue(Integer adminId,
                     Integer issueId);
}
