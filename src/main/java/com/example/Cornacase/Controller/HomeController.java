package com.example.Cornacase.Controller;

import com.example.Cornacase.Model.DATA;
import com.example.Cornacase.Service.CornaCaseDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    CornaCaseDataService cornaCaseDataService;

    @GetMapping("/")
    @Scheduled(initialDelay = 1000, fixedRate =60000*60*24 )
    public String index(Model model) {
        int totalDeath = 0;
        int totalRecovered = 0;
        int totalReported = 0;
        List<DATA> reportedCase = cornaCaseDataService.getData();
        List<DATA> reportedDeath = cornaCaseDataService.getDeathData();
        List<DATA> reportedRecovered = cornaCaseDataService.getRecoveredData();

        try {
            totalReported = reportedCase.stream().mapToInt(start -> start.getDate()).sum();
            totalRecovered = reportedRecovered.stream().mapToInt(start -> start.getDate()).sum();
            totalDeath = reportedDeath.stream().mapToInt(start -> start.getDate()).sum();
        } catch (Exception e) {
            System.err.println(e.getStackTrace());

        }
        model.addAttribute("totalReported", totalReported);
        model.addAttribute("totalRecovered", totalRecovered);
        model.addAttribute("reportedDeath", totalDeath);


        return "index";
    }

    @GetMapping("/home")
    public String home(Model model) {
        int totaldeath = 0;
        List<DATA> locationdetails = cornaCaseDataService.getData();
        try {
            totaldeath = locationdetails.stream().mapToInt(start -> start.getDate()).sum();
        } catch (Exception e) {

        }
        model.addAttribute("locationdetails", locationdetails);
        model.addAttribute("totaldeath", totaldeath);

        return "home";
    }

    @GetMapping("/dead")
    public String dead(Model model) {
        int totaldeath = 0;
        List<DATA> locationdetails = cornaCaseDataService.getDeathData();
        try {
            totaldeath = locationdetails.stream().mapToInt(start -> start.getDate()).sum();
        } catch (Exception e) {

        }
        model.addAttribute("locationdetails", locationdetails);
        model.addAttribute("totaldeath", totaldeath);

        return "dead";
    }

    @GetMapping("/recovered")
    public String recorvedData(Model model) {
        int totaldeath = 0;
        List<DATA> locationdetails = cornaCaseDataService.getDeathData();
        try {
            totaldeath = locationdetails.stream().mapToInt(start -> start.getDate()).sum();
        } catch (Exception e) {

        }
        model.addAttribute("locationdetails", locationdetails);
        model.addAttribute("totaldeath", totaldeath);

        return "recovered";
    }


}
