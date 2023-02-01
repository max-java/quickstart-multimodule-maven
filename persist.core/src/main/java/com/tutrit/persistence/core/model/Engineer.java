package com.tutrit.persistence.core.model;

import io.soabase.recordbuilder.core.RecordBuilder;

import java.util.UUID;

@RecordBuilder
public record Engineer (
    UUID uuid,
    String name
){}
