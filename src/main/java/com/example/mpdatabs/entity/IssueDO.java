package com.example.mpdatabs.entity;

import com.example.mpdatabs.dto.UserMsg;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class IssueDO {
    private Integer issueId;
    private String issue;
    private String issueSource;
    private Integer status;
    private List<TagMsgDO> tagIdList;
    UserMsgDO userMsg;
}
