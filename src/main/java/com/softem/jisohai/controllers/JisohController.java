package com.softem.jisohai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.softem.jisohai.services.ChildService;
import com.softem.jisohai.dto.ChildrenCreationDto;
import com.softem.jisohai.dto.ResultsCreationDto;
import com.softem.jisohai.models.Children;
import com.softem.jisohai.models.Result;
import com.softem.jisohai.services.ResultService;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;

@Controller
@RequestMapping("/children")
public class JisohController {

    @Autowired
    private ChildService childService;
    @Autowired
    private ResultService resultService;
    private Gson gson;
    private RestTemplate restTemplate;

    @GetMapping(value = "/all")
    public String showAll(Model model) {
        ChildrenCreationDto childrenForm = new ChildrenCreationDto();
        ResultsCreationDto resultForm = new ResultsCreationDto();

        for (int i = 1; i <= 6; i++) {
            childrenForm.addBook(new Children());
        }

        model.addAttribute("form", childrenForm);
        model.addAttribute("children", childService.findAll());
        model.addAttribute("results", resultService.findResult());
//        model.addAttribute("errorMessage", "{'detail':'Child data not found (id = 1)'}");
        
        return "main";
    }
    
    
    @PostMapping(value = "/savejson")
    public String createResults(@ModelAttribute ChildrenCreationDto children, Model model) {
        ResultsCreationDto results = new ResultsCreationDto();

    	this.childService.emptyAll();
        this.childService.saveAll(children.getChildren());
        model.addAttribute("children", this.childService.findAll());
    	
    	HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);        
        this.gson = new Gson();
        String json = this.gson.toJson(children.getChildren());
        
        HttpEntity<String> entity = new HttpEntity<String>(json,headers);
        
        this.restTemplate = new RestTemplate();
        
        String url = null;
        
        switch (children.getVersion()) {
        case 1:
        	url = "http://127.0.0.1:8000/week7/airesult";
        	break;
        case 2:
        	url = "http://127.0.0.1:8000/week8/airesult";
        	break;
        case 3:
        	url = "http://127.0.0.1:8000/week9/airesult";
        	break;
        case 4:
        	url = "http://127.0.0.1:8000/week9-2/airesult";
        	break;
        }
        
        model.addAttribute("radio", children.getVersion());
        
    	try {
		ResponseEntity<String> restResult = this.restTemplate.exchange(
                url, HttpMethod.POST, entity, String.class);
        
	        Result[] pojo = this.gson.fromJson(restResult.getBody(), Result[].class);
	        Collections.addAll(results.getResults(), pojo);
	        this.resultService.saveResult(results.getResults());
	        model.addAttribute("results", resultService.findResult());
        }
        catch (HttpClientErrorException ex){
        	if (ex.getStatusCode() == HttpStatus.NOT_FOUND) {
        		model.addAttribute("errorMessage", ex.getResponseBodyAsString());
        	}
        }
        	
//        return "redirect:/children/all";
        return "result";
        }
   
    
    }