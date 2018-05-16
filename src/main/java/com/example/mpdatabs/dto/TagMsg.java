package com.example.mpdatabs.dto;

import lombok.Data;

@Data
public class TagMsg {
    private String tag;
    private Integer tagId;
    private Integer status;
    private String tagSource;
    private String color;
}
