package com.power.lzh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pb_docfiles")
@NoArgsConstructor
@Data
public class DocFiles {

    @Id
    private  String id;

    private  String fileext;

    private  String serverurl;
}
