package com.example.mpdatabs.service.impl;

import com.example.mpdatabs.dao.IIssueTagBaseDao;
import com.example.mpdatabs.dto.TagMsg;
import com.example.mpdatabs.entity.TagMsgDO;
import com.example.mpdatabs.exception.RequestException;
import com.example.mpdatabs.service.ITagBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagBaseServiceImpl implements ITagBaseService {
    IIssueTagBaseDao issueTagBaseDao;

    @Autowired
    public TagBaseServiceImpl(IIssueTagBaseDao issuetagBaseDao) {
        this.issueTagBaseDao = issuetagBaseDao;
    }

    @Override
    public List<TagMsgDO> listTag(Integer status) {
        return issueTagBaseDao.listTag(status);
    }

    @Override
    public List<TagMsgDO> saveTag(TagMsg tagMsg) {
        if (issueTagBaseDao.insertTag(tagMsg) == 0){
            throw new RequestException("保存新标签失败");
        }

        return issueTagBaseDao.selectTag(tagMsg.getTag());
    }

    @Override
    public void updateTagStatus(TagMsg tagMsg) {
        if (issueTagBaseDao.updateTagstatus(tagMsg) != 1){
            throw new RequestException("更新失败");
        }
    }
}
