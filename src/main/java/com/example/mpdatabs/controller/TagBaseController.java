package com.example.mpdatabs.controller;

import com.example.mpdatabs.dto.TagMsg;
import com.example.mpdatabs.entity.TagMsgDO;
import com.example.mpdatabs.response.ResultBean;
import com.example.mpdatabs.service.ITagBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/weixinmp/tag")
public class TagBaseController {
    ITagBaseService tagBaseService;

    @Autowired
    public TagBaseController(ITagBaseService tagBaseService) {
        this.tagBaseService = tagBaseService;
    }

    @GetMapping
    public ResultBean<List<TagMsgDO>> listTag(@RequestHeader (required = false) Integer status){
        return new ResultBean<>(tagBaseService.listTag(status));
    }

    @PostMapping
    public ResultBean<List<TagMsgDO>> saveTag(@RequestBody TagMsg tagMsg){
        return new ResultBean<>(tagBaseService.saveTag(tagMsg));
    }

    @PutMapping
    public ResultBean updateTagStatus(@RequestBody TagMsg tagMsg){
        tagBaseService.updateTagStatus(tagMsg);
        return new ResultBean();
    }

}
