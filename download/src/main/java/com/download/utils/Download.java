package com.download.utils;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Download {

    public static void img(String imgName, HttpServletResponse response) throws IOException {
        File file = new File(imgName);
        if(!file.exists()) return;

        FileInputStream inputStream = new FileInputStream(file);
        ServletOutputStream outputStream = response.getOutputStream();

        String suffix = "";
        if (imgName.toLowerCase().endsWith("png")){
            suffix = "png";
        }
        if (imgName.toLowerCase().endsWith("jpg") || imgName.toLowerCase().endsWith("jpeg")){
            suffix = "jpeg";
        }

        response.setContentType("image/" + suffix);

        byte[] bytes = new byte[8192];
        int len;
        while ((len = inputStream.read(bytes)) != -1){
            outputStream.write(bytes,0,len);
            outputStream.flush();
        }

        outputStream.close();
        inputStream.close();
    }

}
