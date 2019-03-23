import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Assignment2_part5 extends HttpServlet{
  
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        establishConnection(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        establishConnection(request, response);
    }

    public void establishConnection(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String Directory="/Users/nilayharyal/NetBeansProjects/Assignment2/Assignment2/web/";
        String fileName = request.getParameter("fileName");
        Connection conn = null;
        ResultSet rs = null;
        Statement stmt = null;

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Assignment 2 : part 5 </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Assignment 2:Part 5: </h1>");
        
        
    try
    {
// Load the driver.
    Class.forName("org.relique.jdbc.csv.CsvDriver");
      conn = DriverManager.getConnection("jdbc:relique:csv:" + Directory);

      // create a scrollable Statement so we can move forwards and backwards through ResultSets
      stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
      rs= stmt.executeQuery("SELECT * FROM "+fileName);
      out.println("<TABLE BORDER=1 ALIGN=\"CENTER\">\n" +
      "<TR BGCOLOR=\"#FFAD00\">\n" +
      "<TH> SalesOrderID"+
      "<TH> RevisionNumber"+
      "<TH> OrderDate"+
      "<TH> DueDate"+
      "<TH> ShipDate"+
      "<TH> Status"+
      "<TH> OnlineOrderFlag"+
      "<TH> SalesOrderNumber"+
      "<TH> PurchaseOrderNumber"+
      "<TH> AccountNumber"+
      "<TH> CustomerID"+
      "<TH> SalesPersonID"+
      "<TH> TerritoryID"+
      "<TH>BillToAddressID"+
      "<TH>ShipToAddressID"+
      "<TH>ShipMethodID"+
      "<TH>CreditCardID"+
      "<TH>CreditCardApprovalCode"+
      "<TH>CurrencyRateID"+
      "<TH>SubTotal"+
      "<TH>TaxAmt"+
      "<TH>Freight"+
      "<TH>TotalDue"+
      "<TH>Comment"+
      "<TH>ModifiedDate"
      );

            while(rs.next()){
                //												
                out.println("<TR><TD>"+rs.getString("SalesOrderID")
                            +"<TD>"+rs.getString("RevisionNumber")
                            +"<TD>"+rs.getString("OrderDate")
                            +"<TD>"+rs.getString("DueDate")
                            +"<TD>"+rs.getString("ShipDate")
                            +"<TD>"+rs.getString("Status")
                            +"<TD>"+rs.getString("OnlineOrderFlag")
                            +"<TD>"+rs.getString("SalesOrderNumber")
                            +"<TD>"+rs.getString("PurchaseOrderNumber")
                            +"<TD>"+rs.getString("AccountNumber")
                            +"<TD>"+rs.getString("CustomerID")
                            +"<TD>"+rs.getString("SalesPersonID")
                            +"<TD>"+rs.getString("TerritoryID")
                            +"<TD>"+rs.getString("BillToAddressID")
                            +"<TD>"+rs.getString("ShipToAddressID")
                            +"<TD>"+rs.getString("ShipMethodID")
                            +"<TD>"+rs.getString("CreditCardID")
                            +"<TD>"+rs.getString("CreditCardApprovalCode")
                            +"<TD>"+rs.getString("CurrencyRateID")
                            +"<TD>"+rs.getString("SubTotal")
                            +"<TD>"+rs.getString("TaxAmt")
                            +"<TD>"+rs.getString("Freight")
                            +"<TD>"+rs.getString("TotalDue")
                            +"<TD>"+rs.getString("Comment")
                            +"<TD>"+rs.getString("ModifiedDate")
                            );
            }
            out.println("</TABLE>\n</BODY></HTML>");
        
    // clean up
      conn.close();
    }
    catch(Exception e)
    {
      out.println(e);
    }
 

        
        
          }
    }