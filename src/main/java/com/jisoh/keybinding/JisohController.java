package com.jisoh.keybinding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
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
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.result.view.RedirectView;

import com.google.gson.Gson;
import com.jisoh.keybinding.BookService;
import com.jisoh.keybinding.BooksCreationDto;
import com.jisoh.keybinding.PrimaryKey;
import com.jisoh.keybinding.Result;
import com.jisoh.keybinding.Result.SimilarData;
import com.jisoh.keybinding.ResultService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;

@Controller
@RequestMapping("/books")
public class JisohController {

    @Autowired
    private BookService bookService;
    @Autowired
    private ResultService resultService;
    private Gson gson;
    private RestTemplate restTemplate;

    @GetMapping(value = "/all")
    public String showAll(Model model) {
        BooksCreationDto booksForm = new BooksCreationDto();
        ResultsCreationDto resultForm = new ResultsCreationDto();

        for (int i = 1; i <= 6; i++) {
            booksForm.addBook(new PrimaryKey());
        }

        model.addAttribute("form", booksForm);
        model.addAttribute("books", bookService.findAll());
        model.addAttribute("results", resultService.findResult());
        
        return "main";
    }
    
    
    @PostMapping(value = "/savejson")
    public String createResults(@ModelAttribute BooksCreationDto books, Model model) {
        ResultsCreationDto results = new ResultsCreationDto();

    	this.bookService.emptyAll();
        this.bookService.saveAll(books.getBooks());
        model.addAttribute("books", this.bookService.findAll());
    	
    	HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);        
        this.gson = new Gson();
        String json = this.gson.toJson(books.getBooks());
        
        HttpEntity<String> entity = new HttpEntity<String>(json,headers);
        
        this.restTemplate = new RestTemplate();
        ResponseEntity<String> restResult = this.restTemplate.exchange(
                "http://127.0.0.1:8000/t_mixdata/airesult", HttpMethod.POST, entity, String.class);
        
        Result[] pojo = this.gson.fromJson(restResult.getBody(), Result[].class);
        Collections.addAll(results.getResults(), pojo);
        this.resultService.saveResult(results.getResults());
        model.addAttribute("results", resultService.findResult());
        	
        return "redirect:/books/all";
        }
    
    }