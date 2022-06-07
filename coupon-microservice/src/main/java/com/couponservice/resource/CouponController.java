package com.couponservice.resource;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.couponservice.entity.Coupon;
import com.couponservice.service.CouponService;

@RestController
public class CouponController {
	
	@Autowired
	CouponService couponService;

	
	//to add a coupon
	@PostMapping("/addcoupon")
	@CrossOrigin(origins="http://localhost:4200")
	public Coupon addCoupon(@RequestBody Coupon deal) {
		Coupon coupon = couponService.save(deal);
		return coupon;
	}

	//find coupon by id
	@GetMapping("/find/id/{couponId}")
	@CrossOrigin(origins="http://localhost:4200")
	public Optional<Coupon> searchCouponByCouponId(@PathVariable("couponId") String couponId) {
		Optional<Coupon> coupon = couponService.findByCouponId(couponId);
		return coupon;
	}
	
	//find by category
	@GetMapping("/find/category/{category}")
	@CrossOrigin(origins="http://localhost:4200")
	public List<Optional<Coupon>> searchCouponByCategory(@PathVariable("category") String category) {
		List<Optional<Coupon>> coupon = couponService.findByCategory(category);
		return coupon;
	}
	
	//find by company name
	@GetMapping("/find/companyName/{companyName}")
	@CrossOrigin(origins="http://localhost:4200")
	public List<Optional<Coupon>> searchCouponByCompanyName(@PathVariable("companyName") String companyName) {
		List<Optional<Coupon>> coupon = couponService.findByCompanyName(companyName);
		return coupon;
	}

	//delete by coupon id
	@DeleteMapping("/delete/id")
	@CrossOrigin(origins="http://localhost:4200")
	public String deleteCouponBycouponId( String couponId) {
		String result = couponService.deleteById(couponId);
		return result;
	}
	
	//delete by category
	@PostMapping("/delete/category/{category}")
	@CrossOrigin(origins="http://localhost:4200")
	public String deleteCouponByCategory(@PathVariable("category") String category) {
		String result = couponService.deleteByCategory(category);
		return result;
	}
	
	//delete by company name
	@PostMapping("/delete/companyName/{companyName}")
	@CrossOrigin(origins="http://localhost:4200")
	public String deleteCouponByCompanyName(@PathVariable("companyName") String companyName) {
		String result = couponService.deleteByCompanyName(companyName);
		return result;
	}

	//to get all the coupon
	@GetMapping("/findall")
	@CrossOrigin(origins="http://localhost:4200")
	public List<Coupon> findCoupon() {
		return (List<Coupon>) couponService.findAll();
	}

	
	//to update by id
	@PutMapping("/update/id/{id}")
	@CrossOrigin(origins="http://localhost:4200")
	public Coupon updateCoupon(@RequestBody Coupon deal) {
		Coupon coupon = couponService.save(deal);
		return coupon;
	}
}
