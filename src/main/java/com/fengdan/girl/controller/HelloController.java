package com.fengdan.girl.controller;

import com.fengdan.girl.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fengdan
 */
@RequestMapping("/sysUser")
@RestController
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;

    @GetMapping(value = {"/findOne", "/hi"})
    public String say() {
        return "username:" + girlProperties.getName() + " age:" + girlProperties.getAge() + "content:{" + girlProperties.getContent()+"}";
    }


}
