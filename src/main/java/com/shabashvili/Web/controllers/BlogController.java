package com.shabashvili.Web.controllers;

import com.shabashvili.Web.models.Post;
import com.shabashvili.Web.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/blog")
    public String blogMain(Model model){
        Iterable<Post> post = postRepository.findAll();
        model.addAttribute("posts", post);
        return "blog-main";
    }
    @GetMapping("/blog/add")
    public String blogAdd(Model model){
        return "blog-add";
    }

    @PostMapping("/blog/add")
    public String blogPostAdd(@RequestParam String title,
                              @RequestParam String anons,
                              @RequestParam String text,
                              Model model){
        Post post = new Post(title, anons, text);
        postRepository.save(post);
        return "redirect:/blog";
    }

    @GetMapping("/blog/{id}")
    public String blogDetails(@PathVariable(value = "id") long id, Model model){
        if(!postRepository.existsById((int) id)){
            return "redirect:/blog";
        }
        Optional<Post> post = postRepository.findById((int) id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "blog-details";
    }
    @GetMapping("/blog/{id}/edit")
    public String blogEdit(@PathVariable(value = "id") long id, Model model){
        if(!postRepository.existsById((int) id)){
            return "redirect:/blog";
        }
        Optional<Post> post = postRepository.findById((int) id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "blog-edit";
    }

    @PostMapping("/blog/{id}/edit")
    public String blogPostUpdate(@PathVariable(value = "id") long id,
                                 @RequestParam String title,
                                  @RequestParam String anons,
                                  @RequestParam String text,
                                  Model model){

        Post post = postRepository.findById((int) id).orElseThrow();
        post.setTitle(title);
        post.setAnons(anons);
        post.setText(text);

        postRepository.save(post);
        return "redirect:/blog/{id}";
    }

    @PostMapping("/blog/{id}/remove")
    public String blogPostDelete(@PathVariable(value = "id") long id,
                                 Model model){

        Post post = postRepository.findById((int) id).orElseThrow();
        postRepository.delete(post);

        return "redirect:/blog";
    }
}
