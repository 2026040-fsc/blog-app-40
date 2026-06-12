package com.example.blog_app;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class blogController {
    private final BlogRepository blogRepository;

    public blogController(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @GetMapping("/blog")
    public String blogs(Model model) {
        model.addAttribute("blogs", blogRepository.findAll());
        return "blog";
    }

    @GetMapping("/blog/new")
    public String news(Model model) {
        model.addAttribute("blog", new Blog());
        return "/blog/new";
    }

    @PostMapping("/saveblog")
    public String saveblog(@RequestParam String title, Long id, String text) {
        blogRepository.save(new Blog(title, id, text));
        return "redirect:/blog";
    }

    @GetMapping("/blog/{id}")
    public String viewBlog(@PathVariable Long id, Model model) {
        // 1. リポジトリを使って、データベースからIDが一致する記事を1件取得
        Blog blog = blogRepository.findById(id); 
        
        // 2. 取得したデータを「blog」という名前で画面（form.html）に渡す
        model.addAttribute("blog", blog);
        return "form";
    }
    
}
