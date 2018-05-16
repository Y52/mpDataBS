package com.example.mpdatabs.dao;

import com.example.mpdatabs.dto.TagMsg;
import com.example.mpdatabs.dto.UserMsg;
import com.example.mpdatabs.entity.TagMsgDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Mapper
@Repository
public interface IIssueTagBaseDao {
    /**
     * 查询所有tag信息
     * @param status
     * @return
     */
    List<TagMsgDO> listTag(@Param("status")Integer status);

    /**
     * 获取tag的信息
     * @param tag
     * @return
     */
    List<TagMsgDO> selectTag(@Param("tag") String tag);

    /**
     * 插入新的tag值
     * @param tagMsg
     * @return
     */
    int insertTag(@Param("tagMsg") TagMsg tagMsg);

    /**
     * 更新tag的status
     * @param tagMsg
     * @return
     */
    int updateTagstatus(@Param("tagMsg") TagMsg tagMsg);

    /**
     * 保存该问题选择的标签
     * @param issueId
     * @param tagIdList
     * @return
     */
    int saveIssueTags(@Param("issueId") Integer issueId,
                      @Param("tagIdList") List<Integer> tagIdList);

    /**
     * 删除问题时同时删除关联的标签
     * @param issueId
     * @return
     */
    int deleteIssueTags(@Param("issueId")Integer issueId);

    /**
     *插入用户的手机号码与消息，同时返回主键id
     * @param userMsg
     * @return
     */
    @Insert({"INSERT INTO user_issue (issue, phone,status,issueSource)","VALUES (#{issue},#{phone},#{status},#{issueSource})"})
    @Options(useGeneratedKeys = true,keyProperty = "issueId")
    int insertNewIssue(UserMsg userMsg);

    /**
     * 修改问题的status
     * @param issueId
     * @return
     */
    int updateIssueStatus(@Param("issueId")Integer issueId,
                          @Param("status")Integer status);
}
