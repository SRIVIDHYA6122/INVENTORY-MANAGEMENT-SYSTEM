package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entity.ShopKeeper;
import com.example.demo.error.ProductNotFoundException;
import com.example.demo.service.ShopKeeperService;

@RestController
public class ShopKeeperController {
	
	
	
	@Autowired
	ShopKeeperService shopKeeperService;
	
	@PostMapping("/product/insertion/")
	public  ShopKeeper insertProduct(@RequestBody ShopKeeper shopkeeper)
	{
	  
		
		return  shopKeeperService.insertProduct(shopkeeper);
		
	}
	
	@GetMapping("/product/selectall/")
	public List<ShopKeeper> selectAllProduct()
	{
		return shopKeeperService.selectAllProduct();
		
		
	}
	
	@GetMapping("/product/selectbyid/{pid}")
	public   ShopKeeper selectProductById(@PathVariable ("pid") int pid) throws ProductNotFoundException
	{
		return shopKeeperService.selectProductById(pid);
		
	}
	//select by name
	@GetMapping("/product/selectbyname/{pname}")
	public   ShopKeeper selectProductByName(@PathVariable ("pname") String pname)
	{
		return shopKeeperService.findByproductName(pname);
		
	}
	
	//select by type
		@GetMapping("/product/selectbytype/{ptype}")
		public   ShopKeeper selectProductByType(@PathVariable ("ptype") String ptype)
		{
			return shopKeeperService.findByproductType(ptype);
			
		}
		
		@GetMapping("/product/selectbybrand/{pbrand}")
		public   ShopKeeper selectProductByBrand(@PathVariable ("pbrand") String pbrand)
		{
			return shopKeeperService.findByproductBrand(pbrand);
			
		}
	
        @GetMapping("/product/selectbyquantity/{pquantity}")
		public   ShopKeeper selectProductByQuantity(@PathVariable ("pquantity") int pquantity)
		{
			return shopKeeperService.findByproductQuantity(pquantity);
			
		}
        
        @GetMapping("/product/selectbyprice/{pprice}")
		public   ShopKeeper selectProductByPrice(@PathVariable ("pprice") double pprice)
		{
			return shopKeeperService.findByproductPrice(pprice);
			
		}

	
	@PutMapping("/product/updatebyid/{id}")
	public ShopKeeper updateProductById(@PathVariable ("id") int id, @RequestBody ShopKeeper shopkeeper) throws ProductNotFoundException
	{
		return  shopKeeperService.updateProductById(id,shopkeeper);
		
	}
	
	
	@DeleteMapping("/product/deletebyid/{pid}")
	public   String deleteProductById(@PathVariable ("pid") int pid) throws ProductNotFoundException
	{
		 shopKeeperService.deleteProductById(pid);
		 return "Product is deleted successfully";
		
	}
	

}
