package com.fengdan.girl.controller;

import com.fengdan.girl.domain.Girl;
import com.fengdan.girl.service.GirlService;
import com.fengdan.girl.service.TransactionalService;
import lombok.extern.log4j.Log4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author ibout
 * @Create 2018-05-24 on 11:18
 */
@Log4j
@RestController
@RequestMapping("/girl")
public class GirlController {

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    private final GirlService girlService;

    private final TransactionalService transactionalService;

    @Autowired
    public GirlController(GirlService girlService, TransactionalService transactionalService) {
        this.girlService = girlService;
        this.transactionalService = transactionalService;
    }

    /**
     * 事物栗子
     */
    @PostMapping("/girls/two")
    public void insertTwo() {
        transactionalService.insertTwo();
    }


    /**
     * 查询所有用户列表
     *
     * @return
     */
    @GetMapping("/girls")
    public List<Girl> findAll() {
        logger.info("findAll");
        return girlService.findAll();
    }

    /**
     * 新增用户
     *
     * @param girl
     * @return
     */
    @PostMapping("/girls")
    public Girl addGirl(@Valid @RequestBody Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.info(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        return girlService.saveGirl(girl);
    }

    /**
     * 通过girlId查询用户
     *
     * @param girlId
     * @return
     */
    @GetMapping("/girls/{id}")
    public Girl findOne(@PathVariable("id") Integer girlId) {
        return girlService.findOne(girlId);
    }

    /**
     * 更新一个用户
     *
     * @param girl
     * @return
     */
    @PutMapping("/girls/{id}")
    public Girl updateGirl(Girl girl) {
        return girlService.updateGirl(girl);
    }

    /**
     * 删除一个用户
     *
     * @param girlId
     */
    @DeleteMapping("/girls/{id}")
    public void deleteGirl(@PathVariable(value = "id") Integer girlId) {
        girlService.deleteGirl(girlId);
    }

    @GetMapping("/girls/age/{age}")
    public List<Girl> findByListAge(@PathVariable(value = "age") Integer grilAge) {
        return girlService.findByAge(grilAge);
    }
}
