package ro.unibuc.assignment1main.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Categorie {  @JsonProperty("lactate")LACTATE,
    @JsonProperty("legume") LEGUME,
    @JsonProperty("fructe") FRUCTE,
    @JsonProperty("carne") CARNE,
    @JsonProperty("electronice") ELECTRONICE
}
