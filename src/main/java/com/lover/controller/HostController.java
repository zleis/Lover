package com.lover.controller;

import com.lover.entity.*;
import com.lover.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZLei on 2018/12/2.
 */
@Controller
@RequestMapping("/v/host")
public class HostController{
    private static Logger logger = Logger.getLogger(HostController.class);

    // 页面服务
    @Autowired
    private HostService hostService;

    @Autowired
    private AnswerService answerService;

    @Autowired
    private MemoryService memoryService;

    @Autowired
    private GalleryService galleryService;

    @Autowired
    private MessageService messageService;

    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request){
        logger.info("/index");
        ModelAndView mv = new ModelAndView( "host/index");

        mv.addObject("message", hostService.getMainList());

        return mv;
    }

    /** ---------- 简答 ---------------- */

    /**
     * requestMap
     * key          mean
     * page    |  the number of page
     *
     * @return 简答页面
     */
    @RequestMapping(value = "/answer/{page}" ,method = RequestMethod.GET)
    public ModelAndView answer(@PathVariable int page){
        logger.info("/answer");
        ModelAndView mv = new ModelAndView("host/answer");

        List<Answer> answers = answerService.answerList(page);
        int answerNumber = answerService.answerNumber();
        int answerPageNumber = (int)Math.ceil((double)answerNumber/(double)Constant.ANSWER_PAGE_NUMBER);

        mv.addObject("page", page);
        mv.addObject("answers", answers);
        mv.addObject("ansNumber", answerNumber);
        mv.addObject("ansPageNumber", answerPageNumber);
        mv.addObject("menu", hostService.getMenuList());
        mv.addObject("pageList", getPageList(answerPageNumber));

        return mv;
    }

    @RequestMapping(value = "/answerItem/{aid}", method = RequestMethod.GET)
    public ModelAndView answerItem(@PathVariable String aid){
        logger.info("/answerItem");
        ModelAndView mv = new ModelAndView("host/answerItem");
        logger.info(aid);
        Answer answer = answerService.answerFind(aid);
        logger.info(answer.toString());
        mv.addObject("answer",answer);
        mv.addObject("menu", hostService.getMenuList());

        return mv;
    }

    /**------------------------- 回忆录 ------------------------*/
    /**
     *
     * @return
     * @Todo 回忆录记录
     */
    @RequestMapping(value = "/memoirs/{type}/{page}", method = RequestMethod.GET)
    public ModelAndView memoirs(@PathVariable int type, @PathVariable int page){
        logger.info("/memoirs");
        ModelAndView mv = new ModelAndView("host/memoirs");

        int mNum = memoryService.memoryLength(type);
        List<Memory> memories = memoryService.memoryListByType(type, page * Constant.MEMORY_PAGE_NUMBER, Constant.MEMORY_PAGE_NUMBER);
        int pageNum = (int)Math.ceil((double)mNum/(double)Constant.MEMORY_PAGE_NUMBER);
        mv.addObject("mNum", mNum);
        mv.addObject("type", type);
        mv.addObject("page", page);
        mv.addObject("pageNum", pageNum);
        mv.addObject("memories", memories);
        mv.addObject("menu", hostService.getMenuList());
        mv.addObject("mtype", hostService.getMTypeList());
        mv.addObject("pageList", getPageList(pageNum));

        return mv;
    }

    @RequestMapping(value = "/memories/{code}", method = RequestMethod.GET)
    public ModelAndView memoryItem(@PathVariable String code){
        logger.info("/memories/" + code);
        ModelAndView mv = new ModelAndView("host/memoryItem");
        Memory memory = memoryService.memoryFind(code);
        logger.info(memory.toString());
        mv.addObject("memory", memory);
        mv.addObject("menu", hostService.getMenuList());
        return mv;
    }


    /** ------------------- 照片墙 ----------------------*/
    @RequestMapping(value = "/gallery/{type}/{page}", method = RequestMethod.GET)
    public ModelAndView gallery(@PathVariable int type, @PathVariable int page){
        logger.info("/gallery");
        ModelAndView mv = new ModelAndView("host/gallery");

        int photoNum = galleryService.photoNumber(type);
        int pageNum = (int)Math.ceil((double)photoNum/(double)Constant.PHOTO_PAGE_NUMBER);

        mv.addObject("type", type);
        mv.addObject("page", page);
        mv.addObject("pageNum",pageNum);
        mv.addObject("photoNum", photoNum);
        mv.addObject("pageList", getPageList(pageNum));
        mv.addObject("photos", galleryService.photoList(type, page));
        mv.addObject("menu", hostService.getMenuList());
        mv.addObject("ptype", hostService.getPTypeList());
        return mv;
    }
    @RequestMapping(value = "/galleryItem/{code}", method = RequestMethod.GET)
    public ModelAndView galleryItem(@PathVariable String code){
        logger.info("/galleryItem/" + code);
        ModelAndView mv = new ModelAndView("host/galleryItem");

        mv.addObject("photo", galleryService.photoFind(code));
        mv.addObject("menu", hostService.getMenuList());
        return mv;
    }

    /** ------------------------ 留言板 -------------------------------- */
    @RequestMapping(value = "/message/{page}")
    public ModelAndView messageList(@PathVariable int page){
        logger.info("/message/" + page);
        ModelAndView mv = new ModelAndView("host/message");
        int msgNumber = messageService.messageNum();
        int msgPageNumber = (int)Math.ceil((double)msgNumber/(double)Constant.MESSAGE_PAGE_NUMBER);

        mv.addObject("page", page);
        mv.addObject("pageNum", msgPageNumber);
        mv.addObject("messageNum", msgNumber);
        mv.addObject("message", messageService.messageList(page));
        mv.addObject("pageList", getPageList(msgPageNumber));
        mv.addObject("menu", hostService.getMenuList());
        return mv;
    }


    private List<Integer> getPageList(int length){
        List<Integer> pageList = new ArrayList<>();
        for(int i = 0; i < length; i++){
            pageList.add(i);
        }
        return pageList;
    }



}
