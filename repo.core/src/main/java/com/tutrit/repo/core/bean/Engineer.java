package com.tutrit.repo.core.bean;

import lombok.Data;

import java.util.UUID;

@Data
public class Engineer {
    private UUID uuid;
    private String name;
}
