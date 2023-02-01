package com.tutrit.persistence.core.model;

import io.soabase.recordbuilder.core.RecordBuilder;

@RecordBuilder
public record User (
        String userName,
        String age
){}
