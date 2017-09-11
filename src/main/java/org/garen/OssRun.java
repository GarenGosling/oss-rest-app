package org.garen;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.garen.oss.service.FileManager;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by Administrator on 2017/8/23.
 */
@Controller
@SpringBootApplication
@MapperScan("org.garen.oss.mybatis.mapper")
public class OssRun {

    @Autowired
    private FileManager userManager;

//    @RequestMapping("/")
//    @ResponseBody
//    String home(){
//        return "Hello world!";
//    }

    /**
     * 此方法用来测试DAO层代码是否可以顺利执行
     * @return
     * @throws JsonProcessingException
     * @see /sql/user.sql
     * @see /resources/application-local.yml
     * 改一下datasource，然后执行user.sql建个表，访问http://localhost:9090/list测试一下
     */
    @RequestMapping("/list")
    @ResponseBody
    String list() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(userManager.findAll());
    }

    public static void main(String[] args) {
        SpringApplication.run(OssRun.class, args);
        System.out.println("修改点东西，测试git");
    }

}
