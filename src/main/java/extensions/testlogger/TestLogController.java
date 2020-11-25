package extensions.testlogger;

import io.qameta.allure.TmsLink;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.reflect.Method;
import java.util.Optional;

/**
 * This extension just collects useful info on test.
 * For now it just prints result to console, however possible areas to use can be different.
 * For example:
 * 1 - Writing test stats to DB for further analysis.
 * 2 - Sending test-info to Slackto support-channel.
 * 3 - Add info to TestRail's test-run (in case if integration is configured).
 */
@Slf4j
public class TestLogController implements AfterEachCallback {

    @Override
    public void afterEach(ExtensionContext context) {
        Method testMethod = context.getRequiredTestMethod();
        String testname = "Unnamed test";
        boolean result = true;
        String logs = "Test passed";
        String type = "NO_TYPE";
        String tmsLink = "NO_LINK";

        if (testMethod.isAnnotationPresent(DisplayName.class)) {
            testname = testMethod.getAnnotation(DisplayName.class).value();
        } else {
            log.warn("Test's name was not provided.");
        }

        Optional<Throwable> executionException = context.getExecutionException();

        if (executionException.isPresent()) {
            result = false;
            logs = executionException.get().getMessage();
        }

        if (testMethod.isAnnotationPresent(Tag.class)) {
            type = testMethod.getAnnotation(Tag.class).value();
        } else {
            log.warn("Test's type was not provided.'");
        }

        if (testMethod.isAnnotationPresent(TmsLink.class)) {
            type = testMethod.getAnnotation(TmsLink.class).value();
        } else {
            log.warn("Link to caseId was not provided.'");
        }

        TestResult testResult = TestResult.builder()
                .result(result)
                .testOutput(logs)
                .name(testname)
                .tmsLink(tmsLink)
                .type(type)
                .build();

        log.info(String.format("Completed test result: [%s]", testResult));
    }
}
