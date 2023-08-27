package com.tdm.tdm.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "testdata")
public class TestData {
    @Id
    @Column(name = "testsetid")
    String testSetId;
    @Column(name = "scenario")
    String scenario;
    @Column(name = "assset")
    String assset;
    @Column(name = "data_Source")
    String data_Source;
}
