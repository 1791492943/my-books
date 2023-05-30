package com.download.controller;

import com.download.utils.Download;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/download")
public class DownloadController {

    @Value("${book.imgPath}")
    private String imgPath;

    @GetMapping("/img/{imgName}")
    public void downloadImg(@PathVariable("imgName") String imgName, HttpServletResponse response) throws IOException {
        Download.img(imgPath + "\\" + imgName, response);
    }

}
