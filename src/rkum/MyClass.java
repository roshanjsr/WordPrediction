package rkum;

public class MyClass implements Comparable<MyClass>{
	private String wrd;
	private int cnt;
	
	public MyClass()
	{
		this.wrd="";
		this.cnt=0;
	}
	public MyClass(String wrd, int cnt)
	{
		super();
		this.wrd=wrd;
		this.cnt=cnt;
	}
	
	public String getWrd()
	{
		return wrd;
	}
	public int getCnt()
	{
		return cnt;
	}
	
	public void setWrd(String wrd)
	{
		this.wrd=wrd;
	}
	public void setCnt(int cnt)
	{
		this.cnt=cnt;
	}

	public int compareTo(MyClass c1)
	{
		int compareqty=((MyClass) c1).getCnt();
		
		//ascending order
		//return this.cnt-compareqty;
		
		//descending order
		return compareqty-this.cnt;
	}
}
