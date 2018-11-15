package com.fengdan.girl.service;

import com.fengdan.girl.domain.Girl;

import java.util.List;

/**
 * 用户service
 *
 * @Author ibout
 * @Create 2018-05-24 on 11:30
 */

public interface GirlService {
    /**
     * 查询用户列表
     *
     * @return
     */
    List<Girl> findAll();

    /**
     * 新增用户
     *
     * @param girl
     * @return
     */
    Girl saveGirl(Girl girl);

    /**
     * 通过girlId查询用户
     *
     * @param girlId
     * @return
     */
    Girl findOne(Integer girlId);


    /**
     * 更新Girl用户
     *
     * @param girl
     * @return
     */
    Girl updateGirl(Girl girl);


    /**
     * 删除一个用户
     *
     * @param girlId
     */
    void deleteGirl(Integer girlId);

    /**
     * 通过年龄查询用户
     *
     * @return
     */
    List<Girl> findByAge(Integer age);
}
