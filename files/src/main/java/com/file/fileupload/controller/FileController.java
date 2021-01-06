package com.file.fileupload.controller;

import com.file.fileupload.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Map;

@Controller
@RequestMapping("/file")
public class FileController {
    @Value("${web.upload-path}")
    private String path;
    private final ResourceLoader resourceLoader;
    @Autowired
    FileService fileService;

    public FileController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @RequestMapping("/upload")
    @ResponseBody
    public Map<String, Object> upload(@RequestParam("file") MultipartFile file) throws IOException {
        return fileService.upload(file);
    }

    @RequestMapping(value = "/down", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> downloadFile()
            throws IOException {
        return fileService.downloadFile("");
    }

    /**
     * 显示单张图片
     *
     * @return
     */
    @RequestMapping("show")
    public ResponseEntity showPhotos(String fileName) {

        try {
            File f=new File(path + "2647954dfe741f1b6dc3b8e4dea7e2d.jpg");
            if (!f.exists()){
                return null;
            }
            // 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
            return ResponseEntity.ok(resourceLoader.getResource("file:" + path + "92647954dfe741f1b6dc3b8e4dea7e2d.jpg"));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping("test")
    public static void download(HttpServletResponse response, Files f, String path) throws UnsupportedEncodingException {
        String realPath = path + "92647954dfe741f1b6dc3b8e4dea7e2d.jpg";
        File file = new File(realPath);
        if (file.exists()) { //判断文件父目录是否存在
            response.setHeader("content-type", "application/octet-stream");
            response.setContentType("application/octet-stream");
            // 下载文件能正常显示中文
           response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("filename", StandardCharsets.UTF_8.name()).replace("+", "%20"));
            //response.setHeader("Content-Disposition", "attachment;fileName=" + java.net.URLEncoder.encode("11.jpg", "UTF-8"));
            byte[] buffer = new byte[1024];
            FileInputStream fis = null; //文件输入流
            BufferedInputStream bis = null;

            OutputStream os = null; //输出流
            try {
                os = response.getOutputStream();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("========FileUtils. download======" + realPath);
            try {
                bis.close();
                fis.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("ok")
    public void ddd(HttpServletResponse response) throws UnsupportedEncodingException {
        File file = new File(path + "123.png");
        // 如果文件存在，则进行下载
        if (file.exists()) {
            System.out.println("下载文件" + file.getAbsoluteFile());
            // 配置文件下载
            response.setHeader("content-type", "application/octet-stream");
            response.setContentType("application/octet-stream");
            // 下载文件能正常显示中文
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("filename.jpg", StandardCharsets.UTF_8.name()).replace("+", "%20"));
            // 实现文件下载
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
                System.out.println("下载成功!");
                //return "successfully";

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("下载失败!");
                //return "failed";

            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        //e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        // e.printStackTrace();
                    }
                }
            }
        }
    }
}
