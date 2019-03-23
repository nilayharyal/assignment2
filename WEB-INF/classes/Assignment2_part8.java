import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nilayharyal
 */
public class Assignment2_part8 extends HttpServlet{
   
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //do something
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //do something
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Map m=request.getParameterMap();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        Set s=m.entrySet();
        Iterator it=s.iterator();
        List<String> values =new ArrayList<String>();
        try{
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/booksdb","root","Nilay2019");
        pstmt = conn.prepareStatement("insert into books values(?,?,?,?);");
        
        while(it.hasNext()){
            @SuppressWarnings("unchecked")
            Map.Entry<String,String[]> entry = (Map.Entry<String,String[]>)it.next();
            String key=entry.getKey();
            String[] value=entry.getValue();
            //out.println("<b>"+key+":</b>");
            // out.println(value[0].toString()+"<br><br>");
            values.add(value[0].toString());
            if (values.size() == 4){
                pstmt.setString(1, values.get(0));
                pstmt.setString(2, values.get(1));
                pstmt.setString(3, values.get(2));
                pstmt.setFloat(4, Integer.parseInt(values.get(3)));
                pstmt.executeUpdate();
                values.clear();
              }
                
        
        }
        
}
        catch(Exception e){
            out.println(e);
        }
        
        out.println((m.size()/4) +" books added succesfully");
        
        
    }
}
