package com.example.mpdatabs.manager.impl;

import com.example.mpdatabs.dao.IAdminBaseDao;
import com.example.mpdatabs.dao.IIssueTagBaseDao;
import com.example.mpdatabs.dao.IUserBaseDao;
import com.example.mpdatabs.dto.UserMsg;
import com.example.mpdatabs.exception.RequestException;
import com.example.mpdatabs.manager.IUserIssueHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserIssueHandler implements IUserIssueHandler{
    private IUserBaseDao userBaseDao;
    private IIssueTagBaseDao issueTagBaseDao;
    private IAdminBaseDao adminBaseDao;

    public UserIssueHandler(IUserBaseDao userBaseDao,
                            IIssueTagBaseDao issueTagBaseDao,
                            IAdminBaseDao adminBaseDao) {
        this.userBaseDao = userBaseDao;
        this.issueTagBaseDao = issueTagBaseDao;
        this.adminBaseDao = adminBaseDao;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveUserIssues(UserMsg userMsg) {
        if (userBaseDao.insertUserMsg(userMsg.getPhone(),userMsg.getUserName()) == 0){
            throw new RequestException("插入用户信息失败");
        }

        if (issueTagBaseDao.insertNewIssue(userMsg) == 0){
            throw new RequestException("插入消息失败");
        }

        if (userMsg.getTagIdList().size() != 0) {
            issueTagBaseDao.saveIssueTags(userMsg.getIssueId(), userMsg.getTagIdList());
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteIssue(Integer issueId) {
        if (adminBaseDao.deleteIssue(issueId) == 0) {
            throw new RequestException("删除消息失败");
        }

        issueTagBaseDao.deleteIssueTags(issueId);
    }
}
