package com.sikiro.om.infrastructure.helper;

import org.modelmapper.ModelMapper;

public class ModelMapperHelper {

    public static <T> T Map(Object fromObject,Class<T> classT) {
        ModelMapper _modelMapper = new ModelMapper();
        return _modelMapper.map(fromObject, classT);
    }

}
