package extensions.testlogger;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TestResult {

    private String name;

    private boolean result;

    private String testOutput;

    private String type;

    private String tmsLink;

}
