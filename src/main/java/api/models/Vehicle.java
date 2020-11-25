package api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

@Builder
@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

    @JsonProperty("max_atmosphering_speed")
    private String maxAtmospheringSpeed;

    @JsonProperty("cargo_capacity")
    private String cargoCapacity;

    @JsonProperty("films")
    private List<String> films;

    @JsonProperty("passengers")
    private String passengers;

    @JsonProperty("pilots")
    private List<Object> pilots;

    @JsonProperty("edited")
    private String edited;

    @JsonProperty("consumables")
    private String consumables;

    @JsonProperty("created")
    private String created;

    @JsonProperty("length")
    private String length;

    @JsonProperty("url")
    private String url;

    @JsonProperty("manufacturer")
    private String manufacturer;

    @JsonProperty("crew")
    private String crew;

    @JsonProperty("vehicle_class")
    private String vehicleClass;

    @JsonProperty("cost_in_credits")
    private String costInCredits;

    @JsonProperty("name")
    private String name;

    @JsonProperty("model")
    private String model;
}