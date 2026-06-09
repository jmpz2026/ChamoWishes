package com.chamo.chamowishes.dto.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDTO {
    private Long productId;
    private String name;
    private Float price;
    private Long stock;

    // El JsonInclude es una anotacion que se encarga de filtrar los campos, segun las reglas del ()
    // El Include.NON_NULL significa que no incluyas en el JSON si es null
    // Todo melo si ve papi
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String alert;
}
