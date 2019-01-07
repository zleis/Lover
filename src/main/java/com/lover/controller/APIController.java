package com.lover.controller;

import com.lover.entity.Manager;
import com.lover.entity.Result;
import com.lover.service.ManagerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class APIController {

    private static Logger logger = Logger.getLogger(APIController.class);

    @Autowired
    private ManagerService managerService;

    @RequestMapping(value = "/manager/login")
    @ResponseBody
    public Result login(Manager manager){
        logger.info("/api/manager/login");
        Result result = managerService.login(manager);

        return result;
    }
//    public
}
