package com.invest.platform.controller;

import com.invest.platform.models.Investment;
import com.invest.platform.models.InvestmentType;
import com.invest.platform.service.FileService;
import com.invest.platform.service.WealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@RestController
@RequestMapping("/wealth/v1")
public class InvestmentController {

    FileService fileService;
    WealthService wealthService;

    @Autowired
    InvestmentController(WealthService wealthService, FileService fileService){
        this.wealthService = wealthService;
        this.fileService = fileService;
    }

    @GetMapping("/invest")
    public ResponseEntity<Investment> getInvestment(@RequestParam long id,
                                                    @RequestParam InvestmentType type) {
        return ResponseEntity.ok(wealthService.getInvestmentInfo(id, type));
    }

    @PostMapping("/invest")
    public ResponseEntity<Investment> addInvestment(@RequestBody Investment investment) {
        return ResponseEntity.ok(wealthService.addInvestmentInfo(investment));
    }

    @PostMapping("/invest/upload")
    public ResponseEntity<Integer> addInvestmentFromFile(@RequestParam("file") MultipartFile file) {
        int count = fileService.parseAndAddInvestmentInfo(file);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(count);
    }

    @DeleteMapping("/invest")
    public ResponseEntity<String> deleteInvestment(@RequestParam long id,
                                                   @RequestParam InvestmentType type){
        wealthService.deleteInvestmentInfo(id, type);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/invest")
    public ResponseEntity<Investment> updateInvestment(@RequestParam int id,
                                                       @RequestParam InvestmentType type,
                                                       @RequestParam Optional<Float> buyPrice,
                                                       @RequestParam Optional<Float> sellPrice) {
        Investment investment = wealthService.updateInvestmentInfo(id, type, buyPrice, sellPrice);
        return ResponseEntity
                .accepted()
                .body(investment);
    }
}
