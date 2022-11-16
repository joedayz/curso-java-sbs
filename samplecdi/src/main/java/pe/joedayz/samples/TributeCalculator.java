package pe.joedayz.samples;

import jakarta.annotation.Priority;
import jakarta.decorator.Decorator;
import jakarta.decorator.Delegate;
import jakarta.inject.Inject;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.logging.Logger;

@Decorator
public class TributeCalculator implements Calculator{

  private final static Logger LOGGER = Logger.getLogger(TributeCalculator.class.getName());
  @Inject
  @Delegate
  Calculator calculator;

  @Override
  public BigDecimal calculate(BigDecimal income, BigDecimal spent) {
    LOGGER.info("TributeCalculator calculate");
    BigDecimal newIncome = income.multiply(new BigDecimal(0.9)).setScale(2, RoundingMode.HALF_UP);
    return calculator.calculate(newIncome, spent);
  }
}
