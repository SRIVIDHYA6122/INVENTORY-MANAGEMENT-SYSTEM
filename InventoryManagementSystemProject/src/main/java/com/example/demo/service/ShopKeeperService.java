package com.example.demo.service;



import java.util.List;

import com.example.demo.entity.ShopKeeper;
import com.example.demo.error.ProductNotFoundException;

public interface ShopKeeperService {

	ShopKeeper insertProduct(ShopKeeper shopkeeper);


	ShopKeeper selectProductById(int pid) throws ProductNotFoundException;

	void deleteProductById(int pid) throws ProductNotFoundException;

	ShopKeeper updateProductById(int id, ShopKeeper shopkeeper) throws ProductNotFoundException;
//---------------------------------------------------------------------------------------------


	List<ShopKeeper> selectAllProduct();


	ShopKeeper findByproductName(String pname);


	ShopKeeper findByproductType(String ptype);


	ShopKeeper findByproductBrand(String pbrand);




	ShopKeeper findByproductQuantity(int pquantity);



	ShopKeeper findByproductPrice(double pprice);





	


	





	


	
	
	

	
	

	

	

	

	

}
