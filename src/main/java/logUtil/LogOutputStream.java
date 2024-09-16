package logUtil;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.OutputStream;
import java.io.PrintStream;

public class LogOutputStream extends OutputStream {

    private final Logger logger;
    private final Level level;
    private final StringBuilder buffer = new StringBuilder();
    private static final Logger LOGGER = LogManager.getLogger(LogOutputStream.class);

    public LogOutputStream(Logger logger, Level level) {
        this.logger = logger;
        this.level = level;
    }

    @Override
    public void write(int b) {
        if (b == '\n') {
            logger.log(level, buffer.toString());
            buffer.setLength(0);
        } else {
            buffer.append((char) b);
        }
    }

    public static void redirectPrintsToLogger() {
        LOGGER.info("Redirecting System.out to LOGGER");
        System.setOut(new PrintStream(new LogOutputStream(LOGGER, Level.INFO), true));
    }
}
