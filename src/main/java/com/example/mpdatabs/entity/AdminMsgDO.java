package com.example.mpdatabs.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * admin_msg
 * @Author yu
 */
@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class AdminMsgDO {
    private Integer adminId;
    private String adminName;
    private String password;
}
