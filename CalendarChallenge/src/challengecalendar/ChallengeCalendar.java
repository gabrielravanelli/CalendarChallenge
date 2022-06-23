package challengecalendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class ChallengeCalendar {
	public static void main(String[] args) throws ParseException {
			/* Um cliente tem 10 dias para pagar uma fatura após sua data de vencimento sem que os juros sejam cobrados. 
			 * Caso essa data caia em um sábado ou domingo, o cliente pode pagar na segunda-feira seguinte. 
			 * Crie uma estrutura que receba uma data de vencimento e calcule quantos dias ele tem para pagar */
					
			Scanner scan = new Scanner(System.in);
				
			System.out.print("Coloque a data de vencimento da fatura: ");
			String dataVencimento = scan.next();
				
			SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
				
			Calendar calAtual = Calendar.getInstance();

			Calendar calUser = Calendar.getInstance(); 
			  
			calUser.setTime(form.parse(dataVencimento));		
				
			calUser.add(Calendar.DATE, 10); 		
				
			int qtdDias = calUser.get(Calendar.DAY_OF_YEAR) - calAtual.get(Calendar.DAY_OF_YEAR);
				
			if(calUser.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
				calUser.add(Calendar.DATE, 2);
				System.out.println("Você tem " + (qtdDias+2) + " dias para pagar a fatura sem a cobrança de juros, ou seja, você poderá efetuar o pagamento até a data " + form.format(calUser.getTime()));
			}
			else if(calUser.get(Calendar.DAY_OF_WEEK) == (Calendar.SUNDAY)){ 
				calUser.add(Calendar.DATE, 1);
				System.out.println("Você tem " + (qtdDias+1) + " dias para pagar a fatura sem a cobrança de juros, ou seja, você poderá efetuar o pagamento até a data " + form.format(calUser.getTime()));
			}
			else {
				System.out.println("Você tem " + qtdDias + " dias para pagar a fatura sem a cobrança de juros, ou seja, você poderá efetuar o pagamento até a data " + form.format(calUser.getTime()));
			}
			scan.close();
	}
}
