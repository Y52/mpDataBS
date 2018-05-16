package com.example.mpdatabs.controller;

import com.example.mpdatabs.dto.AdminMsg;
import com.example.mpdatabs.entity.AdminMsgDO;
import com.example.mpdatabs.entity.IssueDO;
import com.example.mpdatabs.response.ResultBean;
import com.example.mpdatabs.service.IAdminBaseService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/weixinmp/admin")
public class AdminBaseController {
    private IAdminBaseService adminBaseService;

    @Autowired
    public AdminBaseController(IAdminBaseService adminBaseService) {
        this.adminBaseService = adminBaseService;
    }

    @PostMapping("/login")
    public ResultBean<List<AdminMsgDO>> login(@RequestBody AdminMsg adminMsg){
        List<AdminMsgDO> adminMsgDOList = adminBaseService.login(adminMsg);
        if (adminMsgDOList == null) {
            return new ResultBean<>(1, "用户名或者密码错误");
        }
        return new ResultBean<>(adminMsgDOList);
    }

    @PutMapping("/password")
    public ResultBean updatePassword(@RequestBody AdminMsg adminMsg){
        if (adminBaseService.updatePassword(adminMsg)){
            return new ResultBean();
        }else {
            return new ResultBean(1,"不存在该管理员");
        }

    }

    @GetMapping("/issues")
    public ResultBean<List<IssueDO>> ListIssues(@RequestHeader Integer adminId,
                                                @RequestHeader(required = false) String issueSource){
        return new ResultBean<>(adminBaseService.listIssues(adminId,issueSource));
    }

    @DeleteMapping("/issue")
    public ResultBean deleteIssue(@RequestHeader Integer adminId,
                                  @RequestHeader Integer issueId) {
        adminBaseService.deleteIssue(adminId,issueId);
        return new ResultBean();
    }

    /**
     * 测试https用
     * @return
     */
    @GetMapping
    public String getString(){
        return "fdaf";
    }
}
