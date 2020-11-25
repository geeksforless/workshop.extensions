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
public class Creature {

    @JsonProperty("films")
    private List<String> films;

    @JsonProperty("skin_colors")
    private String skinColors;

    @JsonProperty("homeworld")
    private String homeworld;

    @JsonProperty("edited")
    private String edited;

    @JsonProperty("created")
    private String created;

    @JsonProperty("eye_colors")
    private String eyeColors;

    @JsonProperty("language")
    private String language;

    @JsonProperty("classification")
    private String classification;

    @JsonProperty("people")
    private List<String> people;

    @JsonProperty("url")
    private String url;

    @JsonProperty("hair_colors")
    private String hairColors;

    @JsonProperty("average_height")
    private String averageHeight;

    @JsonProperty("name")
    private String name;

    @JsonProperty("designation")
    private String designation;

    @JsonProperty("average_lifespan")
    private String averageLifespan;
}