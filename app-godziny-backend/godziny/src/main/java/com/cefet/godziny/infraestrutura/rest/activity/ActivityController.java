package com.cefet.godziny.infraestrutura.rest.activity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cefet.godziny.api.activity.ActivityDTO;
import com.cefet.godziny.api.activity.IActivityController;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(value = "/activities")

public class ActivityController implements IActivityController {

    @Autowired
    ActivityService service;

    @GetMapping
    public ResponseEntity<List<ActivityDTO>> findAll(@RequestParam(defaultValue = "0") Long offset,
            @RequestParam(defaultValue = "10") Long limit,
            @RequestParam Optional<String> filterBy,
            @RequestParam Optional<String> filter) {
        return ResponseEntity.ok().body(new ArrayList<>());
    }

}
