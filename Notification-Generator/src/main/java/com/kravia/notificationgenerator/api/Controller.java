package com.kravia.notificationgenerator.api;

import com.kravia.notificationgenerator.creditor.Creditor;
import com.kravia.notificationgenerator.debtor.Debtor;
import com.kravia.notificationgenerator.posten.Posten;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class Controller {
    Logger logger = LoggerFactory.getLogger(Controller.class);
    @Autowired
    NotificationService notificationService;

    //creating an API for Posten to send a defaulters address
    @PostMapping("/report-defaulter")
    @ResponseBody
    ResponseEntity registerDefaulter(@RequestBody Posten posten) {
        ResponseEntity responseEntity;
        try {
            logger.info("Received Request for a defaulter's having address" + posten.getAddress());
            responseEntity = new ResponseEntity(notificationService.createDefaulter(posten), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Received Request for a defaulter cannot be processed against address" + posten.getAddress() + " but failed due to exception " + e);
            responseEntity = new ResponseEntity("Failed to process defaulter because of exception " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    //creating an API for getting a response for the dashboard
    @PostMapping("/dashboard-response")
    @ResponseBody
    ResponseEntity updateDashboard(@RequestBody Posten posten) {
        ResponseEntity responseEntity;
        try {
            logger.info("Received Request for a defaulter's having address" + posten.getAddress());
            responseEntity = new ResponseEntity(notificationService.createDefaulter(posten), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Received Request for a defaulter cannot be processed against address" + posten.getAddress() + " but failed due to exception " + e);
            responseEntity = new ResponseEntity("Failed to process defaulter because of exception " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
    //test api for creating a debtor
    //creating an API for creating a debtor
    @PostMapping("/create-debtor")
    @ResponseBody
    ResponseEntity registerDebtor(@RequestBody Debtor debtor) {
        ResponseEntity responseEntity;
        try {
            logger.info("Received Request for creating a debtor having address" + debtor.getAddress());
            responseEntity = new ResponseEntity(notificationService.createDebtor(debtor), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Received Request for creating a debtor cannot be processed against address" + debtor.getAddress() + " but failed due to exception " + e);
            responseEntity = new ResponseEntity("Failed to register debtor because of exception " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    //test API for creating dummy creditor profile
    //creating an API for creating a debtor
    @PostMapping("/create-creditor")
    @ResponseBody
    ResponseEntity registerUser(@RequestBody Creditor creditor) {
        ResponseEntity responseEntity;
        try {
            logger.info("Received Request for creating a creditor");
            responseEntity = new ResponseEntity(notificationService.createCreditor(creditor), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Received Request for creating a creditor cannot be processed due to exception: " + e);
            responseEntity = new ResponseEntity("Failed to create a creditor because of exception " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}