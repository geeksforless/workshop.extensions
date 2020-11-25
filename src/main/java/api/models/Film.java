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
public class Film {

    @JsonProperty("edited")
    private String edited;

    @JsonProperty("director")
    private String director;

    @JsonProperty("created")
    private String created;

    @JsonProperty("vehicles")
    private List<String> vehicles;

    @JsonProperty("opening_crawl")
    private String openingCrawl;

    @JsonProperty("title")
    private String title;

    @JsonProperty("url")
    private String url;

    @JsonProperty("characters")
    private List<String> characters;

    @JsonProperty("episode_id")
    private int episodeId;

    @JsonProperty("planets")
    private List<String> planets;

    @JsonProperty("release_date")
    private String releaseDate;

    @JsonProperty("starships")
    private List<String> starships;

    @JsonProperty("species")
    private List<String> species;

    @JsonProperty("producer")
    private String producer;
}