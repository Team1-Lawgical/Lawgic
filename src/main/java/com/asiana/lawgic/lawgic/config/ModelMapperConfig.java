package com.asiana.lawgic.lawgic.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class ModelMapperConfig {
    private static ModelMapper modelMapper;
    private ModelMapperConfig(){

    }
    public static ModelMapper getModelMapperInstance(){
        if(modelMapper==null){
            modelMapper=new ModelMapper();
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        }
        return modelMapper;
    }
}
