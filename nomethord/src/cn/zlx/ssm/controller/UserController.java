package cn.zlx.ssm.controller;

import cn.zlx.ssm.entity.User;
import cn.zlx.ssm.exception.MyException;
import cn.zlx.ssm.service.UserService;
import cn.zlx.ssm.service.imp.UserServiceImpl;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/login")
    public String Login(User user,HttpServletRequest request) throws Exception {
        boolean b= userService.findUser(user);
        if(b){
            request.getSession().setAttribute("userphone",user.getUserphone());
            return "mainui";
        }
       return "passworderror";

    }

    @RequestMapping(value = "/regist", method = { RequestMethod.POST}   )
    //在需要校验的pojo前边添加@Validated，在需要校验的pojo后边添加BindingResult bindingResult接收校验出错信息
    //注意：@Validated和BindingResult bindingResult是配对出现，并且形参顺序是固定的（一前一后）。
    public String regist(Model model, @Validated User user, BindingResult bindingResult){
        // 获取校验错误信息
        if (bindingResult.hasErrors()) {
            // 输出错误信息
            List<ObjectError> allErrors = bindingResult.getAllErrors();

            for (ObjectError objectError : allErrors) {
                // 输出错误信息
                System.out.println(objectError.getDefaultMessage());

            }
            // 将错误信息传到页面
            model.addAttribute("allErrors", allErrors);


            //可以直接使用model将提交pojo回显到页面
            model.addAttribute("user", user);

            // 出错重新到商品修改页面
            return "regist";
        }

        if(userService.addUser(user)){
            return "registsuccess";
        }

        return "regist";
    }
    @RequestMapping("/loginout")
    public String loginout(User user, HttpServletRequest request){
        request.getSession().invalidate();
        return "mainui";
    }

}
