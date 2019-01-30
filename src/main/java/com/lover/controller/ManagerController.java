package com.lover.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lover.entity.*;
import com.lover.service.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/v/manager")
public class ManagerController {

    private static Logger logger = Logger.getLogger(ManagerController.class);

    @Autowired
    private AnswerService answerService;

    @Autowired
    private HostService hostService;

    @Autowired
    private MemoryService memoryService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private GalleryService galleryService;

    /**
     * @Method login
     * @Date 2019/1/20
     * @TODO 登录功能
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(){
        logger.info("/v/manager/login");
        ModelAndView mv = new ModelAndView("manager/login");
        mv.addObject("loginURL", URLEnum.URL_LOGIN.getUrl());
        return mv;
    }

    /**
     * @Method index
     * @Date 2019/1/20
     * @TODO 首页功能
     */
    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request){
        logger.info("/v/manager/index");
        ModelAndView mv = new ModelAndView("manager/index");
        HttpSession session = request.getSession();
        List<Bar> list = barList();
        mv.addObject("menu", list);
        mv.addObject("name",session.getAttribute("name"));
        mv.addObject("photo",session.getAttribute("photo"));
        mv.addObject("logoutURL", URLEnum.URL_LOGOUT.getUrl());
        return mv;
    }

    /**
     * @Method welcome
     * @Date 2019/1/20
     * @TODO 欢迎页面
     */
    @RequestMapping("/welcome")
    public ModelAndView welcome(){
        logger.info("/welcome");
        ModelAndView mv = new ModelAndView("welcome");
        mv.addObject("menu",barList());
        return mv;
    }

    @RequestMapping(value = "/infoEdit", method = RequestMethod.GET)
    public ModelAndView infoEdit(){
        logger.info("/infoEdit");
        ModelAndView mv = new ModelAndView("manager/infoEdit");
        mv.addObject("url", URLEnum.URL_INFO_EDIT.getUrl());

        return mv;
    }


    /*---------------------- 简答页面 ------------------------------*/
    /**
     * @Method answerAdd
     * @Date 2019/1/20
     * @TODO 添加简答页面
     */
    @RequestMapping("/answerAdd")
    public ModelAndView answerAdd(){
        logger.info("/answerAdd");
        ModelAndView mv = new ModelAndView("manager/answerAdd");
        mv.addObject("url", URLEnum.URL_ANSWER_ADD.getUrl());
        return mv;
    }

    /**
     * @Method answerList
     * @Date 2019/1/24
     * @TODO 简答列表
     */
    @RequestMapping("/answerList/{page}")
    public ModelAndView answerList(@PathVariable(value = "page") int page){
        logger.info("/answerList");
        ModelAndView mv = new ModelAndView("manager/answerList");
        List<Answer> answers = answerService.answerList(page);
        int answerNumber = answerService.answerNumber();
        int answerPageNumber = (int)Math.ceil((double)answerNumber/(double)Constant.ANSWER_PAGE_NUMBER);
        mv.addObject("page", page);
        mv.addObject("answers", answers);
        mv.addObject("delUrl",URLEnum.URL_ANSWER_DEL.getUrl());
        mv.addObject("ansNumber", answerNumber);
        mv.addObject("ansPageNumber", answerPageNumber);
        mv.addObject("pageList", getPageList(answerPageNumber));
        return mv;
    }

    /**
     * @Method answerEdit
     * @Date 2019/1/24
     * @TODO 修改简答
     */
    @RequestMapping(value = "/answerEdit/{aid}", method = RequestMethod.GET)
    public ModelAndView answerEdit(@PathVariable(value = "aid") String aid){
        logger.info("/answerEdit/" + aid);
        ModelAndView mv = new ModelAndView("manager/answerEdit");
        Answer answer = answerService.answerFind(aid);
        mv.addObject("answer", answer);
        mv.addObject("url",URLEnum.URL_ANSWER_EDIT.getUrl());
        mv.addObject("aid", aid);
        return mv;
    }

    /*** --------------------------------- 回忆录 -------------------------------*/
    /**
     * @Method momoryLists
     * @Date 2019/1/24
     * @TODO 回忆录
     */
    @RequestMapping(value = "/memoryList/{page}", method = RequestMethod.GET)
    public ModelAndView memoryList(@PathVariable(value = "page")int page){
        logger.info("/memoryList/" + page);
        int memoryLength = memoryService.memoryLength(Constant.MEMORY_ALL_TYPE);
        int memoryPageNumber = (int)Math.ceil((double)memoryLength/(double)Constant.MEMORY_PAGE_NUMBER);
        List<Memory> memories = memoryService.momoryListType(page);
        ModelAndView mv = new ModelAndView("manager/memoryList");
        mv.addObject("memorys", memories);
        mv.addObject("delURL", URLEnum.URL_MEMORY_DEL.getUrl());
        mv.addObject("curPage", page);
        mv.addObject("allPage",memoryPageNumber);
        mv.addObject("memoryNum",memoryLength);
        mv.addObject("pageList", getPageList(memoryPageNumber));
        return mv;
    }

    /**
     * @Method memoryAdd
     * @Date 2019/1/26
     * @TODO 添加回忆录
     */
    @RequestMapping(value = "/memoryAdd",method = RequestMethod.GET)
    public ModelAndView memoryAdd(){
        logger.info("/memoryAdd");
        ModelAndView mv = new ModelAndView("manager/memoryAdd");
        mv.addObject("url",URLEnum.URL_MEMORY_ADD.getUrl());
        mv.addObject("mtype",hostService.getMTypeList());
        return mv;
    }

    /**
     * @Method memoryEdit
     * @Date 2019/1/26
     * @TODO 修改回忆录
     */
    @RequestMapping(value = "/memoryEdit/{mid}", method = RequestMethod.GET)
    public ModelAndView memoryEdit(@PathVariable(value = "mid") String mid){
        logger.info("/memoryEdit/" + mid);
        Memory memory = memoryService.memoryFind(mid);
        ModelAndView mv = new ModelAndView("manager/memoryEdit");
        mv.addObject("mid", mid);
        mv.addObject("memory", memory);
        mv.addObject("url", URLEnum.URL_MEMORY_EDIT.getUrl());
        mv.addObject("mtype",hostService.getMTypeList());

        return mv;
    }

    /**--------------------------- 语录 --------------------------------------------------*/
    /**
     * @Method messageAdd
     * @Date 2019/1/27
     * @TODO 添加留言
     */
    @RequestMapping(value = "/messageAdd", method = RequestMethod.GET)
    public ModelAndView messageAdd(){
        logger.info("/messageAdd");
        ModelAndView mv = new ModelAndView("manager/messageAdd");
        mv.addObject("url",URLEnum.URL_MESSAGE_ADD.getUrl());
        return mv;
    }

    /**
     * @Method messageList
     * @Date 2019/1/27
     * @TODO 留言板记录
     */
    @RequestMapping(value = "/messageList/{page}", method = RequestMethod.GET)
    public ModelAndView messageList(@PathVariable(value = "page")int page){
        logger.info("/messageList/" + page);
        List<Message> messages = messageService.messageList(page);
        int msgLength = messageService.messageNum();
        int pageNum = (int)Math.ceil((double)msgLength/(double)Constant.MESSAGE_PAGE_NUMBER);
        ModelAndView mv = new ModelAndView("manager/messageList");
        mv.addObject("messages", messages);
        mv.addObject("delURL",URLEnum.URL_MESSAGE_DEL.getUrl());
        mv.addObject("curPage", page);
        mv.addObject("msgNum",msgLength);
        mv.addObject("pageNum",pageNum);
        mv.addObject("pageList", getPageList(pageNum));
        return mv;
    }

    @RequestMapping(value = "/mtype", method = RequestMethod.GET)
    public ModelAndView mtype(){
        logger.info("/mtype");
        List<MType> mTypes = hostService.getMTypeList();
        ModelAndView mv = new ModelAndView("manager/mtypeList");
        mv.addObject("mtypes", mTypes);
        mv.addObject("delURL", URLEnum.URL_MTYPE_DEL.getUrl());

        return mv;
    }

    @RequestMapping(value = "/mtypeAdd", method = RequestMethod.GET)
    public ModelAndView mtypeAdd(){
        logger.info("/mtypeAdd");
        ModelAndView mv = new ModelAndView("manager/mtypeAdd");
        mv.addObject("url", URLEnum.URL_MTYPE_ADD.getUrl());
        return mv;
    }

    @RequestMapping(value = "/mtypeEdit/{mid}", method = RequestMethod.GET)
    public ModelAndView mtypeEdit(@PathVariable("mid")int mid){
        logger.info("/mtypeEdit");
        MType mType = memoryService.mtypeFind(mid);
        ModelAndView mv = new ModelAndView("manager/mtypeEdit");
        mv.addObject("mid",mid);
        mv.addObject("mtype", mType);
        mv.addObject("url", URLEnum.URL_MTYPE_EDIT.getUrl());
        return mv;
    }

    @RequestMapping(value = "/ptype", method = RequestMethod.GET)
    public ModelAndView ptype(){
        logger.info("/ptype");
        List<PType> pTypes = hostService.getPTypeList();
        ModelAndView mv = new ModelAndView("manager/ptypeList");
        mv.addObject("ptypes",pTypes);
        mv.addObject("delURL", URLEnum.URL_PTYPE_DEL.getUrl());
        return mv;
    }

    @RequestMapping(value = "/ptypeAdd", method = RequestMethod.GET)
    public ModelAndView ptypeAdd(){
        logger.info("/ptypeAdd");
        ModelAndView mv = new ModelAndView("manager/ptypeAdd");
        mv.addObject("url", URLEnum.URL_PTYPE_ADD.getUrl());
        return mv;
    }

    @RequestMapping(value = "/ptypeEdit/{pid}", method = RequestMethod.GET)
    public ModelAndView ptypeEdit(@PathVariable("pid")int pid){
        logger.info("/ptypeEdit");
        PType pType = galleryService.ptypeFind(pid);
        ModelAndView mv = new ModelAndView("manager/ptypeEdit");
        mv.addObject("pid", pid);
        mv.addObject("ptype", pType);
        mv.addObject("url", URLEnum.URL_PTYPE_EDIT.getUrl());
        return mv;
    }

    @RequestMapping(value = "/galleryAdd", method = RequestMethod.GET)
    public ModelAndView galleryAdd(){
        logger.info("/galleryAdd");
        List<PType> pTypes = hostService.getPTypeList();
        ModelAndView mv = new ModelAndView("manager/galleryAdd");
        mv.addObject("ptypes", pTypes);
        mv.addObject("upURL", URLEnum.URL_GALLERY_UPLOAD.getUrl());
        mv.addObject("url", URLEnum.URL_GALLERY_ADD.getUrl());
        return mv;
    }

    @RequestMapping(value = "/galleryList/{page}", method = RequestMethod.GET)
    public ModelAndView galleryList(@PathVariable("page")int page){
        logger.info("/v/manager/galleryList/" + page);
        List<Photo> photos = galleryService.photoList(Constant.PHOTO_ALL_TYPE,page);

        int photoNum = galleryService.photoNumber(Constant.PHOTO_ALL_TYPE);
        int pageNum = (int)Math.ceil((double)photoNum/(double)Constant.PHOTO_PAGE_NUMBER);

        ModelAndView mv = new ModelAndView("manager/galleryList");
        mv.addObject("page", page);
        mv.addObject("pageNum",pageNum);
        mv.addObject("photoNum", photoNum);
        mv.addObject("pageList", getPageList(pageNum));
        mv.addObject("photos", photos);
        mv.addObject("ptype", hostService.getPTypeList());
        mv.addObject("delURL", URLEnum.URL_GALLERY_DEL.getUrl());
        return mv;
    }

    @RequestMapping(value = "/galleryEdit/{pid}", method = RequestMethod.GET)
    public ModelAndView galleryEdit(@PathVariable("pid")String pid){
        logger.info("/v/manager/galleryEdit/" + pid);
        Photo photo = galleryService.photoFind(pid);
        List<PType> pTypes = hostService.getPTypeList();

        ModelAndView mv = new ModelAndView("manager/galleryEdit");
        mv.addObject("photo", photo);
        mv.addObject("ptypes", pTypes);
        mv.addObject("upURL", URLEnum.URL_GALLERY_UPLOAD.getUrl());
        mv.addObject("url", URLEnum.URL_GALLERY_EDIT.getUrl());
        mv.addObject("pid", pid);
        return mv;
    }


    /**
     * @Method barList
     * @Date 2019/1/18
     * @TODO 获取菜单列表
     */
    private List<Bar> barList(){
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        List<Bar> bars = new ArrayList<Bar>();
        File file = null;
        BufferedReader reader = null;
        StringBuilder sb = new StringBuilder();
        JSONObject json = null;
        try{
            file = resolver.getResource("classpath:static/config/bar.json").getFile();
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            String line;
            while ((line = reader.readLine()) != null){
                sb.append(line);
            }

            json = JSONObject.parseObject(sb.toString());

            Iterator<String> iterator = json.keySet().iterator();
            while (iterator.hasNext()){
                bars.add(jsonTOBar(json.getJSONObject(iterator.next())));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return bars;
    }

    public Bar jsonTOBar(JSONObject json){
        Bar bar = new Bar();
        bar.setName(json.getString("name"));
        bar.setIcon(json.getString("icon"));

        JSONObject child = json.getJSONObject("child");
        Iterator<String> iterable = child.keySet().iterator();
        while (iterable.hasNext()){
            BarItem barItem = new BarItem();
            String itemStr = iterable.next();
            JSONObject jsonItem = child.getJSONObject(itemStr);
            barItem.setName(jsonItem.getString("name"));
            barItem.setUrl(jsonItem.getString("url"));
            bar.addItem(barItem);
        }
        return bar;
    }

    private List<Integer> getPageList(int length){
        List<Integer> pageList = new ArrayList<>();
        for(int i = 0; i < length; i++){
            pageList.add(i);
        }
        return pageList;
    }

}
