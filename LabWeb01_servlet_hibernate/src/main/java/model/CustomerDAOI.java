package model;

public interface CustomerDAOI {

//	select
	public CustomerVO select(String custid);
	
//	update
	public boolean update(CustomerVO customervo);
	
}
