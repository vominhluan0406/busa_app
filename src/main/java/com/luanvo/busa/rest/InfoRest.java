package com.luanvo.busa.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class InfoRest {

    private static Logger log = LoggerFactory.getLogger(InfoRest.class);

    @GetMapping("/address")
    public ResponseEntity<?> getInfoAddress(@RequestParam("type") String type,
                                            @RequestParam("id") int id) {
        log.info("GET /info/address?type=" + type + " &id=" + id);
        return null;
    }
}
