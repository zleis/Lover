package com.lover.service.imp;

import com.lover.dao.MemoryDao;
import com.lover.entity.Constant;
import com.lover.entity.Memory;
import com.lover.service.MemoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class MemoryServiceImp implements MemoryService {

    @Autowired
    private MemoryDao memoryDao;
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
}
