package com.example.mpdatabs.manager;

import com.example.mpdatabs.dto.UserMsg;

public interface IUserIssueHandler {
    /**
     * 新增用户信息，新增用户的消息，新增消息的标签属性
     * @param userMsg
     */
    void saveUserIssues(UserMsg userMsg);

    /**
     * 删除消息以及标签关联
     * @param issueId
     */
    void deleteIssue(Integer issueId);
}

