package com.qcloud.project.djfx.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.qcloud.project.djfx.model.ProductCategory;

@Component
public class UploadPhotos {
	
	public String upload(MultipartFile file,HttpServletRequest request) throws IllegalStateException, IOException{
		
		String path=null;// 文件路径
		String type=null;// 文件类型
		String trueFileName=null;//储存到数据库的文件名称
		//图片上传
		if (file!=null) {// 判断上传的文件是否为空
	         String fileName=file.getOriginalFilename();// 文件原名称
	         System.out.println("上传的文件原名称:"+fileName);
	         // 判断文件类型
	         type=fileName.indexOf(".")!=-1?fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()):null;
	         if (type!=null) {// 判断文件类型是否为空
	             if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {
	                 // 项目在容器中实际发布运行的根路径
	                 String realPath=request.getSession().getServletContext().getRealPath("/");
	                 // 自定义的文件名称
	                 trueFileName=String.valueOf(System.currentTimeMillis())+fileName;
	                 // 设置存放图片文件的路径
	                 path=realPath+"\\qcloud-admin\\assets\\img\\"+/*System.getProperty("file.separator")+*/trueFileName;
	                 System.out.println("存放图片文件的路径:"+path);
	                 // 转存文件到指定的路径
	                 file.transferTo(new File(path));
	                 
	                 
	                 System.out.println("文件成功上传到指定目录下");
	             }else {
	                 System.out.println("不是我们想要的文件类型,请按要求重新上传");
	                 return null;
	             }
	         }else {
	             System.out.println("文件类型为空");
	             return null;
	         }
	     }else {
	         System.out.println("没有找到相对应的文件");
	         return null;
	     }
		
		return trueFileName;
	}
	
}
