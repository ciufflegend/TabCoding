package antlr;

import java.io.FileReader;
import java.io.FileWriter;
import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.Token;

public class ScannerTester {
  public static void main(String[] args) {
	 
	  
  	String fileIn = ".\\src\\resources\\input.file";
  	String fileOut1 = ".\\src\\resources\\lexer.ANTRL.txt";
  //	String fileOut2 = ".\\src\\resources\\lexer.JFLEX.txt";
  	FileWriter fOut;
  	Token tk;
  	int i;

		try {
			System.out.println ("Test ANTLR lexer");
			ScannerLexer lexer = new ScannerLexer(new ANTLRReaderStream(new FileReader(fileIn))); 
			fOut = new FileWriter (fileOut1);
			i = 1;
			while ((tk = lexer.nextToken()).getType() != ScannerLexer.EOF) {
				System.out.println(i++ + ":(" + tk.getLine() + "," + tk.getCharPositionInLine() + ")\t" + 
						"TokenType:" + tk.getType() + ":\t" + tk.getText());
				fOut.append(i++ + ":(" + tk.getLine() + "," + tk.getCharPositionInLine() + ")\t" + 
														"TokenType:" + tk.getType() + ":\t" + tk.getText() + "\n");
			} 
			fOut.close();
		} catch (Exception e) {
			System.out.println ("Test ANTLR abortito");
			e.printStackTrace();
		}
		
		

/*		try {
			System.out.println ("Test JFLEX lexer");
	    JFLEXSimpleLanguageLexer jflexLexer = new JFLEXSimpleLanguageLexer(new FileReader(fileIn));
	    i = 1;
			fOut = new FileWriter (fileOut2);			
			while (((tk = jflexLexer.nextToken()).getType()) != jflexLexer.YYEOF) {
				fOut.append(i++ + ":(" + tk.getLine() + "," + tk.getCharPositionInLine() + ")\t" + 
						"TokenType:" + tk.getType() + ":\t" + tk.getText() + "\n");
			} 
			fOut.close();
		} catch (Exception e) {
			System.out.println ("Test JFLEX abortito");
			e.printStackTrace();
		}
*/  }

  	
}
