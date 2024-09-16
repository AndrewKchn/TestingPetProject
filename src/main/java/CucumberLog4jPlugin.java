import io.cucumber.plugin.event.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.cucumber.plugin.EventListener;

public class CucumberLog4jPlugin implements EventListener {

    private static final Logger LOGGER = LogManager.getLogger(CucumberLog4jPlugin.class);

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        // Подписываемся на события начала и окончания шагов
        publisher.registerHandlerFor(TestStepStarted.class, this::handleTestStepStarted);
        publisher.registerHandlerFor(TestStepFinished.class, this::handleTestStepFinished);
    }

    private void handleTestStepStarted(TestStepStarted event) {
//        event.getTestStep().step
        if (event.getTestStep().getClass().getSimpleName().equals("HookTestStep")){
            LOGGER.info("Start Hook");
        } else {
            String keyword = ((PickleStepTestStep) event.getTestStep()).getStep().getKeyword();
            String text = ((PickleStepTestStep) event.getTestStep()).getStep().getText();
            LOGGER.info("Start step: {}: {}", keyword, text);
        }
    }

    private void handleTestStepFinished(TestStepFinished event) {
        // Логирование окончания шага
        if (event.getResult().getStatus().is(Status.PASSED)) {
            LOGGER.info("Шаг выполнен: " + event.getTestStep().getCodeLocation());
        } else {
            LOGGER.error("Шаг не выполнен: " + event.getTestStep().getCodeLocation(), event.getResult().getError());
        }
    }
}