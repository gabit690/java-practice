package format;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class DecimalFormatter {

  private DecimalFormat _formater;
	
  public DecimalFormatter(int decimals, char separator) {
	  
	final DecimalFormatSymbols symbols = new DecimalFormatSymbols();
	
	symbols.setDecimalSeparator(separator);
	
	this._formater = new DecimalFormat("#.".concat("#".repeat(decimals)), symbols);
  }
  
  public String getFormated(double value) {
	  
	return this._formater.format(value);
  }
  
}
