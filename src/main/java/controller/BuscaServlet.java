package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
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
		HttpRequest req = HttpRequest.newBuilder()
				.uri(URI.create("https://booking-com.p.rapidapi.com/v1/hotels/locations?name="+request.getParameter("local")+"&locale=pt-br"))
				.header("x-rapidapi-host", "booking-com.p.rapidapi.com")
				.header("x-rapidapi-key", "fb8d9b1f46msh43e2e951aadc919p1c610ajsn17111f74430f")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		
		HttpResponse<String> resp;
		
		try {
			resp = HttpClient.newHttpClient().send(req, HttpResponse.BodyHandlers.ofString());
									
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		ArrayList<Hotel> bd = new ArrayList<Hotel>();
		
		bd.add(new Hotel(1,"IBIS - SÃO PAULO","Hotel 3 estrellas, com piscina"));
		bd.add(new Hotel(2,"IBIS - JANDIRA","Hotel 4 estrellas, com CAFÉ"));
		bd.add(new Hotel(3,"IBIS - OSASCO","Hotel 5 estrellas, com almoço"));
		
		int id = Integer.parseInt(request.getParameter("id"));

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
		
		request.setAttribute("Hotel", result);
		
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher(pgDestino);
		dispatcher.forward(request, response);		
		
	}
}