import com.sun.xml.rpc.encoding.TypeMappingImpl.Row;
import java.io.File;
import java.io.FileInputStream;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Assignment2_part6 extends HttpServlet{
  
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
        // String Directory="/Library/tomcat/webapps/assignment2/";
        // String fileName = Directory+"SalesOrder"+".csv";
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Assignment 2 : part 6 </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Assignment 2:Part 6: </h1>");
        
        
    try
    {
        FileInputStream file = new FileInputStream(new File("store.xls")); 

        // Create Workbook instance holding reference to .xlsx file 
        XSSFWorkbook workbook = new XSSFWorkbook(file); 

        // Get first/desired sheet from the workbook 
        XSSFSheet sheet = workbook.getSheetAt(0); 


        // Iterate through each rows one by one 
        Iterator<Row> rowIterator = sheet.iterator(); 
        while (rowIterator.hasNext()) { 
            Row row = rowIterator.next(); 
            // For each row, iterate through all the columns 
            Iterator<Cell> cellIterator = row.cellIterator(); 

            while (cellIterator.hasNext()) { 
                Cell cell = cellIterator.next(); 
                out.println(cell.getStringCellValue() + "t"); 
              } 
            out.println(""); 
        } 
        file.close();
  
    //  Reader reader = Files.newBufferedReader(Paths.get(fileName));
    //  CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
    //  .withHeader());
     
    //  out.println("<TABLE BORDER=1 ALIGN=\"CENTER\">\n" +
    //  "<TR BGCOLOR=\"#FFAD00\">\n" +
    //  "<TH> SalesOrderID"+
    //  "<TH> RevisionNumber"+
    //  "<TH> OrderDate"+
    //  "<TH> DueDate"+
    //  "<TH> ShipDate"+
    //  "<TH> Status"+
    //  "<TH> OnlineOrderFlag"+
    //  "<TH> SalesOrderNumber"+
    //  "<TH> PurchaseOrderNumber"+
    //  "<TH> AccountNumber"+
    //  "<TH> CustomerID"+
    //  "<TH> SalesPersonID"+
    //  "<TH> TerritoryID"+
    //  "<TH>BillToAddressID"+
    //  "<TH>ShipToAddressID"+
    //  "<TH>ShipMethodID"+
    //  "<TH>CreditCardID"+
    //  "<TH>CreditCardApprovalCode"+
    //  "<TH>CurrencyRateID"+
    //  "<TH>SubTotal"+
    //  "<TH>TaxAmt"+
    //  "<TH>Freight"+
    //  "<TH>TotalDue"+
    //  "<TH>Comment"+
    //  "<TH>ModifiedDate"
    //  );
    //  for (CSVRecord csvRecord : csvParser) {
        // out.println("<TR><TD>"+csvRecord.get("SalesOrderID")
        //                     +"<TD>"+csvRecord.get("RevisionNumber")
        //                     +"<TD>"+csvRecord.get("OrderDate")
        //                     +"<TD>"+csvRecord.get("DueDate")
        //                     +"<TD>"+csvRecord.get("ShipDate")
        //                     +"<TD>"+csvRecord.get("Status")
        //                     +"<TD>"+csvRecord.get("OnlineOrderFlag")
        //                     +"<TD>"+csvRecord.get("SalesOrderNumber")
        //                     +"<TD>"+csvRecord.get("PurchaseOrderNumber")
        //                     +"<TD>"+csvRecord.get("AccountNumber")
        //                     +"<TD>"+csvRecord.get("CustomerID")
        //                     +"<TD>"+csvRecord.get("SalesPersonID")
        //                     +"<TD>"+csvRecord.get("TerritoryID")
        //                     +"<TD>"+csvRecord.get("BillToAddressID")
        //                     +"<TD>"+csvRecord.get("ShipToAddressID")
        //                     +"<TD>"+csvRecord.get("ShipMethodID")
        //                     +"<TD>"+csvRecord.get("CreditCardID")
        //                     +"<TD>"+csvRecord.get("CreditCardApprovalCode")
        //                     +"<TD>"+csvRecord.get("CurrencyRateID")
        //                     +"<TD>"+csvRecord.get("SubTotal")
        //                     +"<TD>"+csvRecord.get("TaxAmt")
        //                     +"<TD>"+csvRecord.get("Freight")
        //                     +"<TD>"+csvRecord.get("TotalDue")
        //                     +"<TD>"+csvRecord.get("Comment")
        //                     +"<TD>"+csvRecord.get("ModifiedDate")
        //                     );
        
    // }

            // out.println("</TABLE>\n</BODY></HTML>");
        
    }
    catch(Exception e)
    {
      out.println(e);
    }
 

        
        
          }
    }