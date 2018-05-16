package com.example.mpdatabs.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
public class UserMsg {
    private String phone;
    private String userName;
    private Integer issueId;
    private String issue;
    private String issueSource;
    private String company;
    private Integer status;
    private List<Integer> tagIdList;
}
