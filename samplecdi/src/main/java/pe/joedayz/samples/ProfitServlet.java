package pe.joedayz.samples;

import static jakarta.servlet.http.HttpServletResponse.SC_BAD_REQUEST;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

@WebServlet("/profit")
public class ProfitServlet extends HttpServlet {

  @Inject
  private Calculator calculator;

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String income = req.getParameter("income");
    String spent = req.getParameter("spent");

    if(income==null || income.isEmpty() || spent==null  || spent.isEmpty()){
      resp.sendError(SC_BAD_REQUEST);
      return;
    }

    BigDecimal profit = calculator.calculate(new BigDecimal(Double.parseDouble(income)).setScale(2, RoundingMode.HALF_UP),
        new BigDecimal(Double.parseDouble(spent)).setScale(2, RoundingMode.HALF_UP));
    resp.getWriter().println("Profit = " + profit.toString());

  }
}
