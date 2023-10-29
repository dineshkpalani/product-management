package com.products.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products.entity.Invoice;
import com.products.entity.Billing;
import com.products.pojo.InvoiceRequest;
import com.products.pojo.Product;
import com.products.pojo.ProductRequest;
import com.products.repo.BillingRepo;
import com.products.repo.InvoiceRepo;
import com.products.repo.ProductRepo;
import com.products.service.InvoiceService;
import com.products.service.ProductService;

@Service
// business logic
public class InvoiceServiceImpl implements InvoiceService {
	
//	@Autowired
//	private CustomersDao dao;
	
	@Autowired
	private InvoiceRepo repo;
	
	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private BillingRepo billingRepo;
	
	public List<Invoice> getInvoiceList() {
		System.out.println("Invoice - Service Implementation");
		Iterable<com.products.entity.Invoice> entites = repo.findAll();//retreives all the data
		List<Invoice> pojos = new ArrayList<>();
		for(com.products.entity.Invoice platform : entites) {
			pojos.add(new Invoice(platform.getID(), platform.getCustomerName(), platform.getCustomerPhone(), platform.getReferenceID(), platform.getTotalQuantity(), platform.getDiscountPercent(), platform.getDiscountAmount(), platform.getTotalAmount(), platform.getPayableAmount()));
		}
		return pojos;
	}
	
	public com.products.entity.Product getByName(List<com.products.entity.Product> obj, String name) {
		for(com.products.entity.Product in : obj) {
			if(in.getName().equals(name)) {
				return in;
			}
		}
		return null;
	}
//	@Override
//	public List<Product> getProductListByCategory(String category) {
//		Iterable<com.products.entity.Product> entites = repo.findByCategory(category);//retreives all the data
//		List<Product> pojos = new ArrayList<>();
//		for(com.products.entity.Product platform : entites) {
//			pojos.add(new Product(platform.getID(),platform.getName(),platform.getDescription(),platform.getCategory(),platform.getStock(),platform.getBuyingPrice(),platform.getSellingPrice()));
//		}
//		return pojos;
//	}
//	
//	public Product getProductListByID(int id) {
//		com.products.entity.Product entites = repo.findByID(id);
//		return new Product(entites.getID(),entites.getName(),entites.getDescription(),entites.getCategory(),entites.getStock(),entites.getBuyingPrice(),entites.getSellingPrice());
//	}
//	
	@Override
	public String add(InvoiceRequest input) {
		List<com.products.entity.Product> products = productRepo.findAll();
		String referenceId = RandomStringUtils.randomAlphanumeric(10);
		float total = 0;
		float totalquantity = 0;
		String res  = " ";
		for(com.products.pojo.ProductRequest a : input.getProducts()) {
			com.products.entity.Product gsp = getByName(products, a.getName());
			if(a.getQuantity()>gsp.getStock()) {
				return "Low Stock for the product"+a.getName();
			}
		}
		for(com.products.pojo.ProductRequest a : input.getProducts()) {
			com.products.entity.Product gsp = getByName(products, a.getName());
			double amount = a.getQuantity() *  gsp.getSellingPrice();
			Billing bill = new Billing(referenceId,a.getName(),a.getQuantity(),Float.valueOf(gsp.getSellingPrice()+""), Float.valueOf(amount+""));
			billingRepo.save(bill);
			total+=amount; 
			totalquantity+=a.getQuantity();
			float up = gsp.getStock()-a.getQuantity();
			productRepo.updateStock(up, gsp.getID());
		}
		float discountAmount = input.getDiscountPercent()*total/100;
		float payableAmount = total-discountAmount;
		Invoice inputs = new Invoice(input.getCustomerName(),input.getCustomerPhone(),referenceId,totalquantity,input.getDiscountPercent(),discountAmount,total,payableAmount);
		repo.save(inputs);
		res = "Invoice Saved Successfully";
		return res;
	}
	
//	@Override
//	public String update(int id, Product platform) {
//		com.products.entity.Product entity = new com.products.entity.Product(platform.getID(), platform.getCustomerName(), platform.getCustomerPhone(), platform.getReferenceID(), platform.getTotalQuantity(), platform.getDiscountPercent(), platform.getDiscountAmount(), platform.getPayableAmount(), platform.getTotalAmount());
//		System.out.println("updating by id, "+entity);
//		repo.save(entity);//update query
//		String res = "";
//		if(entity.getID()>0) {
//			res = "Updated successfully & id is "+entity.getID();
//		}else {
//			res = "Error updating product";
//		}
//		return res;
//	}
//	
//	@Override
//	public String purchaseUpdate(int id, Product platform) {
//		com.products.entity.Product c =repo.findByID(id);
//		int b =platform.getStock()+ c.getStock();
//		repo.updateStock(b, id);
//		String res = "";
//		res = "Stock updated successfully for "+c.getName()+ " Total stock is "+b;
//		return res;
//		}
//	
//	@Override
//	public String delete(int id) {
//		System.out.println("deleting bill by id = "+id);
//		repo.deleteById(Integer.valueOf(id));;
//		return "Bill deleted successfully";
//	}
	
//	
//	public String getTrainListByQuota(String quota, int train_no) {
//		com.railways.entity.Train ts = trainrepo.findByTrainNo(train_no);
//		List<com.products.entity.Product> bs = repo.findByQuotaAndTrainNo(quota,train_no);
//		int abks = 0;
//		for(com.products.entity.Product a:bs) {
//			abks+=a.getBookedseats();
//		}
////		int abks = repo.TotalBookedSeats(train_no,quota);
//		String res = "";
//		if(quota.equals("GEN")) {
//			int gen= ts.getGen()-abks;
//			res = gen+" Seats Available in General Quota for this Train";
//		}
//		else if(quota.equals("TAQ")) {
//			int taq = ts.getTaq()-abks;
//			res = taq+" Seats Available in Tatkal Quota for this Train";
//		}
//		else if(quota.equals("LAD")) {
//			int lad = ts.getLad()-abks;
//			res = lad+" Seats Available in Ladies Quota for this Train";
//		}
//		return res;
//	}
//	
	
//	@Override
//	public String add(Product platform) {
//		com.railways.entity.Train obj = trainrepo.findByTrainNo(platform.getTrainNo());
//		int ts = obj.getTotalSeats();
//		if(platform.getQuota().equals("GEN")) {
//			ts = obj.getGen();
//		}
//		else if(platform.getQuota().equals("TAQ")){
//			ts = obj.getTaq();
//		}
//		else if (platform.getQuota().equals("LAD")) {
//			ts = obj.getLad();
//		}
//		List<com.products.entity.Product> bs = repo.findByTrainNoAndQuota(platform.getTrainNo(), platform.getQuota());
//		int abks = 0;
//		for(com.products.entity.Product a:bs) {
//			abks+=a.getBookedseats();
//		}
//		int cb = platform.getBookedseats();
//		int a = cb+abks;
//		String res = "";
//		if(a<=ts) {
//			int stleft = ts-a;
//			System.out.println("Booked Successfully"+'\n'+"Seat Left = "+ stleft);
//			com.products.entity.Product entity = new com.products.entity.Product(platform.getID(), platform.getTrainNo(),platform.getQuota(), platform.getBookedseats());
//			repo.save(entity);
//			res = "Booked Successfully " +'\n'+"Seat Left = "+ stleft;
//		}
//		else if(a>=ts) {
//			int b = ts-abks;
//			System.out.println("Seats not available"+'\n'+"Available Seats = "+b);
//			res = "Seats not available"+'\n'+"Available Seats = "+b;
//		}
//		return res;
//	}
//	
//	



}
