package pe.joedayz.samples;

import jakarta.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.logging.Logger;

@ApplicationScoped
public class ProfitCalculator implements Calculator{

  private final static Logger LOGGER = Logger.getLogger(ProfitCalculator.class.getName());
  @Override
  public BigDecimal calculate(BigDecimal income, BigDecimal spent) {
    LOGGER.info("ProfitCalculator calculate");
    return income.subtract(spent).setScale(2, RoundingMode.HALF_UP);
  }
}
