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
public class Planet {

    @JsonProperty("films")
    private List<String> films;

    @JsonProperty("edited")
    private String edited;

    @JsonProperty("created")
    private String created;

    @JsonProperty("climate")
    private String climate;

    @JsonProperty("rotation_period")
    private String rotationPeriod;

    @JsonProperty("url")
    private String url;

    @JsonProperty("population")
    private String population;

    @JsonProperty("orbital_period")
    private String orbitalPeriod;

    @JsonProperty("surface_water")
    private String surfaceWater;

    @JsonProperty("diameter")
    private String diameter;

    @JsonProperty("gravity")
    private String gravity;

    @JsonProperty("name")
    private String name;

    @JsonProperty("residents")
    private List<String> residents;

    @JsonProperty("terrain")
    private String terrain;
}