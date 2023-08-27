package com.tdm.tdm.service;

import com.tdm.tdm.model.TestData;
import com.tdm.tdm.model.TestSetId;
import com.tdm.tdm.repository.TdmRepository;
import com.tdm.tdm.util.WhiteLabelCreation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TdmServiceImp implements TdmService {
    @Autowired
    TdmRepository tdmRepository;

    @Override
    public List<Optional<TestData>> generateFiles(TestSetId testSetIds) {

        List<Optional<TestData>> testData = testSetIds.getTestSetId().stream().map(testSetId -> tdmRepository.findById(testSetId)).collect(Collectors.toList());
//        for (String testSetId:testSetIds.getTestSetId()){
//            List<TestData> testArray= tdmRepository.findAll();
//        }
//        List<List<TestData>> collect = testSetIds.getTestSetId().stream().map(t -> tdmRepository.findAll()).collect(Collectors.toList());
//        System.out.println(collect);
//        System.out.println(testSetId);
        try{
            WhiteLabelCreation.createWhiteLabel(testData);
        }catch (Exception e){
            e.printStackTrace();
        }
        return testData;
    }
}
