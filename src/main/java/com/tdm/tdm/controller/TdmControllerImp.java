package com.tdm.tdm.controller;

import com.tdm.tdm.model.TestData;
import com.tdm.tdm.model.TestSetId;
import com.tdm.tdm.service.TdmServiceImp;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tdm")
public class TdmControllerImp implements TdmController {
    @Autowired
    TdmServiceImp tdmServiceImp;

    @Override
    @RequestMapping(value = "generateData", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<Optional<TestData>>> generateData(@RequestBody TestSetId testSetId) throws IOException {
        List<Optional<TestData>> tdmResponse = tdmServiceImp.generateFiles(testSetId);

        return new ResponseEntity<>(tdmResponse, HttpStatus.ACCEPTED);


    }

    @RequestMapping(value = "welcome", method = RequestMethod.GET)
    public ResponseEntity<String> welcomeController() {
        return new ResponseEntity<>("Welcome to TDM Ui", HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "adminPage", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> adminController() {

        return new ResponseEntity<>("Welcome to Admin Ui", HttpStatus.ACCEPTED);
    }


}
