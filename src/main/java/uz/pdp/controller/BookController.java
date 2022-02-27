package uz.pdp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.pdp.dto.BookDto;
import uz.pdp.entity.BookEntity;
import uz.pdp.repository.BookRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {

    private final BookRepository bookRepository;

    @PostMapping("/add")
    public String add(@ModelAttribute BookDto bookDto, Model model){
        Boolean add = bookRepository.add(bookDto);
        if(add) {
            List<BookEntity> books = bookRepository.list();
            model.addAttribute("books", books);
        }
        return "cabinet";
    }

    @GetMapping(value = "/list")
    public String getList(Model model) {
        List<BookEntity> books = bookRepository.list();
        model.addAttribute("books", books);
        return "cabinet";
    }

    @GetMapping(value = "/get")
    public String get(HttpServletRequest request, Model model) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        model.addAttribute("book", book);
        return "cabinet";
    }

    @GetMapping(value = "/delete")
    public String delete(HttpServletRequest request, Model model) {
        Long id = Long.parseLong(request.getParameter("id"));
        bookRepository.delete(id);
        List<BookEntity> books = bookRepository.list();
        model.addAttribute("books", books);
        return "cabinet";
    }

    @PutMapping(value = "/update")
    public String update(HttpServletRequest request, @ModelAttribute BookDto book, Model model) {
        Long id = Long.parseLong(request.getParameter("id"));
        bookRepository.edite(id, book);
        List<BookEntity> books = bookRepository.list();
        model.addAttribute("books", books);
        return "cabinet";
    }

}
