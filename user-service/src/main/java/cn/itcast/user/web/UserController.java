package cn.itcast.user.web;

import cn.itcast.user.config.ConfigHotUpdate;
import cn.itcast.user.pojo.User;
import cn.itcast.user.service.UserService;
import javafx.scene.input.DataFormat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/user")
//@RefreshScope
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${pattern.dateformat}")
    private String datePattern;


    @Autowired
    private ConfigHotUpdate configHotUpdate;

    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) {
        return userService.queryById(id);
    }

    @GetMapping
    public String configHotUpdateTEst(){
        SimpleDateFormat sdf = new SimpleDateFormat(configHotUpdate.getDateformat());
        return sdf.format(new Date(System.currentTimeMillis()));
    }
}
