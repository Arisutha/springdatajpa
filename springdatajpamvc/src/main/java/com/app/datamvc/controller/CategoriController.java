package com.app.datamvc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.datamvc.model.Categori;
import com.app.datamvc.service.CategoriService;

@RestController
@RequestMapping(value = "/categori")
public class CategoriController {
	
	private static final Logger logger = LoggerFactory.getLogger(CategoriController.class);
	
	@Autowired
	private CategoriService categoriService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<Boolean> saveCategori(@RequestBody Categori categori){
		try {
			logger.info("insert categori");;
			this.categoriService.insert(categori);
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<Boolean> updateCategori(@RequestBody Categori categori){
		try {
			logger.info("update categori");;
			this.categoriService.update(categori);
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ResponseEntity<Boolean> deleteCategori(@RequestBody Categori categori){
		try {
			logger.info("delete categori");;
			this.categoriService.delete(categori);
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<List<Categori>> listCategori(){
		try {
			logger.info("list categori");
			List<Categori> list = this.categoriService.list("CATEGORI.FINDALL");
			return new ResponseEntity<List<Categori>>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			return new ResponseEntity<List<Categori>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@RequestMapping(value = "/findById", method = RequestMethod.GET)
	public ResponseEntity<Categori> findByIdCategori(@RequestBody Categori categori){
		try {
			logger.info("find by id categori");;
			Categori data = this.categoriService.find(Categori.class, categori.getId());
			return new ResponseEntity<Categori>(data, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			return new ResponseEntity<Categori>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
