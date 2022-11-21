package com.jbk.SpringBoot_ProductManagement.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.jbk.SpringBoot_ProductManagement.dao.ProductDao;
import com.jbk.SpringBoot_ProductManagement.entity.Product;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ProductService_Impl implements ProductService {

	@Autowired
	private ProductDao dao;
	
	@Override
	public Boolean saveProduct(Product product) {
		
		return dao.saveProduct(product);
	}

	@Override
	public Product getProductById(int productId) {
		
		return dao.getProductById(productId);
	}

	@Override
	public List<Product> getAllProducts() {
		
		return dao.getAllProducts();
	}

	@Override
	public Boolean deleteProductById(int productId) {
		
		return dao.deleteProductById(productId);
	}

	@Override
	public Boolean updateProduct(Product product) {
		
		return dao.updateProduct(product);
	}

	@Override
	public String generateReport(String format) {
		List<Product> products = dao.getAllProducts();
		String destination = "E:\\Java\\Java By Kiran\\OJT\\Report";

		try 
		{
			File file = ResourceUtils.getFile("classpath:Product.jrxml");
			JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
			JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(products);

			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);
	
			if (format.equalsIgnoreCase("pdf")) 
			{
				JasperExportManager.exportReportToPdf(jasperPrint);
				JasperExportManager.exportReportToPdfFile(jasperPrint, destination + "\\ProductsList.pdf");
				destination = "Report Generated at " + " " + destination;
			}
			else 
			{
				destination = "Wrong Format";
			}		
		}
		catch (FileNotFoundException fe) 
		{
			destination = "Folder not found at specified Drive";
		}

		catch (Exception e) {
			e.printStackTrace();
			//destination = e.getMessage();
		}
		return destination;
	}
}
