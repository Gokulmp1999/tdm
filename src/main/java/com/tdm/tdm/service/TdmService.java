package com.tdm.tdm.service;

import com.tdm.tdm.model.TestData;
import com.tdm.tdm.model.TestSetId;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface TdmService {
    List<Optional<TestData>> generateFiles(TestSetId testSetId) throws IOException, InterruptedException;
}
