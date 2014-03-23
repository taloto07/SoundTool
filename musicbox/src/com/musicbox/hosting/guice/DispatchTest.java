package com.musicbox.hosting.guice;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupDir;

import com.google.inject.Inject;
import com.musicbox.hosting.dao.Song;
import com.musicbox.hosting.service.MusicService;

/**
 * Servlet implementation class Test
 */
//@WebServlet("/Test")
public class DispatchTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject MusicService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatchTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String contextPath = getServletContext().getContextPath();
		contextPath = contextPath.endsWith("/") ? contextPath : contextPath.concat("/");
		PrintWriter out = response.getWriter();
		
		String path = getServletContext().getRealPath("/WEB-INF/template/");
		
		STGroup templates = new STGroupDir(path, '$','$');
		ST page = templates.getInstanceOf("template");
		ST body = templates.getInstanceOf("body");

		List<Song> songs = service.getAllSongs();
		body.add("body", songs);
		page.add("title", "Test");
		page.add("var", "test");
		page.add("contextPath", contextPath);
		page.add("url", request.getRequestURI());
		page.add("body", body.render());
		
		out.print(page.render());
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
