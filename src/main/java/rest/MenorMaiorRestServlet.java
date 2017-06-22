package rest;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/imcrest")
public class MenorMaiorRestServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp) throws ServletException, IOException {

        String alturaStr = req.getParameter("altura");
		String pesoStr = req.getParameter("peso");
        int altura = alturaStr == null ? 0 : Integer.parseInt(alturaStr);
		int peso = pesoStr == null ? 0 : Integer.parseInt(pesoStr);

        float imc;
        imc = (peso) / (((float)altura/100*(float)altura/100));
		String resultado = "";
		
		if(imc < 17){
			resultado = "Muito abaixo do peso";
		}else if(imc >=17 && imc < 18.5){
			resultado = "Abaixo do peso";
		}else if (imc >= 18.5 && imc < 25){
			resultado = "Peso normal";
		}else if(imc >= 25 && imc < 30){
			resultado = "Sobrepeso";
		}else if(imc >= 30 && imc < 35){
			resultado = "Obesidade I";
		}else if(imc >= 35 && imc < 40){
			resultado = "Obesidade II (severa)";
		}else if(imc >= 40){
			resultado = "Obesidade III (morbida)";
		}

        resp.getOutputStream().print(
                "{"
                + "\"resultado\":\"" + resultado + "\""
              + "}");
    }

}
