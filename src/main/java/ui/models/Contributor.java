package ui.models;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Contributor {

    private String name;

    private String githubLink;

}
