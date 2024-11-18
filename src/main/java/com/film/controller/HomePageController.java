package com.film.controller;

import com.film.client.MovieDatabaseHttpClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class HomePageController {

//    private final MovieDatabaseHttpClient movieDatabaseHttpClient;
//
//    @RequestMapping("/")
//    public String showHomePage(){
//        System.out.println(movieDatabaseHttpClient.getTopTrendingString());
//        System.out.println(movieDatabaseHttpClient.getTopTrending());
//        return "index";
//    }

}
