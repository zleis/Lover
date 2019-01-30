package com.lover.service.imp;

import com.lover.dao.PTypeDao;
import com.lover.dao.PhotoDao;
import com.lover.entity.*;
import com.lover.service.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class GalleryServiceImp implements GalleryService {

    @Autowired
    private PhotoDao photoDao;
    @Autowired
    private PTypeDao pTypeDao;

    @Override
    public Result ptypeAdd(PType pType) {
        pType.init();
        pType.format();
        pTypeDao.ptypeAdd(pType);
        return Result.resultFactory(Feedback.FEEDBACK_SUCCESS);
    }

    @Override
    public Result ptypeDel(PType pType) {
        pTypeDao.ptypeDel(pType);
        return Result.resultFactory(Feedback.FEEDBACK_SUCCESS);
    }

    @Override
    public Result ptypeEdit(PType pType) {
        pType.format();
        pTypeDao.ptypeEdit(pType);
        return Result.resultFactory(Feedback.FEEDBACK_SUCCESS);
    }

    @Override
    public PType ptypeFind(int pid) {
        PType pType = pTypeDao.ptypeFind(pid);
        return pType;
    }

    @Override
    public Result photoAdd(Photo photo) {
        photo.init();
        photo.format();
        System.out.println(photo.toString());
        photoDao.photoAdd(photo);
        return Result.resultFactory(Feedback.FEEDBACK_SUCCESS);
    }

    @Override
    public Result photoDel(Photo photo) {
        photoDao.photoDel(photo);
        return Result.resultFactory(Feedback.FEEDBACK_SUCCESS);
    }

    @Override
    public Result photoEdit(Photo photo) {
        photo.format();
        photoDao.photoEdit(photo);
        return Result.resultFactory(Feedback.FEEDBACK_SUCCESS);
    }


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
