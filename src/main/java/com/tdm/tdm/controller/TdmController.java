package com.tdm.tdm.controller;

import com.tdm.tdm.model.TestData;
import com.tdm.tdm.model.TestSetId;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface TdmController {
    ResponseEntity<List<Optional<TestData>>> generateData(TestSetId testSetId) throws IOException;
}
