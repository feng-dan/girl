package com.fengdan.girl.repository;

import com.fengdan.girl.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * repository
 *
 * @Author ibout
 * @Create 2018-05-24 on 11:29
 */
@Repository
public interface GirlRepository extends JpaRepository<Girl, Integer>, PagingAndSortingRepository<Girl, Integer> {

    /**
     * 通过年龄查询
     *
     * @param age
     * @return
     */
    List<Girl> findByAge(Integer age);
}
