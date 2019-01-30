package com.lover.controller;

import com.lover.entity.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.*;


/**
 * Created by ZLei on 2018/11/12.
 */
@Controller
@RequestMapping("/Test")
public class Test {
    private final static Logger logger = LoggerFactory.getLogger(Test.class);

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping(value = "/index")
    public String testLog() {
        logger.info("test");
        logger.debug("test debug");
        logger.error("test error");
        return "test/index";
    }

    @RequestMapping(value = "/redis", method = RequestMethod.GET)
    @ResponseBody
    public void testRedis() {
        String  str = "string";//1.字符串
        List<String> list = new ArrayList<String>();//list
        list.add("0");
        list.add("中国");
        list.add("2");
        Set<String> set = new HashSet<String>();//set
        set.add("0");
        set.add("中国");
        set.add("2");
        Map<String, Object> map = new HashMap();//map
        map.put("key1", "str1");
        map.put("key2", "中国");
        map.put("key3", "str3");



        redisUtil.del("myStr","str");//删除数据


        //1.字符串操作
        redisUtil.set("str", str);
        redisUtil.expire("str", 120);//指定失效时间为2分钟
        String str1 = (String) redisUtil.get("str");
        System.out.println(str1);

        //2.list操作
        redisUtil.lSet("list", list);
        redisUtil.expire("list", 120);//指定失效时间为2分钟
        List<Object> list1 = redisUtil.lGet("list", 0, -1);
        System.out.println(list1);

        //3.set操作
        redisUtil.sSet("set", set);
        redisUtil.expire("set", 120);//指定失效时间为2分钟
        Set<Object> set1 = redisUtil.sGet("set");
        System.out.println(set1);


        //3.map操作
        redisUtil.hmset("map", map);
        redisUtil.expire("map", 120);//指定失效时间为2分钟
        Map<Object, Object> map1 = redisUtil.hmget("map");
        System.out.println(map1);



    }
}
