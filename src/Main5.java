
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class Main5 {

	public static void main(String[] args) {
		StringWriter sw = new StringWriter();
		StringReader sr;
		
		try {
			sw.write("Coucou les Chaudasses");
			System.out.println(sw);
			sw.close();
			
			sr = new StringReader(sw.toString());
			int i;
			String str = "";
			
			while((i = sr.read()) != -1)
				str += (char) i;
			System.out.println(str);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
