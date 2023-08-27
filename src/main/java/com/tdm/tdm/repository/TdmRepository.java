package com.tdm.tdm.repository;

import com.tdm.tdm.model.TestData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TdmRepository extends JpaRepository<TestData,String> {
}
