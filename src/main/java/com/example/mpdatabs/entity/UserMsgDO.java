package com.example.mpdatabs.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class UserMsgDO {
    private String phone;
    private String userName;
    private String issue;
}
