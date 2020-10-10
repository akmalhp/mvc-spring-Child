package com.jisoh.keybinding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jisoh.keybinding.BookService;
import com.jisoh.keybinding.BooksCreationDto;
import com.jisoh.keybinding.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/books")
public class JisohController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/all")
    public String showAll(Model model) {
        BooksCreationDto booksForm = new BooksCreationDto();

        for (int i = 1; i <= 6; i++) {
            booksForm.addBook(new PrimaryKey());
        }

        model.addAttribute("form", booksForm);
        model.addAttribute("books", bookService.findAll());
//        var a = resultService.findAll();
//        gausah
//        model.addAttribute("results", a.getSimilarData);

        return "main";
    }

//    @GetMapping(value = "/create")
//    public String showCreateForm(Model model) {
//	System.out.println("aaaa");
//        BooksCreationDto booksForm = new BooksCreationDto();
//
//        for (int i = 1; i <= 3; i++) {
//            booksForm.addBook(new PrimaryKey());
//        }
//
//        model.addAttribute("form", booksForm);
//
//        return "main";
//    }

	/*
	 * @GetMapping(value = "/edit") public String showEditForm(Model model) {
	 * List<PrimaryKey> books = new ArrayList<>(); bookService.findAll() .iterator()
	 * .forEachRemaining(books::add);
	 *
	 * model.addAttribute("form", new BooksCreationDto(books));
	 *
	 * return "editBooksForm"; }
	 */

    @PostMapping(value = "/save")
    public String saveBooks(@ModelAttribute BooksCreationDto books, Model model) {

        bookService.saveAll(books.getBooks());
        model.addAttribute("books", bookService.findAll());

        return "redirect:/books/all";
    }

    @GetMapping(value = "/test")
    public String test(Model model) {
    	model.addAttribute("test", "test");

    	return "ListOfBook";
    }

}