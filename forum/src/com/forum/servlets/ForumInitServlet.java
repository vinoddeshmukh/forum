package com.forum.servlets;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forum.dao.impl.ConfigDAOImpl;
import com.forum.model.ConfigBean;

/**
 * Servlet implementation class ForumInitServlet
 */
public class ForumInitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("ForumInitServlet | Init(ServletConfig config) | Started");
		String file = config.getServletContext().getRealPath("/js/config/navigationMap.js");
		loadConfiguration(file);
		//readConfiguration(file);
		System.out.println("ForumInitServlet | Init(ServletConfig config) | End");
	}
    /**
     * Default constructor. 
     */
    public ForumInitServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
	}

	@SuppressWarnings("unused")
	private void readConfiguration(String fileName) {
        // The name of the file to open.
        // This will reference one line at a time
        String line = null;
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =  new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }	
            // Always close files.
            bufferedReader.close();			
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" +fileName + "'");				
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");					
            // Or we could just do this: 
            // ex.printStackTrace();
        }
    }
	
	private void loadConfiguration(String fileName) {
		System.out.println("FileName:"+fileName);
		StringBuilder configBuilder = new StringBuilder();
		configBuilder.append("var navigationData = {\n");
		ConfigDAOImpl configDAO = new ConfigDAOImpl();
		List<ConfigBean> defaultConfigurations = configDAO.getDefaultConfigurations();
		System.out.println("defaultConfigurations:"+defaultConfigurations);
		
		for (int i = 0; i < defaultConfigurations.size(); i++) {
			ConfigBean configBean = defaultConfigurations.get(i);
			configBuilder.append(configBean.getScreenId());
			configBuilder.append(" :'{");
			configBuilder.append("\"id\":\""+configBean.getScreenId() + "\",");
			configBuilder.append("\"moduleId\":\""+configBean.getModuleId() + "\",");
			configBuilder.append("\"htmlPath\":\""+configBean.getHtmlPath() + "\",");
			configBuilder.append("\"defaultServiceUrl\":\""+configBean.getDefaultServiceUrl() + "\",");
			configBuilder.append("\"el\":\""+configBean.getEl() + "\"}'");
			if((i+1) != defaultConfigurations.size()){
				configBuilder.append(",");
				configBuilder.append("\n");
			}
			
		}
		configBuilder.append("\n}");
		
		File myFoo = new File(fileName);
		FileOutputStream fooStream = null;
		try {
			fooStream = new FileOutputStream(myFoo, false);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		// true to append
		// false to overwrite.
		byte[] myBytes = configBuilder.toString().getBytes(); 
		try {
			fooStream.write(myBytes);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fooStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
