package com.example.mpdatabs.service;

import com.example.mpdatabs.dto.UserMsg;
import com.example.mpdatabs.entity.UserMsgDO;

import java.util.List;

public interface IUserBaseService {
    /**
     * 新建消息
     * @param userMsg
     * @return
     */
    void createNewText(UserMsg userMsg);

    /**
     * 修改用户消息的status
     * @param issueId
     * @param status
     */
    void updateIssueStatus(Integer issueId,
                           Integer status);
}
