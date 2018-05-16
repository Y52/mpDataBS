package com.example.mpdatabs.controller;

import com.example.mpdatabs.dto.UserMsg;
import com.example.mpdatabs.entity.UserMsgDO;
import com.example.mpdatabs.response.ResultBean;
import com.example.mpdatabs.service.IUserBaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/weixinmp/user")
public class UserBaseController {
    private IUserBaseService userBaseService;

    public UserBaseController(IUserBaseService userBaseService) {
        this.userBaseService = userBaseService;
    }

    @PostMapping("/newText")
    public ResultBean createNewText(@RequestBody UserMsg userMsg){
        userBaseService.createNewText(userMsg);
        return new ResultBean();
    }

    @PutMapping("/issueStatus")
    public ResultBean updateIssueStatus(@RequestHeader Integer issueId,
                                        @RequestHeader Integer status){
        userBaseService.updateIssueStatus(issueId,status);
        return new ResultBean();
    }
}
