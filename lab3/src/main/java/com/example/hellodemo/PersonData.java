package com.example.hellodemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.SessionContext;
import javax.enterprise.inject.New;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.servletjspdemo.domain.Person;
import com.example.servletjspdemo.service.StorageService;


@WebServlet (urlPatterns = "/personData")

public class PersonData extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		PrintWriter writer = resp.getWriter();
		StorageService data = (StorageService) getServletContext().getAttribute("baza");
		
		if(req.getSession().getAttribute("osoba") == null)
		{
			req.getSession().setAttribute("osoba", new Person());
		}
		
		Person osoba = (Person) req.getSession().getAttribute("osoba");
		
		writer.println("<html>");
		writer.println("<head><title>Prosty formularz</title></head>");
		
		osoba.setFirstName(req.getParameter("imie"));
		
		osoba.setYob(Integer.parseInt(req.getParameter("rokUrodzenia")));
		
		osoba.setPlec(req.getParameter("plec"));
		
		String podaneHobby = "";
		for (String hobby : req.getParameterValues("sports")) {
		podaneHobby += hobby + ", ";
		}
		
		osoba.setHobby(podaneHobby);
		
		
		osoba.setOpisSiebie(req.getParameter("ta"));
		
		osoba.setWyksztalcenie(req.getParameter("wksz"));
		
		data.add(osoba);
		
	
		
		writer.println("<body><h1>Nasze Osoby to:</h1>");
		for(int j=0;j<data.size();j++)
		{
		writer.println("<br>Imie :"
				+ data.getAllPersons().get(j).getFirstName() 
				+ "<br>Rok Urodzenia: " 
				+ data.getAllPersons().get(j).getYob()
				+ "<br>Plec: "
				+ data.getAllPersons().get(j).getPlec()
				+ "<br>Hobby: "
				+ data.getAllPersons().get(j).getHobby()
				+ "<br>Krotki Opis Siebie: "
				+ data.getAllPersons().get(j).getOpisSiebie()
				+ "<br>Wyksztalcenie: "
				+ data.getAllPersons().get(j).getWyksztalcenie()
				);
		}
		
		writer.println("</body>");
		writer.println("</html>");
		writer.close();
	}
	
	@Override
	public void init() throws ServletException {
		if(getServletContext().getAttribute("baza") == null)
		{
			getServletContext().setAttribute("baza", new StorageService());
		}
	}

}
