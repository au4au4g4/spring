package model;

import java.util.List;

public interface ProductDAOI {

//	select
	public ProductVO select(Integer id);
	
//	selectall
	public List<ProductVO> select();
	
//	insert
	public ProductVO insert(ProductVO productVO);
	
//	update
	public ProductVO update(ProductVO productVO);
	
//	delete
	public boolean delete(Integer id);
	
}
