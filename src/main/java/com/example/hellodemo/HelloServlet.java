package com.example.hellodemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.servletjspdemo.domain.Person;

@WebServlet (urlPatterns = "/hellolater")
public class HelloServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		
		if(request.getSession().getAttribute("osoba") == null)
		{
			request.getSession().setAttribute("osoba", new Person());
		}
		
		Person osoba = (Person) request.getSession().getAttribute("osoba");
		
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head><title>Prosty formularz</title></head>");
		writer.println("<body>");
		
		
		writer.println(" <form action=\"personData\"; method=\"get\">");
		
		writer.println("Imie: <input type=\"text\" name=\"imie\" value=\" " + osoba.getFirstName() + "\"><br>");
		writer.println("Rok Urodzenia: <input type=\"text\" name=\"rokUrodzenia\" value=\"" + osoba.getYob() + "\"><br>");
		
		int msc=0,kob=0,brak=0;
		if(osoba.getPlec().equalsIgnoreCase("Mezczyzna") )
		{
			msc=1;
		}else 
		if(osoba.getPlec().equalsIgnoreCase("Kobieta") )
		{
			kob=1;
		}else		
		if(osoba.getPlec().equalsIgnoreCase("brak") ) 
		{
			brak=1;
		}
		
		if(kob==1) writer.println("Plec: <br><input type=\"radio\" name=\"plec\" value=\"Kobieta\" checked>Kobieta<br> ");
		else writer.println("Plec: <br><input type=\"radio\" name=\"plec\" value=\"Kobieta\">Kobieta<br> ");
		
		
		if(msc==1) writer.println("<input type=\"radio\" name=\"plec\" value=\"Mezczyzna\" checked> Mezczyzna<br>");      
		else writer.println("<input type=\"radio\" name=\"plec\" value=\"Mezczyzna\"> Mezczyzna<br>");      
		
		
		if(brak==1)writer.println("<input type=\"radio\" name=\"plec\" value=\"brak\" checked> brak <br>");
		else writer.println("<input type=\"radio\" name=\"plec\" value=\"brak\"> brak <br>");
		
		int sia=0,noga=0,muza=0,soccer=0,znaczki=0;
		
		if(osoba.getHobby().toLowerCase().contains("Siatka".toLowerCase())) sia = 1;
		if(osoba.getHobby().toLowerCase().contains("Pilka Nozna".toLowerCase())) noga = 1;
		if(osoba.getHobby().toLowerCase().contains("Music".toLowerCase())) muza = 1;
		if(osoba.getHobby().toLowerCase().contains("Soccer".toLowerCase())) soccer = 1;
		if(osoba.getHobby().toLowerCase().contains("Zbieranie Znaczkow".toLowerCase())) znaczki = 1;
		
		if(sia == 1)writer.println("Hobby:<br> Siatka: <input type=\"checkbox\" name=\"sports\" value=\"Siatka\" checked  /><br />");
		else writer.println("Hobby:<br> Siatka: <input type=\"checkbox\" name=\"sports\" value=\"Siatka\"  /><br />");
		
		if(noga == 1) writer.println("Pilka Nozna: <input type=\"checkbox\" name=\"sports\" value=\"Pilka Nozna\" checked /><br />");
		else writer.println("Pilka Nozna: <input type=\"checkbox\" name=\"sports\" value=\"Pilka Nozna\"  /><br />");
		
		if(muza == 1) writer.println("Music: <input type=\"checkbox\" name=\"sports\" value=\"Music\" checked /><br />");
		else writer.println("Music: <input type=\"checkbox\" name=\"sports\" value=\"Music\"  /><br />");
		
		if(soccer == 1)writer.println("Soccer: <input type=\"checkbox\" name=\"sports\" value=\"Soccer\" checked  /><br />");
		else writer.println("Soccer: <input type=\"checkbox\" name=\"sports\" value=\"Soccer\"  /><br />");
		
		if(znaczki==1) writer.println("Zbieranie Znaczkow: <input type=\"checkbox\" name=\"sports\" value=\"Zbieranie Znaczkow\" checked /><br />");
		else writer.println("Zbieranie Znaczkow: <input type=\"checkbox\" name=\"sports\" value=\"Zbieranie Znaczkow\"  /><br />");
		
		
		int wyz=0,sre=0,niz=0,inne=0;
		if(osoba.getWyksztalcenie().equalsIgnoreCase("wyzsze") )
		{
			wyz=1;
		}else 
		if(osoba.getWyksztalcenie().equalsIgnoreCase("srednie") )
		{
			sre=1;
		}else		
		if(osoba.getWyksztalcenie().equalsIgnoreCase("podstawowe") ) 
		{
			niz=1;
		}else inne=1;
		
		
		writer.println("Opisz siebie w 3 slowach:<textarea name=\"ta\"  rows=\"4\" cols=\"50\"> " + osoba.getOpisSiebie() + "</textarea><br>");
		writer.println("Wyksztalcenie :<br> <select name=\"wksz\">");
		
			if(wyz==1)writer.println("<option selected>Wyzsze</option>");
			else writer.println("<option>Wyzsze</option>");
			if(sre==1)writer.println("<option selected>Srednie</option>");
			else writer.println("<option>Srednie</option>");
			if(niz==1)writer.println("<option selected>Podstawowe</option>");
			else writer.println("<option>Podstawowe</option>");
			if(inne==1)	writer.println("<option selected>Inne</option>");
			else writer.println("<option>Inne</option>");
		
  		writer.println("</select>");
		
  		writer.println("<input type=\"submit\" value=\"Wyslij\" />");		
		
		writer.println("</form>");
		writer.println("</body>");
		writer.println("</html>");
		
		
		writer.close();
	}

}
