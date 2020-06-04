
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

public class MainNio {

	public static void main(String[] args) {
		FileChannel fc = null;
		
		try (FileInputStream fis = new FileInputStream("Test.txt");
			BufferedInputStream bis = new BufferedInputStream(fis)) {
			
			long time = System.currentTimeMillis();
			while(bis.read() != -1);
			System.out.println("Temps d'exécution avec un buffer conventionnel : " + (System.currentTimeMillis() - time));
			
			fc = fis.getChannel();
			int size = (int)fc.size();
			ByteBuffer bBuff = ByteBuffer.allocate(size);
			
			time = System.currentTimeMillis();
			fc.read(bBuff);
			bBuff.flip();
			System.out.println("Temps d'exécution avec un nouveau buffer : " + (System.currentTimeMillis() - time));
			
			byte[] tabByte = bBuff.array();
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fc != null)fc.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	

	}

}
