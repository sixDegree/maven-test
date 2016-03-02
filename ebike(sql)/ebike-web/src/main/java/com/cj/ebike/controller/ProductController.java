package com.cj.ebike.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cj.ebike.entity.Product;
import com.cj.ebike.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController
{
	
	private ProductService productService;
	
	public ProductService getProductService()
	{
		return productService;
	}
	
	@Inject
	public void setProductService(ProductService productService)
	{
		this.productService = productService;
	}
	

	@RequestMapping(value={"/","/list"})
	public String list(Model model)
	{
		model.addAttribute("products", productService.list());
		return "ebike/list";
	}
	
	@RequestMapping(value={"/{id}"},method=RequestMethod.GET)
	public String details(@PathVariable int id,Model model)
	{
		model.addAttribute(productService.details(id));
		return "ebike/details";
	}

	@RequestMapping(value={"/add"},method=RequestMethod.GET)
	public String add(Model model)
	{
		model.addAttribute(new Product());
		return "ebike/add";
	}
	
	@RequestMapping(value={"/add"},method=RequestMethod.POST)
	public String add(@Validated Product product,BindingResult binding, @RequestParam(value="image",required=false) MultipartFile image,HttpServletRequest req) 
			throws IOException
	{
		if(binding.hasErrors())
			return "ebike/add";
		
		//file upload
		String realpath = req.getSession().getServletContext().getRealPath("/resources/upload/");
		System.out.println("realPath:"+realpath);
		if (!image.isEmpty())
		{
			System.out.println("ContentType:" + image.getContentType());
			System.out.println("Name:" + image.getName());
			System.out.println("OriginalFilename:"+ image.getOriginalFilename());

			FileUtils.copyInputStreamToFile(image.getInputStream(), new File(realpath + "/" + image.getOriginalFilename()));
		}
		
		//add product
		productService.insert(product);

		return "redirect:ebike/list";
	}
	
}
