package com.fengdan.girl.service.impl;

import com.fengdan.girl.domain.Girl;
import com.fengdan.girl.repository.GirlRepository;
import com.fengdan.girl.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * impl
 *
 * @Author ibout
 * @Create 2018-05-24 on 11:33
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class GirlServiceImpl implements GirlService {

    private final GirlRepository girlRepository;

    @Autowired
    public GirlServiceImpl(GirlRepository girlRepository) {
        this.girlRepository = girlRepository;
    }

    @Override
    public List<Girl> findAll() {
        List<Girl> all = girlRepository.findAll();
        return all;
    }

    @Override
    public Girl saveGirl(Girl girl) {
        return girlRepository.save(girl);
    }

    @Override
    public Girl findOne(Integer girlId) {
        return girlRepository.findOne(girlId);
    }

    @Override
    public Girl updateGirl(Girl girl) {
        return girlRepository.save(girl);
    }

    @Override
    public void deleteGirl(Integer girlId) {
        girlRepository.delete(girlId);
    }

    @Override
    public List<Girl> findByAge(Integer age) {
        return girlRepository.findByAge(age);
    }
}
