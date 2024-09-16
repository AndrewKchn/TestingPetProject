import io.cucumber.plugin.event.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.cucumber.plugin.EventListener;

public class CucumberLog4jPlugin implements EventListener {

    private static final Logger LOGGER = LogManager.getLogger(CucumberLog4jPlugin.class);

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        // Subscribe to the start and end of steps events
        publisher.registerHandlerFor(TestStepStarted.class, this::handleTestStepStarted);
//        publisher.registerHandlerFor(TestStepFinished.class, this::handleTestStepFinished);
    }

    private void handleTestStepStarted(TestStepStarted event) {
        if (event.getTestStep().getClass().getSimpleName().equals("HookTestStep")) {
//            LOGGER.info("Hook Starting");
        } else if (event.getTestStep().getClass().getSimpleName().equals("PickleStepTestStep")) {
            String keyword = ((PickleStepTestStep) event.getTestStep()).getStep().getKeyword();
            String text = ((PickleStepTestStep) event.getTestStep()).getStep().getText();
            LOGGER.info("Starting step: {}: {}", keyword, text);
        } else {
            LOGGER.info("TestStep undefined");
        }
    }

    private void handleTestStepFinished(TestStepFinished event) {
        String keyword = null;
        String stepName = null;
        if (event.getTestStep().getClass().getSimpleName().equals("HookTestStep")) {
            LOGGER.info("Hook Finished");
            return;
        } else {
            keyword = ((PickleStepTestStep) event.getTestStep()).getStep().getKeyword();
            stepName = ((PickleStepTestStep) event.getTestStep()).getStep().getText();
        }
        if (event.getResult().getStatus().is(Status.PASSED)) {
            LOGGER.info("Step DONE: {}: {}", keyword, stepName);
        } else {
            LOGGER.info("Step FAILED !!!: {}: {}", keyword, stepName);
        }
    }
}