package com.example.myfood.myfoodapi.api.assembler;

import com.example.myfood.myfoodapi.api.model.input.EstadoInput;
import com.example.myfood.myfoodapi.domain.model.Estado;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EstadoInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Estado toDomainObject(EstadoInput estadoInput) {
        return modelMapper.map(estadoInput, Estado.class);
    }

    public void copyToDomainObject(EstadoInput estadoInput, Estado estado) {
        modelMapper.map(estadoInput, estado);
    }

}
