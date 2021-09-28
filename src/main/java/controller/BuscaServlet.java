package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hotel;

@WebServlet("/Busca")
public class BuscaServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request,HttpServletResponse response ) 
			throws IOException, ServletException 
	{
		ArrayList<Hotel> bd = new ArrayList<Hotel>();
		
		bd.add(new Hotel(1,"IBIS - SÃO PAULO","Hotel 3 estrellas, com piscina"));
		bd.add(new Hotel(2,"IBIS - JANDIRA","Hotel 4 estrellas, com CAFÉ"));
		bd.add(new Hotel(3,"IBIS - OSASCO","Hotel 5 estrellas, com almoço"));
		
		//Buscando ID
		int id = Integer.parseInt(request.getParameter("id"));
		
		//Logica para busca
		
 		Hotel result = null;
		
		for(Hotel hotel : bd) {
			if(hotel.getId()==id) {
				result = hotel;
				break;
			}
		}
		
		//Retornar para o cliente
		
		String pgDestino = "";
		if(result!=null) {
			pgDestino = "/hoteis.jsp";
		}else {
			pgDestino = "/erro.jsp";
		}
		
		
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher(pgDestino);
		dispatcher.forward(request, response);
		
		  PrintWriter out = response.getWriter();	  
	        out.print(result);
		
	}
}