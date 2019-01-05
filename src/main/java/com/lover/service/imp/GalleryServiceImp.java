package com.lover.service.imp;

import com.lover.dao.PhotoDao;
import com.lover.entity.Constant;
import com.lover.entity.Photo;
import com.lover.service.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class GalleryServiceImp implements GalleryService {

    @Autowired
    private PhotoDao photoDao;

    @Override
    public List<Photo> photoList(int type, int page) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", type);
        hashMap.put("start", page * Constant.PHOTO_PAGE_NUMBER);
        hashMap.put("length", Constant.PHOTO_PAGE_NUMBER);

        if(type == Constant.PHOTO_ALL_TYPE){
            return photoDao.photoList(hashMap);
        }else{
            return photoDao.photoListByType(hashMap);
        }
    }

    @Override
    public Photo photoFind(String pid) {
        return photoDao.photoFind(pid);
    }

    @Override
    public int photoNumber(int type) {
        if(type == Constant.PHOTO_ALL_TYPE){
            return photoDao.photoNumber();
        }else{
            return photoDao.photoNumberByType(type);
        }
    }
}
