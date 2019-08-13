package io.pivotal.geode.sample.log4j.function;


import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.execute.Function;
import org.apache.geode.cache.execute.FunctionContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestFunction implements Function, Declarable {
  private static final Logger METRICS_LOGGER = LogManager.getLogger("GemfireMetricsLogger");
  private static final Logger NormalLogger = LogManager.getLogger(TestFunction.class);


  public boolean hasResult() {
    return false;
  }

  public void execute(FunctionContext context) {
    NormalLogger.info("TestFunction.execute : executing function");
    METRICS_LOGGER.info("TestFunction.execute : test log output");
  }

  public String getId() {
    return TestFunction.class.getSimpleName();
  }

  public boolean optimizeForWrite() {
    return false;
  }

  public boolean isHA() {
    return false;
  }
}
