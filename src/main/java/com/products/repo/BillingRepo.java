package com.products.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.products.entity.Billing;
import com.products.entity.Invoice;
import com.products.entity.Product;

import jakarta.transaction.Transactional;

@Repository//to fetch from DB
public interface BillingRepo extends CrudRepository<Billing, Integer>{	
	
	public List<Billing> findAll();
//	public List<Billing> findByCategory(String category);
//	public Invoice findByID(int id);
//
//	@Transactional
//	@Modifying
//	@Query("update Product set stock = ?1 where id = ?2")
//	public void updateStock(int stock, int id);
//	public List<Product> findByTrainNoAndQuota(int trainno, String quota);
//	public List<Product> findByQuotaAndTrainNo(String quota, int trainno);
//	@Query("select sum(bookedseats) from Booking where trainNo = ?1 and quota = ?2")
//	public Integer TotalBookedSeats(Integer trainno, String quota);
//	public List<Booking> findByAvailability(int train_no);
//	public List<Train> findBySourceAndDestination(String source, String destination);
	//select * from ebser where name=? and bill_amt=?
//	public List<Customers> findByNameAndBillamt(String customername, String contactname, String address, String city, String postalcode, String country);
	
}
