package extensions.parameter.resolver;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestTemplateInvocationContext;
import org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.platform.commons.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Path starts from here :)
 * https://github.com/junit-team/junit5/issues/1139
 */
@Slf4j
public class ParameterResolverExtension implements AfterEachCallback {

    @Override
    public void afterEach(ExtensionContext context) throws Exception {


        Method testMethod = context.getRequiredTestMethod();
        Object[] params = new Object[0];

        Integer id = 1;
        String name = "";

        if (testMethod.isAnnotationPresent(ParameterizedTest.class)) {
            try {
                Method method = ReflectionUtils.findMethod(context.getClass(), "getTestDescriptor").orElse(null);
                TestMethodTestDescriptor descriptor = (TestMethodTestDescriptor) ReflectionUtils.invokeMethod(method, context);

                //Get the TestTemplateInvocationContext
                Field templateField = descriptor.getClass().getDeclaredField("invocationContext");
                templateField.setAccessible(true);
                TestTemplateInvocationContext template = (TestTemplateInvocationContext) templateField.get(descriptor);

                //Get the params finally
                Field argumentsField = template.getClass().getDeclaredField("arguments");
                argumentsField.setAccessible(true);
                params = (Object[]) argumentsField.get(template);
                log.info("Parameters were resovlved");
            } catch (Exception e) {
                log.info("Parameters weren't resovlved");
            }
        }

        if (params[0] instanceof Integer) {
            id = (Integer) params[0];
        }

        if (params[1] instanceof String) {
            name = (String) params[1];
        }

        log.info("Id of user = " + id + ". Name = " + name + ".");
    }
}
