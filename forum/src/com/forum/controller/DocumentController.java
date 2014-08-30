package com.forum.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.forum.client.bean.DocumentClientBean;
import com.forum.common.BaseBean;
import com.forum.dao.DocumentDAO;
import com.forum.dao.impl.DocumentDAOImpl;
import com.forum.model.DocumentBean;

@Controller
public class DocumentController {
     
    @Autowired
    private DocumentDAO documentDao;
    
    
    @RequestMapping(value = "documents", method = RequestMethod.GET)
	public @ResponseBody BaseBean getDocumentList(){
    	DocumentDAOImpl documentDao = new DocumentDAOImpl();
    	DocumentClientBean documentClientBean = new DocumentClientBean();
    	documentClientBean.setDocumentList(documentDao.documentList("DOC"));
    	documentClientBean.setPdfList(documentDao.documentList("PDF"));
    	
    	return documentClientBean;
    }
     
    @RequestMapping("/index")
    public String index(Map<String, Object> map) {
        try {
            map.put("document", new DocumentBean());
            map.put("documentList", documentDao.list());
        }catch(Exception e) {
            e.printStackTrace();
        }
 
        return "documents";
    }
 
    @SuppressWarnings("unused")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(
            @ModelAttribute("document") DocumentBean document,
            @RequestParam("file") MultipartFile file) {
        System.out.println("Name:" + document.getName());
        System.out.println("Desc:" + document.getDescription());
        System.out.println("File:" + file.getName());
        System.out.println("ContentType:" + file.getContentType());
        try {
            Blob blob = Hibernate.createBlob(file.getInputStream());
 
            document.setFileName(file.getOriginalFilename());
//            document.setContents(blob);
            document.setContentType(file.getContentType());
        } catch (IOException e) {
            e.printStackTrace();
        }
         
        try {
            documentDao.save(document);
        } catch(Exception e) {
            e.printStackTrace();
        }
         
        return "redirect:/index.html";
    }
 
    @RequestMapping("/download/{documentId}")
    public String download(@PathVariable("documentId")
            Integer documentId, HttpServletResponse response) {
         
    	DocumentBean doc = documentDao.get(documentId);
        try {
            response.setHeader("Content-Disposition", "inline;filename=\"" +doc.getFileName()+ "\"");
            OutputStream out = response.getOutputStream();
            response.setContentType(doc.getContentType());
//            IOUtils.copy(doc.getContents().getBinaryStream(), out);
            out.flush();
            out.close();
         
        } catch (IOException e) {
            e.printStackTrace();
        } /*catch (SQLException e) {
            e.printStackTrace();
        }*/
         
         
        return null;
    }
 
    @RequestMapping("/remove/{documentId}")
    public String remove(@PathVariable("documentId")
            Integer documentId) {
         
        documentDao.remove(documentId);
         
        return "redirect:/index.html";
    }
}