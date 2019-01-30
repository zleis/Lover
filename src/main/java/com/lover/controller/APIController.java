package com.lover.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lover.entity.*;
import com.lover.service.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@Controller
@RequestMapping("/api/manager")
public class APIController {

    private static Logger logger = Logger.getLogger(APIController.class);

    @Autowired
    private ManagerService managerService;

    @Autowired
    private AnswerService answerService;

    @Autowired
    private MemoryService memoryService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private GalleryService galleryService;

    
    /**
     * @Method login
     * @Date 2019/1/20
     * @TODO 用户登录RUL
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result login(Manager manager, HttpServletRequest request){
        logger.info("/api/manager/login");
        Result result = managerService.login(manager);
        if(result.getFeedback() == Feedback.FEEDBACK_SUCCESS.getFeedback()){
            logger.info(((Manager)result.getObj()).toString());
            HttpSession session = request.getSession();
            session.setAttribute("login",Constant.LOGIN_CONDITION);
            session.setAttribute("uid", ((Manager)result.getObj()).getMid());
            session.setAttribute("name", ((Manager)result.getObj()).getName());
            session.setAttribute("photo", ((Manager)result.getObj()).getPhoto());
        }
        return result;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public Result logout(HttpServletRequest request){
        logger.info("/logout");
        HttpSession session = request.getSession();
        session.setAttribute("login", Constant.LOGOUT_CONDITION);
        return Result.resultFactory(Feedback.FEEDBACK_SUCCESS);
    }


    @RequestMapping(value = "/infoEdit", method = RequestMethod.POST)
    @ResponseBody
    public Result infoEdit(String oldpass, String newpass, HttpServletRequest request){
        HttpSession session = request.getSession();
        String mid = (String)session.getAttribute("uid");
        Result result = managerService.infoEdit(mid, oldpass, newpass);
        return result;
    }
    /**
     * @Method answerAdd
     * @Date 2019/1/24
     * @TODO 添加简答
     */
    @RequestMapping(value = "/answerAdd", method = RequestMethod.POST)
    @ResponseBody
    public Result answerAdd(Answer answer, HttpServletRequest request){
        logger.info("/answerAdd");
        HttpSession session = request.getSession();
        answer.answerManager((String)session.getAttribute("uid"));
        answer.setRtime(0);
        answer.setAid(String.valueOf(System.currentTimeMillis()/1000));
        answer.answerFormat();
        Result result = answerService.answerAdd(answer);
        return result;
    }


    /**
     * @Method answerDel
     * @Date 2019/1/24
     * @TODO 删除简答
     */
    @RequestMapping(value = "/answerDel", method = RequestMethod.POST)
    @ResponseBody
    public Result answerDel(Answer answer, HttpServletRequest request){
        logger.info("/answerDel");
        Result result = answerService.answerDel(answer);
        return result;
    }

    /**
     * @Method answerEdit
     * @Date 2019/1/24
     * @TODO 修改简答
     */
    @RequestMapping(value = "/answerEdit", method = RequestMethod.POST)
    @ResponseBody
    public Result answerEdit(Answer answer, HttpServletRequest request){
        answer.answerFormat();
        Result result = answerService.answerEdit(answer);
        return result;
    }

    /**-------------------------- 回忆录添加 ----------------------------------*/
    /**
     * @Method MemoryAdd
     * @Date 2019/1/24
     * @TODO 添加回忆录
     */
    @RequestMapping(value = "/memoryAdd", method = RequestMethod.POST)
    @ResponseBody
    public Result memoryAdd(Memory memory, HttpServletRequest request){
        HttpSession session = request.getSession();
        Manager manager = new Manager();
        manager.setMid((String)session.getAttribute("uid"));
        memory.setManager(manager);
        Result result = memoryService.memoryAdd(memory);
        return result;
    }

    /**
     * @Method memoryEdit
     * @Date 2019/1/24
     * @TODO 修改回忆录
     */
    @RequestMapping(value = "/memoryEdit", method = RequestMethod.POST)
    @ResponseBody
    public Result memoryEdit(Memory memory, HttpServletRequest request){
        memory.format();
        Result result = memoryService.memoryEdit(memory);
        return result;
    }

    /**
     * @Method memoryDel
     * @Date 2019/1/24
     * @TODO 删除回忆录
     */
    @RequestMapping(value = "/memoryDel", method = RequestMethod.POST)
    @ResponseBody
    public Result memoryDel(Memory memory, HttpServletRequest request){
        Result result = memoryService.memoryDel(memory);
        return result;
    }

    /**
     * @Method messageAdd
     * @Date 2019/1/24
     * @TODO 添加语录
     */
    @RequestMapping(value = "/messageAdd", method = RequestMethod.POST)
    @ResponseBody
    public Result messageAdd(Message message, HttpServletRequest request){
        HttpSession session = request.getSession();
        String mid = (String) session.getAttribute("uid");
        Manager manager = new Manager();
        manager.setMid(mid);
        message.setManager(manager);

        Result result = messageService.messageAdd(message);
        return result;
    }

    /**
     * @Method messageDel
     * @Date 2019/1/24
     * @TODO 删除语录
     */
    @RequestMapping(value = "/messageDel", method = RequestMethod.POST)
    @ResponseBody
    public Result messageDel(Message message, HttpServletRequest request){
        Result result = messageService.messageDel(message);
        return result;
    }

