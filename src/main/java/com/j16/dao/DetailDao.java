package com.j16.dao;

import com.j16.pojo.Detail;

import java.util.List;

public interface DetailDao {


    /**
     * 获取所有的鲜花
     * @return
     */
    List<Detail> showFlowers();


    /**
     * 根据花的品种获取花
     * @return
     */
    List<Detail> getFlowers(int typeId);


    int addDetail(Detail detail);



}
