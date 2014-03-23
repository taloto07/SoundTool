package com.musicbox.hosting.guice;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.inject.Inject;
import com.musicbox.hosting.dao.Song;
import com.musicbox.hosting.service.MusicService;

/**
 * Servlet implementation class Test
 */
//@WebServlet("/Test")
public class DispatchScott extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	@Inject
	MusicService service;
	
    public DispatchScott() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String contextPath = request.getContextPath();
		PrintWriter out = response.getWriter();
		out.println("Scott page!");
		out.println("contextPath: " + contextPath);
		
		List<Song> songs = service.getAllSongs();
		for (Song s: songs){
			out.println("Title: " + s.getTitle() + " " + s.getPath());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
