package com.example.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.ShopKeeper;

import com.example.demo.error.ProductNotFoundException;
import com.example.demo.repository.ShopKeeperRepository;

@Service
public class ShopKeeperServiceImpl implements ShopKeeperService{

	
	@Autowired
	ShopKeeperRepository shopKeeperRepository;

	@Override
	
	public ShopKeeper insertProduct(ShopKeeper shopkeeper) {
		
		int soapStock=100;
	    int pasteStock=80;
	    int biscutsStock=200;
	    int chocolateStock=100;
	    int coolDrinksStock=200;
	   
		if(shopkeeper.getProductName().equalsIgnoreCase("dove") && soapStock>shopkeeper.getProductQuantity())
		{
			shopkeeper.currentstock=soapStock-shopkeeper.getProductQuantity();
			shopkeeper.totalamount=shopkeeper.getProductPrice()*shopkeeper.getProductQuantity();
		    shopKeeperRepository.save(shopkeeper);
		    //soapStock=shopkeeper.currentstock;
		    //shopkeeper.currentstock=0;
		  }
		else if(shopkeeper.getProductName().equalsIgnoreCase("colgate") && pasteStock>shopkeeper.getProductQuantity())
		{
		    shopkeeper.currentstock=pasteStock-shopkeeper.getProductQuantity();
			shopkeeper.totalamount=shopkeeper.getProductPrice()*shopkeeper.getProductQuantity();
		    shopKeeperRepository.save(shopkeeper);
		}
		else if(shopkeeper.getProductName().equalsIgnoreCase("jimjam") && pasteStock>shopkeeper.getProductQuantity())
		{
		    shopkeeper.currentstock=biscutsStock-shopkeeper.getProductQuantity();
			shopkeeper.totalamount=shopkeeper.getProductPrice()*shopkeeper.getProductQuantity();
		    shopKeeperRepository.save(shopkeeper);
		}
		else if(shopkeeper.getProductName().equalsIgnoreCase("munch") && pasteStock>shopkeeper.getProductQuantity())
		{
		    shopkeeper.currentstock=chocolateStock-shopkeeper.getProductQuantity();
			shopkeeper.totalamount=shopkeeper.getProductPrice()*shopkeeper.getProductQuantity();
		    shopKeeperRepository.save(shopkeeper);
		}
		else if(shopkeeper.getProductName().equalsIgnoreCase("fanta") && pasteStock>shopkeeper.getProductQuantity())
		{
		    shopkeeper.currentstock=coolDrinksStock-shopkeeper.getProductQuantity();
			shopkeeper.totalamount=shopkeeper.getProductPrice()*shopkeeper.getProductQuantity();
		    shopKeeperRepository.save(shopkeeper);
		}
		return shopkeeper;
	}
	
	@Override
	public List<ShopKeeper> selectAllProduct() {
		
		return shopKeeperRepository.findAll();
	}

	@Override
	public ShopKeeper selectProductById(int pid) throws ProductNotFoundException {
		Optional<ShopKeeper> shopkeeper1= shopKeeperRepository.findById(pid);
		if(!shopkeeper1.isPresent())
		{
			throw new ProductNotFoundException("Product id not exists");
		}
	
		return shopKeeperRepository.findById(pid).get();
	}

	@Override
	public void deleteProductById(int pid) throws ProductNotFoundException {
		Optional<ShopKeeper> shopkeeper1= shopKeeperRepository.findById(pid);
		if(!shopkeeper1.isPresent())
		{
			throw new ProductNotFoundException("Product id not exists");
		}
		shopKeeperRepository.deleteById(pid);
		
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public ShopKeeper updateProductById(int id, ShopKeeper shopkeeper) throws ProductNotFoundException {
		
		
		Optional<ShopKeeper> shopkeeper1= shopKeeperRepository.findById(id);
		ShopKeeper shopkeeperDB=null;
		if(shopkeeper1.isPresent()) {
			shopkeeperDB=	shopKeeperRepository.findById(id).get();
		if(Objects.nonNull(shopkeeper.getProductName()) && !"".equalsIgnoreCase(shopkeeper.getProductName())) {
			shopkeeperDB.setProductName((shopkeeper.getProductName()));
			
		}
		if(Objects.nonNull(shopkeeper.getProductType()) && !"".equalsIgnoreCase(shopkeeper.getProductType())) {
			shopkeeperDB.setProductType(shopkeeper.getProductType());
			System.out.println(shopkeeper.getProductType());
		}
		if(Objects.nonNull(shopkeeper.getProductBrand()) && !"".equalsIgnoreCase(shopkeeper.getProductBrand())) {
			shopkeeperDB.setProductBrand(shopkeeper.getProductBrand());
			System.out.println(shopkeeper.getProductBrand());
		}
		if(Objects.nonNull(shopkeeper.getProductQuantity()) && !"".equals(shopkeeper.getProductQuantity())) {
			shopkeeperDB.setProductQuantity(shopkeeper.getProductQuantity());
			System.out.println(shopkeeper.getProductQuantity());
		}
		if(Objects.nonNull(shopkeeper.getProductPrice()) && !"".equals(shopkeeper.getProductPrice())) {
			shopkeeperDB.setProductPrice(shopkeeper.getProductQuantity());
			System.out.println(shopkeeper.getProductPrice());
		}}else
		{
			throw new ProductNotFoundException("Product id not exists");
		}
		
	return shopKeeperRepository.save(shopkeeperDB);
	}

	@Override
	public ShopKeeper findByproductName(String pname) {
		
		return shopKeeperRepository.findByproductName(pname);
	}

	@Override
	public ShopKeeper findByproductType(String ptype) {

		return shopKeeperRepository.findByproductType(ptype);
	}

	@Override
	public ShopKeeper findByproductBrand(String pbrand) {
		
		return shopKeeperRepository.findByproductBrand(pbrand);
	}

	@Override
	public ShopKeeper findByproductQuantity(int pquantity) {
		// TODO Auto-generated method stub
		return shopKeeperRepository.findByproductQuantity(pquantity);
	}


	@Override
	public ShopKeeper findByproductPrice(double pprice) {
	
		return shopKeeperRepository.findByproductPrice(pprice);
	}

	
	


		

	

	
	

	

	}
