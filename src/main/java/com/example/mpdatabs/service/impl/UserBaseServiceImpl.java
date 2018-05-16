package com.example.mpdatabs.service.impl;

import com.example.mpdatabs.dao.IIssueTagBaseDao;
import com.example.mpdatabs.dao.IUserBaseDao;
import com.example.mpdatabs.dto.UserMsg;
import com.example.mpdatabs.exception.RequestException;
import com.example.mpdatabs.manager.IUserIssueHandler;
import com.example.mpdatabs.service.IUserBaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBaseServiceImpl implements IUserBaseService{
    Logger logger = LoggerFactory.getLogger(UserBaseServiceImpl.class);

    private IUserBaseDao userBaseDao;
    private IIssueTagBaseDao issueTagBaseDao;
    private IUserIssueHandler userIssueHandler;

    @Autowired
    public UserBaseServiceImpl(IUserBaseDao userBaseDao,
                               IIssueTagBaseDao issuetagBaseDao,
                               IUserIssueHandler userIssueHandler) {
        this.userBaseDao = userBaseDao;
        this.issueTagBaseDao = issuetagBaseDao;
        this.userIssueHandler = userIssueHandler;
    }

    @Override
    public void createNewText(UserMsg userMsg) {
        userIssueHandler.saveUserIssues(userMsg);
    }

    @Override
    public void updateIssueStatus(Integer issueId, Integer status) {
        issueTagBaseDao.updateIssueStatus(issueId,status);
    }
}
