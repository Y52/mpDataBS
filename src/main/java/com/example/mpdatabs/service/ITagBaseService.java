package com.example.mpdatabs.service;

import com.example.mpdatabs.dto.TagMsg;
import com.example.mpdatabs.entity.TagMsgDO;

import javax.swing.text.html.HTML;
import java.util.List;

public interface ITagBaseService {
    /**
     * 查询所有标签
     * @param status
     * @return
     */
    List<TagMsgDO> listTag(Integer status);

    /**
     *新建标签
     * @param tagMsg
     * @return
     */
    List<TagMsgDO> saveTag(TagMsg tagMsg);

    /**
     *
     * @param tagMsg
     */
    void updateTagStatus(TagMsg tagMsg);

}
