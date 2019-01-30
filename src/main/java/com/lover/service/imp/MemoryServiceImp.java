package com.lover.service.imp;

import com.lover.dao.MTypeDao;
import com.lover.dao.MemoryDao;
import com.lover.entity.*;
import com.lover.service.MemoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class MemoryServiceImp implements MemoryService {

    @Autowired
    private MemoryDao memoryDao;

    @Autowired
    private MTypeDao mTypeDao;
    @Override
    public List<Memory> memoryListByType(int type, int start, int length) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", type);
        hashMap.put("start", start);
        hashMap.put("length", length);
        if(type == Constant.MEMORY_ALL_TYPE){
            return memoryDao.memoryList(hashMap);
        }else{
            return memoryDao.memoryListByType(hashMap);
        }
    }

    @Override
    public Memory memoryFind(String mid) {
        return memoryDao.memoryFind(mid);
    }

    @Override
    public int memoryLength(int type) {
        if(type == Constant.MEMORY_ALL_TYPE){
            return memoryDao.memoryNum();
        }else{
            return memoryDao.memoryNumByType(type);
        }

    }

    @Override
    public Result memoryAdd(Memory memory) {
        memory.init();
        memory.format();
        memoryDao.memoryAdd(memory);
        return Result.resultFactory(Feedback.FEEDBACK_SUCCESS);
    }

    @Override
    public List<Memory> momoryListType(int page) {
        HashMap hashMap = new HashMap();
        hashMap.put("start", page * Constant.MEMORY_PAGE_NUMBER);
        hashMap.put("length", Constant.MEMORY_PAGE_NUMBER);
        return memoryDao.memoryListType(hashMap);
    }

    @Override
    public Result memoryDel(Memory memory) {
        memoryDao.memoryDel(memory);
        return Result.resultFactory(Feedback.FEEDBACK_SUCCESS);
    }

    @Override
    public Result memoryEdit(Memory memory) {
        memoryDao.memoryEdit(memory);
        return Result.resultFactory(Feedback.FEEDBACK_SUCCESS);
    }

    @Override
    public Result mtypeAdd(MType mType) {
        mType.init();
        mType.format();
        mTypeDao.mtypeAdd(mType);
        return Result.resultFactory(Feedback.FEEDBACK_SUCCESS);
    }

    @Override
    public Result mtypeDel(MType mType) {
        mTypeDao.mtypeDel(mType);
        return Result.resultFactory(Feedback.FEEDBACK_SUCCESS);
    }

    @Override
    public Result mtypeEdit(MType mType) {
        mType.format();
        mTypeDao.mtypeEdit(mType);
        return Result.resultFactory(Feedback.FEEDBACK_SUCCESS);
    }

    @Override
    public MType mtypeFind(int mid) {
        MType mType = mTypeDao.mtypeFind(mid);
        return mType;
    }
}
