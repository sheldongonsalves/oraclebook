import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class bookDB {
	static Book book =new Book();
	static Connection con = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	public  Book getBookFromDB(String sku)
	{
		
		
		
		String sql = "select * from books where sku='"+ sku + "'";
		try{
			connect();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				
				book.setSKU(rs.getString("SKU"));
      			book.setTitle(rs.getString("book_title"));
				book.setAuthor(rs.getString(3));
 				book.setDescription(rs.getString("description"));
				book.setPrice(Double.parseDouble(rs.getString(5)));
				
				
			}
			}catch (SQLException e) {
				e.printStackTrace();
			} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			}
		return book;
	}
	public int UpdateBook(String title,String sku)
	{ 
		int count=0;
		try
		{
			connect();
			String sql ="UPDATE Books SET book_title = ? WHERE sku = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,title );
			pstmt.setString(2, sku);
			count =pstmt.executeUpdate();
			closed();


		}
		catch(Exception e)
		{
			e.getMessage();
		}
		return count;
	}
	public int InsertBook(String title ,String sku ,String author ,String description)
	{
		int count =0;
		try
		{
			connect();
			String sql ="insert into books (book_title ,sku ,author ,description) values (?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,title);
			pstmt.setString(2, sku);
			pstmt.setString(3 ,author);
			pstmt.setString(4 ,description);
			count =pstmt.executeUpdate();
			closed();
		}
        catch (SQLException e)
		{
        	e.printStackTrace();
		}
			
	
		return count;
	}
	
	public int DeleteBook(String sku)
	{
		int count =0;
		try
		{
			connect();
			String sql ="delete from Books WHERE sku = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,sku );
			count =pstmt.executeUpdate();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return count;
	}
	
	private  Connection connect() 
	{

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:ora1/ora1@localhost:1521:orcl");
		    
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return con;
	}
	
	private Connection closed()
	{
		try{
			con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
  
}
