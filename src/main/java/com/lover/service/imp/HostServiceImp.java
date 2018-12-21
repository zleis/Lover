package com.lover.service.imp;


import com.lover.dao.MTypeDao;
import com.lover.dao.MainDao;
import com.lover.dao.MenuDao;
import com.lover.dao.PTypeDao;
import com.lover.entity.MType;
import com.lover.entity.Main;
import com.lover.entity.Menu;
import com.lover.entity.PType;
import com.lover.service.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostServiceImp implements HostService {

    @Autowired
    private MainDao mainDao;

    @Autowired
    private MenuDao menuDao;

    @Autowired
    private MTypeDao mTypeDao;

    @Autowired
    private PTypeDao pTypeDao;


    @Override
    public List<Main> getMainList() {
        return mainDao.getMainList();
    }

    @Override
    public List<Menu> getMenuList() {
        return menuDao.getMenuList();
    }

    @Override
    public List<PType> getPTypeList() {
        return pTypeDao.getPTypeList();
    }

    @Override
    public List<MType> getMTypeList() {
        return mTypeDao.getMTypeList();
    }
}
