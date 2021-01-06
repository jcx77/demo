package com.file.fileupload.service;



import com.file.fileupload.vo.FileVo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import util.UUIDHelper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class FileService {
    @Value("${web.upload-path}")
    private String path;


    public Map<String, Object> upload(MultipartFile file) throws IOException {
        System.out.println(path);
        String uuid = UUIDHelper.get32UUID();
        //获取文件原始名
        String oname = file.getOriginalFilename();
        String suffix = oname.substring(oname.lastIndexOf("."));
        //获取格式
        String nname = uuid + suffix;
        Map<String, Object> map = new HashMap<String, Object>();
        if (file.isEmpty()) {
            map.put("msg", "请选择文件");
            return map;
        }

        FileVo f = new FileVo();
        f.setId(UUIDHelper.get32UUID());
        f.setNname(nname);
        f.setOname(oname);
        File dest = new File(path + nname);
        file.transferTo(dest);
        //map.put("msg", oname);
        //map.put("suffix", suffix);
        return map;
    }

    public ResponseEntity<InputStreamResource> downloadFile(String id)
            throws IOException {
        String filePath = path + "/647954dfe741f1b6dc3b8e4dea7e2d.jpg";
        FileSystemResource file = new FileSystemResource(filePath);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", "dadd.jpg"));
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(file.contentLength())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(file.getInputStream()));
    }

    /**
     * @param fileName
     * @return
     * @name 中文名称
     * @Description 文件扩展名不带点
     * @Time 创建时间:2020年4月26日下午8:27:25
     * @author 作者
     * @history 修订历史（历次修订内容、修订人、修订时间等）
     */
    public static String getNoPointExtention(String fileName) {
        int pos = fileName.lastIndexOf(".");
        return fileName.substring(pos + 1);
    }
}
