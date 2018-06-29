package com.example.mybatisdemo.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @RequestMapping(method = RequestMethod.GET)
    public Map<String, Object> getAuthorList(HttpServletRequest request) {
        List<Author> authorList = this.authorService.findAll();
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("total", authorList.size());
        param.put("rows", authorList);
        return param;
    }

    @RequestMapping(value = "/{userId:\\d+}")
    public Author getAuthor(@PathVariable Long userId, HttpServletRequest request) {
        Author author = this.authorService.findAuthor(userId);
        return author;
    }
}
