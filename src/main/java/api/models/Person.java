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
public class Person {

    @JsonProperty("films")
    private List<String> films;

    @JsonProperty("homeworld")
    private String homeworld;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("skin_color")
    private String skinColor;

    @JsonProperty("edited")
    private String edited;

    @JsonProperty("created")
    private String created;

    @JsonProperty("mass")
    private Integer mass;

    @JsonProperty("vehicles")
    private List<String> vehicles;

    @JsonProperty("url")
    private String url;

    @JsonProperty("hair_color")
    private String hairColor;

    @JsonProperty("birth_year")
    private String birthYear;

    @JsonProperty("eye_color")
    private String eyeColor;

    @JsonProperty("species")
    private List<Object> species;

    @JsonProperty("starships")
    private List<String> starships;

    @JsonProperty("name")
    private String name;

    @JsonProperty("height")
    private Integer height;
}