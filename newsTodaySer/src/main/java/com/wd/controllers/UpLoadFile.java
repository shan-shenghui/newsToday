package com.wd.controllers;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * @author ssh
 */
@Controller
public class UpLoadFile {

    @RequestMapping(value = "upload2", method = RequestMethod.POST)
    public String upLoad2(HttpServletRequest request,
                          HttpServletResponse response) throws IOException {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        if (multipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            java.util.Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
                MultipartFile file = multiRequest.getFile((String) iter.next());
                if (file != null) {
                    String fileName = file.getOriginalFilename();
                    String[] nameStrings = fileName.split(",");
                    for (int i = 0; i < nameStrings.length; i++) {
                        System.out.println(nameStrings[i]);
                    }
                    String path = "E:/MyeclipseWorkSpace/springmvc/WebRoot/file/" + fileName;
                    File localFile = new File(path);
                    file.transferTo(localFile);
                }
            }
        }
        return "success";
    }
}
