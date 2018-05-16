package com.example.mpdatabs.service.impl;

import com.example.mpdatabs.dao.IAdminBaseDao;
import com.example.mpdatabs.dto.AdminMsg;
import com.example.mpdatabs.entity.AdminMsgDO;
import com.example.mpdatabs.entity.IssueDO;
import com.example.mpdatabs.exception.RequestException;
import com.example.mpdatabs.manager.IUserIssueHandler;
import com.example.mpdatabs.service.IAdminBaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminBaseServiceImpl implements IAdminBaseService{
    Logger logger = LoggerFactory.getLogger(AdminBaseServiceImpl.class);

    private IAdminBaseDao adminBaseDao;
    private IUserIssueHandler userIssueHandler;

    public AdminBaseServiceImpl(IAdminBaseDao adminBaseDao,
                                IUserIssueHandler userIssueHandler) {
        this.adminBaseDao = adminBaseDao;
        this.userIssueHandler = userIssueHandler;
    }

    @Override
    public List<AdminMsgDO> login(AdminMsg adminMsg) {
        List<AdminMsgDO> adminMsgDOList = adminBaseDao.login(adminMsg);
        if (adminMsg.getPassword().equals(adminMsgDOList.get(0).getPassword())){
            adminMsgDOList.get(0).setPassword(null);
            return adminMsgDOList;
        }else {

        }
        return null;
    }

    @Override
    public boolean updatePassword(AdminMsg adminMsg) {
        return adminBaseDao.updatePassword(adminMsg) == 1;
    }

    @Override
    public List<IssueDO> listIssues(Integer adminId,String  issueSource) {
        if (adminBaseDao.listAdmin(adminId).size() > 0){
            return adminBaseDao.listIssues(adminId,issueSource);
        }else {
            throw new RequestException("没有该管理员ID");
        }

    }

    @Override
    public void deleteIssue(Integer adminId, Integer issueId) {
        if (adminBaseDao.listAdmin(adminId).size() > 0) {
            userIssueHandler.deleteIssue(issueId);
        } else {
            throw new RequestException("没有该管理员ID");
        }
    }
}
