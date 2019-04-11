package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;


@RestController
public class AuthController extends ControllerWithSession {
    @Autowired
    private UserMapper userMapper;

    private void setLogInUser(User user) {
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
    }

    private boolean hasLogin() {
        HttpSession session = request.getSession();
        return session.getAttribute("user") != null;
    }

    /**
     * @api {get} /login?username=xxx&password=xxx 登录
     * @apiGroup Authentication
     * @apiParam {string} username 用户名
     * @apiParam {string} password 密码
     * @apiSuccess {boolean} result 成功返回true，失败返回false
     * @apiSuccess {boolean} msg 附带消息
     * @apiSuccessExample {json} 成功消息样例
     * {"result":true,"msg":"successfully login!"}
     * @apiErrorExample {json} 失败消息样例
     * {"result":false,"msg":"You have already log in!"}
     */
    @RequestMapping("/login")
    public Object login(@RequestParam String username, @RequestParam String password) {
        HashMap<String, Object>json = new HashMap<>();

        User user = null;
        String msg;
        if(hasLogin()) {
            msg = "You have already log in!";
        }
        else {
            user = userMapper.checkUser(username, password);
            //如果登录成功，写入session
            if(user != null) {
                setLogInUser(user);
                msg = "successfully login!";
            }
            else {
                msg = "login failed! check your username and password!";
            }
        }
        json.put("result", user != null);
        json.put("msg", msg);
        return json;
    }

    /**
     * @api {get} /logout 注销登陆
     * @apiGroup Authentication
     * @apiSuccess {boolean} result 成功返回true，失败返回false
     * @apiSuccess {boolean} msg 附带消息
     * @apiSuccessExample {json} 成功消息样例
     * {"result":true,"msg":"successfully log out!"}
     * @apiErrorExample {json} 失败消息样例
     * {"result":false,"msg":"you haven't log in!"}
     */
    @RequestMapping("/logout")
    public Object logout() {
        HashMap<String, Object>json = new HashMap<>();
        boolean ok = false;
        String msg;
        if(hasLogin()) {
            setLogInUser(null);
            ok = true;
            msg = "successfully log out!";
        }
        else {
            msg = "you haven't log in!";
        }
        json.put("result", ok);
        json.put("msg", msg);
        return json;
    }

    /**
     * @api {get} /getCurUser 获取当前登录的用户
     * @apiGroup Authentication
     * @apiSuccess {Object} result 如果已登录返回一个User，否则返回空
     * @apiSuccessExample {json} 成功消息样例
     * {"id":1,"username":"wlx","name":null,"email":null}
     */
    @RequestMapping("/getCurUser")
    public Object getCurUser() {
        HttpSession session = request.getSession();
        return session.getAttribute("user");
    }

}
