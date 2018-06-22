package com.reservations.builder;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

public abstract class AbstractBuilder<E,D> {

	private Class<D> classD;
	private Class<E> classE;
	
	public D entityToDTO(E entity) {
		return new ModelMapper().map(entity, getClassD());
	}
	public E dtoToEntity(D dto) {
		return new ModelMapper().map(dto, getClassE());
	}
	
	public List<D> listEntitiesToListDTOs(List<E> listEntities) {
		return listEntities.stream().map(this::entityToDTO).collect(Collectors.toList());
	}
	
	public List<E> listDTOsToListEntities(List<D> listDTOs) {
		return listDTOs.stream().map(this::dtoToEntity).collect(Collectors.toList());
	}
	
	public Class<D> getClassD() {
		return classD;
	}
	
	public void setClassD(Class<D> classD) {
		this.classD = classD;
	}
	
	public Class<E> getClassE() {
		return classE;
	}
	
	public void setClassE(Class<E> classE) {
		this.classE = classE;
	}
	
}
