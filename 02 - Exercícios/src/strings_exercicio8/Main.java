package strings_exercicio8;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		String dataString = JOptionPane.showInputDialog("Digite uma data");

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			Date data = df.parse(dataString);

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(data);
			
			calendar.add(Calendar.DATE, 1);
			JOptionPane.showMessageDialog(null, df.format(calendar.getTime()));
			
			calendar.add(Calendar.DATE, -2);
			JOptionPane.showMessageDialog(null, df.format(calendar.getTime()));
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Data inválida!");
		}
	}
}
