package com.tutrit.persistence.h2db.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class EngineerEntity {
        @Id
        @GeneratedValue
        private UUID uuid;
        private String name;
}
