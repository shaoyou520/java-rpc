package com.demo.entry;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Blog implements Serializable {

    private Integer id;
    private String name;
    private String desc;
}
