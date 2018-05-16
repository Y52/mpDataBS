package com.example.mpdatabs.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class TagMsgDO {
    private Integer tagId;
    private String tag;
    private Integer status;
    private String tagSource;
    private String color;
}
