package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ShopKeeper;
@Repository
public interface ShopKeeperRepository extends JpaRepository<ShopKeeper, Integer> {

	ShopKeeper findByproductName(String pname);

	ShopKeeper findByproductType(String ptype);

	ShopKeeper findByproductBrand(String pbrand);

	ShopKeeper findByproductQuantity(int pquantity);

	ShopKeeper findByproductPrice(double pprice);

	



	

	
	
	



	

	

}
