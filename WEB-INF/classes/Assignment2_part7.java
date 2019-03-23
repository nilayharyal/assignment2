import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Assignment2_part7 extends HttpServlet{
  
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //do something
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //do something
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String option = request.getParameter("option");
        Connection conn = null;
        ResultSet rs = null;
        Statement stmt = null;
        try{
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviesdb","root","Nilay2019");
        stmt = conn.createStatement();
        }
        catch(Exception e){
                out.println(e);
        }        
        
        if(option.equals("Browse")){
            String keyword=request.getParameter("keyword");
            String searchBy=request.getParameter("searchBy");
            try{
            rs=stmt.executeQuery("select * from movies where "+searchBy+ " like '%"+keyword+"%';");
            out.println("<H1>You searched for "+keyword+" :</H1>");
            out.println("<u>Here are the search results:</u><br><br>");
            while(rs.next()){
            out.println("<b>Movie Title: "+ rs.getString("title") +"<br><br>"
                        +"<b>Lead Actor: "+ rs.getString("actor") +"<br><br>"
                        +"<b>Lead Actress: "+ rs.getString("actress") +"<br><br>"
                        +"<b>Genre: "+ rs.getString("genre") +"<br><br>"
                        +"<b>Year: "+  rs.getString("year") +"<br><br><br><br>");
            }}
            catch(Exception e){out.println(e);}
        }
        if(option.equals("NewMovie")){
           
            
            try{
            String title=request.getParameter("title");
            String actor=request.getParameter("actor");
            String actress=request.getParameter("actress");
            String genre=request.getParameter("genre");
            String year=request.getParameter("year");
            stmt.executeUpdate("insert into movies values(\""+title+ "\",\""+actor+"\",\""+actress+"\",\""+genre+"\","+year+");");
           out.println("1 Movie added Succesfully");   
            }
            catch(Exception e){
                out.println(e);
            }
        }
    }
}

