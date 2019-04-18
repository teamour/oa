package com.our.oa.utils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class ModelMapperUtils {
	private static ModelMapper modelMapper;
	
    static { 
	    modelMapper = new ModelMapper(); 
	    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT); 
    } 

    private ModelMapperUtils() { 
    } 
    
    public static ModelMapper getModelMapper() {
		return modelMapper;
	}
    
    public static <D, T> List<D> mapCollection(final Collection<T> entityList, Class<D> outCLass) { 
     return entityList.stream() 
       .map(entity -> modelMapper.map(entity, outCLass)) 
       .collect(Collectors.toList()); 
    } 
}
