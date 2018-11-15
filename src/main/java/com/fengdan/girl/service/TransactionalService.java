package com.fengdan.girl.service;

import com.fengdan.girl.domain.Girl;
import com.fengdan.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 事物栗子
 *
 * @Author ibout
 * @Create 2018-05-24 on 12:50
 */
@Service
public class TransactionalService {

    private final GirlRepository girlRepository;

    @Autowired
    public TransactionalService(GirlRepository girlRepository) {
        this.girlRepository = girlRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setAge(19);
        girlA.setName("阿姨");
        girlRepository.save(girlA);


        Girl girlB = new Girl();
        girlB.setAge(21);
        girlB.setName("李斯SDFSFSADFASDFASFSA");
        girlRepository.save(girlB);

    }
}
