package sk.stuba.fei.mtmp.server.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.mtmp.server.services.CalculationService;
import sk.stuba.fei.mtmp.server.transfer.CalculusRequest;


@RestController
@RequestMapping(value = "/calculus", consumes = MediaType.APPLICATION_JSON_VALUE)
public class CalculationController {
    private static final Logger logger = LoggerFactory.getLogger(CalculationController.class);
    @Autowired
    private CalculationService service;

    @PostMapping("/")
    public ResponseEntity<?> calculateData(
            @RequestBody CalculusRequest request
    ){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                    this.service.calculateData(request)
            );
        } catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Somethig went wrong.");
        }
    }
}
