package com.arun;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


public class NewFile extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse res)
            throws ServletException,IOException
    {
        res.setContentType("text/html");//setting the content type
        PrintWriter pw=res.getWriter();//get the stream to write the data


        pw.println("<html><body>");
        pw.println("Welcome to servlet<br>");

        pw.println(makeApiCall());

        pw.println("</body></html>");




        pw.close();
    }


    public String makeApiCall(){
        String output = null;
        String finalOutput = "";

        try{
            URL url = new URL("http://localhost:8080/RestProject/webapi/contacts");
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
            httpCon.setRequestMethod("GET");
            httpCon.setRequestProperty("Accept","application/json");

            System.out.println("INSIDE Api call");
            if(httpCon.getResponseCode() != 200)
                return httpCon.getResponseMessage();

            BufferedReader br = new BufferedReader( new InputStreamReader( httpCon.getInputStream()));


            while((output = br.readLine()) != null){
                finalOutput += output;
                System.out.println(finalOutput);
            }

            httpCon.disconnect();

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        return finalOutput;

    }

}

