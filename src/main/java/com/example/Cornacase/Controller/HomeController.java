package com.example.Cornacase.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Cornacase.Model.DATA;
import com.example.Cornacase.Service.CornaCaseDataService;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    CornaCaseDataService cornaCaseDataService;

    @GetMapping("/")
    public String home(Model model) {
        int totaldeath=0;
        List<DATA> locationdetails=cornaCaseDataService.getData();
        try {
            totaldeath = locationdetails.stream().mapToInt(start -> start.getDate()).sum();
        }catch (Exception e)
        {

        }
        model.addAttribute("locationdetails",locationdetails);
        model.addAttribute("totaldeath",totaldeath);

        return "home";
    }

}
