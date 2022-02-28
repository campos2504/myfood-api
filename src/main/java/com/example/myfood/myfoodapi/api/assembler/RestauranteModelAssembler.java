
package com.example.myfood.myfoodapi.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import com.example.myfood.myfoodapi.api.model.RestauranteModel;
import com.example.myfood.myfoodapi.domain.model.Restaurante;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




@Component
public class RestauranteModelAssembler {


	@Autowired
	private ModelMapper modelMapper;
	
	public RestauranteModel toModel(Restaurante restaurante) {
		return modelMapper.map(restaurante, RestauranteModel.class);
	}
	
	public List<RestauranteModel> toCollectionModel(List<Restaurante> restaurantes) {
		return restaurantes.stream()
				.map(restaurante -> toModel(restaurante))
				.collect(Collectors.toList());
	}
}