    /**
     * @Method mTypeAdd
     * @Date 2019/1/24
     * @TODO 添加回忆录类别
     */
    @RequestMapping(value = "/mtypeAdd", method = RequestMethod.POST)
    @ResponseBody
    public Result mtypeAdd(MType mType, HttpServletRequest request){
        Result result = memoryService.mtypeAdd(mType);
        return result;
    }

    /**
     * @Method mTypeEdit
     * @Date 2019/1/24
     * @TODO 修改类别
     */
    @RequestMapping(value = "/mtypeEdit", method = RequestMethod.POST)
    @ResponseBody
    public Result mtypeEdit(MType mType, HttpServletRequest request){
        Result result = memoryService.mtypeEdit(mType);
        return result;
    }

    /**
     *
     * @param mType
     * @param request
     * @return
     * @TODO 删除回忆录类别
     */
    @RequestMapping(value = "/mtypeDel", method = RequestMethod.POST)
    @ResponseBody
    public Result mtypeDel(MType mType, HttpServletRequest request){
        Result result = memoryService.mtypeDel(mType);
        return result;
    }

    /**
     * @Method pTypeAdd
     * @Date 2019/1/24
     * @TODO 添加回忆录类别
     */
    @RequestMapping(value = "/ptypeAdd", method = RequestMethod.POST)
    @ResponseBody
    public Result ptypeAdd(PType pType, HttpServletRequest request){
        Result result = galleryService.ptypeAdd(pType);
        return result;
    }

    /**
     * @Method pTypeEdit
     * @Date 2019/1/24
     * @TODO 修改类别
     */
    @RequestMapping(value = "/ptypeEdit", method = RequestMethod.POST)
    @ResponseBody
    public Result ptypeEdit(PType pType, HttpServletRequest request){
        Result result = galleryService.ptypeEdit(pType);
        return result;
    }

    /**
     *
     * @param pType
     * @param request
     * @return
     * @TODO 删除回忆录类别
     */
    @RequestMapping(value = "/ptypeDel", method = RequestMethod.POST)
    @ResponseBody
    public Result ptypeDel(PType pType, HttpServletRequest request){
        Result result = galleryService.ptypeDel(pType);
        return result;
    }


    @RequestMapping(value = "/memoryPhoto")
    @ResponseBody
    public String memoryPhoto(MultipartFile[] myFileName, HttpServletRequest request) throws IllegalStateException, IOException {

        JSONObject json = new JSONObject();
        long  startTime = System.currentTimeMillis()/1000;

        JSONArray data = new JSONArray();
        for(MultipartFile muFile:myFileName){
            String fileOldName = muFile.getOriginalFilename();
            String fileType = fileOldName.substring(fileOldName.lastIndexOf("."), fileOldName.length());
            String filepath = Constant.memoryPath + startTime + fileType;
            muFile.transferTo(new File(filepath));
            data.add(URLEnum.URL_MEMORY_IMAGE.getUrl() + startTime + fileType);
            startTime++;
        }

        json.put("errno", 0);
        json.put("data", data);
        return json.toString();
    }

    @RequestMapping(value = "/galleryUpload")
    @ResponseBody
    public Result galleryAdd(@RequestParam(value="file",required=false)MultipartFile multipartFile){
        if(multipartFile == null){
            return Result.resultFactory(Feedback.FEEDBACK_WITHOUT_LOGIN);
        }
        // 上传文件名
        String fileName = multipartFile.getOriginalFilename();
        // 上传文件的文件类别
        String fileType = fileName.substring(fileName.lastIndexOf("."), fileName.length());
        // 上传文件时间
        Date update = new Date();
        // 上传文件的PID
        String filePid = String.valueOf(update.getTime());
        // 上传文件存放的文件名称
        String fileNewName = filePid + fileType;
        // 上传文件存放的真实路径
        String filePath = Constant.galleryPath + fileNewName;
        // 上传文件相对路径
        String galleryPath = Constant.galleryImage + fileNewName;
        try {
            multipartFile.transferTo(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Result result = Result.resultFactory(Feedback.FEEDBACK_SUCCESS);
        Photo photo = new Photo();
        photo.setPid(filePid);
        photo.setSrc(galleryPath);
        photo.setCtime(update);

        result.setObj(photo);
        return result;
    }

    @RequestMapping(value = "/galleryAdd", method = RequestMethod.POST)
    @ResponseBody
    public Result galleryAdd(Photo photo, HttpServletRequest request){
        logger.info("/api/manager/galleryAdd");
        Result result = galleryService.photoAdd(photo);
        return result;
    }

    @RequestMapping(value = "/galleryEdit", method = RequestMethod.POST)
    @ResponseBody
    public Result galleryEdit(Photo photo, HttpServletRequest request){
        logger.info("/api/manager/galleryEdit");
        Result result = galleryService.photoEdit(photo);
        return result;
    }

    @RequestMapping(value = "/galleryDel", method = RequestMethod.POST)
    @ResponseBody
    public Result galleryDel(Photo photo, HttpServletRequest request){
        logger.info("/api/manager/galleryDel");
        Result result = galleryService.photoDel(photo);
        return result;
    }

}
