package com.align.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.align.models.Product;
import com.align.services.IFeedService;
import com.align.services.IFollowService;
import com.align.services.IUserService;

/**
 * @author Chen Lin
 * @date 2020-02-09
 */

@RestController
@CrossOrigin
@RequestMapping(value = "/v1/products")
public class ProductController {
	
	@Autowired
	IFeedService feedService;
	
	@Autowired
	IUserService userService;
	
	@Autowired
	IFollowService followService;
	
	
	@RequestMapping(value = "/{productId}", method = RequestMethod.GET)
	public Product getFeed(@PathVariable("productId") Integer productId) {
		Product product = new Product();
		product.setId(productId);
		product.setPrice(64.99f);
		product.setRating(3.5f);
		product.setDescription("This is a short description. Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
		product.setTitle("Remote "+productId+" Product");
		List<String> categories = new ArrayList<String>();
		categories.add("books");
		product.setCategories(categories);
		return product;
	}
//	
//	@RequestMapping(method = RequestMethod.GET)
//	public Product getProductsByParams(@PathVariable("productId") Integer productId) {
//		Product product = new Product();
//		product.setId(productId);
//		product.setPrice(64.99f);
//		product.setRating(3.5f);
//		product.setDescription("This is a short description. Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
//		product.setTitle("Remote "+productId+" Product");
//		List<String> categories = new ArrayList<String>();
//		categories.add("books");
//		product.setCategories(categories);
//		return product;
//	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public Product getProduct() {
		Product product = new Product();
		product.setId(1);
		product.setPrice(64.99f);
		product.setRating(3.5f);
		product.setDescription("This is a short description. Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
		product.setTitle("Remote Second Product");
		List<String> categories = new ArrayList<String>();
		categories.add("books");
		product.setCategories(categories);
		return product;
	}
}
