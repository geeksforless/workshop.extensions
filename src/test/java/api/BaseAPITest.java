package api;

import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeAll;
import properties.TestProperties;


public class BaseAPITest {

    private static final TestProperties PROPS = ConfigFactory.create(TestProperties.class, System.getProperties());
    protected final SoftAssertions SA = new SoftAssertions();

    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = PROPS.baseUrl();
    }
}
