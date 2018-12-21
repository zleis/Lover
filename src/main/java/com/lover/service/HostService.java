package com.lover.service;

import com.lover.entity.MType;
import com.lover.entity.Main;
import com.lover.entity.Menu;
import com.lover.entity.PType;

import java.util.List;

public interface HostService {

    /**
     * @return 主页上的注释文字
     */
    public List<Main> getMainList();

    /**
     * @return 菜单列表
     */
    public List<Menu> getMenuList();

    /**
     * @return 照片分类列表
     */
    public List<PType> getPTypeList();

    /**
     *
     * @return 回忆录类别
     */
    public List<MType> getMTypeList();

}
