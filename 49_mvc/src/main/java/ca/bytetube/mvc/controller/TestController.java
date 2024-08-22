package ca.bytetube.mvc.controller;

import ca.bytetube.mvc.prop.ProjectProperties;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

@RestController
public class TestController {

    @Autowired
    private ProjectProperties properties;

    @GetMapping("/test")
    public String test(Date birthday){//xxxx/xxx/xxx
        return "你好" + birthday;
    }

    @PostMapping("/upload")
    public String upload(MultipartFile photo,String username) throws IOException {
        System.out.println(username);
        System.out.println(photo);

        //1.获取文件扩展名
        String extension = FilenameUtils.getExtension(photo.getOriginalFilename());


        //2.创建目标文件
        String dir = properties.getUpload().getImagePath();
        String fileName = UUID.randomUUID()+"."+ extension;
        File file = new File(dir + fileName);

        //3.创建好目标文件所在的父目录
        FileUtils.forceMkdirParent(file);

        //4.将数据写入目标文件中
        photo.transferTo(file);



        return "upload successfully !";
    }


    @GetMapping("/download")
    public void downLoad(HttpServletResponse response) throws IOException {
        //1.设置响应头
        response.setHeader("Content-Disposition","attachment;filename=logo3.jpeg");
        //2.读取文件
        InputStream is = new ClassPathResource("static/logo3.jpeg").getInputStream();
        IOUtils.copy(is,response.getOutputStream());

    }

}
