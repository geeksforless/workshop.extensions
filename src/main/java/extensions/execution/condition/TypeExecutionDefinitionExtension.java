package extensions.execution.condition;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

/**
 * Let's imagine there some tests that can be executed only on one of environments.
 * Possible reason - some code is not yet implemented on another env so that it will fail.
 * To avoid such failures - we'll use this extension
 * <p>
 * For case when we have two envs - "qa" and "stable" and let's imagine we don't want to run tests on stable
 *
 * to test how this feature works run the following command - "./gradlew clean build allureReport -Denv="stable"
 */
@Slf4j
public class TypeExecutionDefinitionExtension implements ExecutionCondition {

    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
        String env = System.getProperty("env");

        if (env.equals("qa")) {
            return ConditionEvaluationResult.enabled("Tests can be run on QA env.");
        } else {
            return ConditionEvaluationResult.disabled("Tests cannot be run on Stable env.");
        }
    }
}
