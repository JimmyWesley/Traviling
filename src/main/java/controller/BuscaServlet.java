package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.Retorno;
import model.Hotel;

@WebServlet("/Busca")
public class BuscaServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request,HttpServletResponse response ) 
			throws IOException, ServletException 
	{		
		var local = "Osasco";
		
		if(request.getParameter("local")!= null)
			local = request.getParameter("local");
		
		HttpRequest req = HttpRequest.newBuilder()
				.uri(URI.create("https://booking-com.p.rapidapi.com/v1/hotels/locations?name="+local+"&locale=pt-br"))
				.header("x-rapidapi-host", "booking-com.p.rapidapi.com")
				.header("x-rapidapi-key", "fb8d9b1f46msh43e2e951aadc919p1c610ajsn17111f74430f")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		
		HttpResponse<String> resp;
		
		try {
			resp = HttpClient.newHttpClient().send(req, HttpResponse.BodyHandlers.ofString());
		
			Gson gson = new Gson();			
			var Lista = gson.fromJson(resp.body(), Retorno[].class);
						
		String pgDestino = "";
		
		if(Lista!=null) {
			pgDestino = "/hoteis.jsp";
		}else {
			pgDestino = "/erro.jsp";
		}

		request.setAttribute("Lista", Lista);
		
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher(pgDestino);
		dispatcher.forward(request, response);		
		
		
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/erro.jsp");
			dispatcher.forward(request, response);
		}
		
	}
}