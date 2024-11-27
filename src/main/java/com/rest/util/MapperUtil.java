package com.rest.util;

import org.modelmapper.ModelMapper;

import java.lang.reflect.Type;

public class MapperUtil {

    private final ModelMapper modelMapper;

    public MapperUtil(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public <T> T convert(Object objectToBeConverted, T convertedObject){

        return modelMapper.map(objectToBeConverted,(Type) convertedObject.getClass());
    }

}
