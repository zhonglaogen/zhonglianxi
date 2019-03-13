package cn.zlx.ssm.controller;

import cn.zlx.ssm.entity.Allhouse;
import cn.zlx.ssm.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class HouseController {
    @Autowired
    private HouseService houseService;


    @RequestMapping("allhouse")
    public String findAllHouse(HttpServletRequest httpServletRequest){
        List<Allhouse> list= houseService.findHouse();
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("allHouse",list);
        return "mianui";
    }
    @RequestMapping("inserthouse")
    public String insertHouse(Allhouse allhouse,MultipartFile pic_house) throws IOException {
        String originFilename=pic_house.getOriginalFilename();
        if(pic_house!=null && originFilename.length()>0){
            String pic_path="/home/zhonglianxi/img/";
            String newFilename= UUID.randomUUID()+originFilename.substring(originFilename.lastIndexOf("."));
            File newFile=new File(pic_path+newFilename);
            pic_house.transferTo(newFile);//将图片上传至虚拟目录
            allhouse.setImg(newFilename);

        }
        houseService.insertHouse(allhouse);

        return "inserthouse";
    }
    @RequestMapping("alter")
    public String alterHouse(){
        Allhouse allhouse=new Allhouse();
        allhouse.setStyle("**");
        houseService.updateHouse(4,allhouse);
        return "mainui";
    }

}
