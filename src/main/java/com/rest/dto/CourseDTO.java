package com.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class CourseDTO {

    private Long id;
    private String name;
    private String category;
    private int rating;
    private String description;
}
