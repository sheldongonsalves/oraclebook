


public class Book {
	private String author;
	private double price;
	private String title;
	private boolean available;
    private String SKU;
    private String description;
	public Book() {
		
	}
	public Book(String value , double price1 ,String sku ,String title1 ,boolean available1 ,String description1)
	{
		author =value;
		price = price1;
		SKU =sku;
		title =title1;
		available = available1;
		description = description1;
		
	}
	
	
	public void setAuthor(String value)
	{
		this.author =value;
	}
	public String getAuthor()
	{
		return author;
		
	}
	public void setDescription(String describe)
	{
		this.description =describe;
	}
	public String getDescription()
	{
		return description;
		
	}
	public void setPrice(double price1)
	{
		this.price =price1;
	}
	public double getPrice()
	{
		return price;
	}
	
	public void setSKU(String sku)
	{
		this.SKU = sku;
	}
	public String getSKU()
	{
		return SKU;
	}
	
	public void setTitle(String title1)
	{
		this.title= title1;
	}
	
	public String getTitle()
	{
		return title;
	}
	public void setAvailable(boolean available1)
	{
		this.available=available1;
		
	}
	public boolean getAvailable()
	{
		return available;
	}
    
	public double addBookPrice(int quantity)
	{
		double sum=0;
		if(available==true)
		{
			sum =price*quantity;	

		}
		return sum;
	}
	

}
