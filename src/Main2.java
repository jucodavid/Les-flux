import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main2 {

	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			fis = new FileInputStream(new File("Test.txt"));
			fos = new FileOutputStream(new File("Test2.txt"));
			bis = new BufferedInputStream(new FileInputStream(new File("Test.txt")));
			bos = new BufferedOutputStream(new FileOutputStream(new File("Test2.txt")));
			byte[] buf = new byte[8];
			
			long startTime = System.currentTimeMillis();
			while(fis.read(buf) != -1) {
				fos.write(buf);
			}
			System.out.println("Temps de lecture + écriture avec FileInput&OutputStream : " + (System.currentTimeMillis() - startTime));
			
			startTime = System.currentTimeMillis();
			while(bis.read(buf) != -1) {
				bos.write(buf);
			}
			System.out.println("Temps de lecture = écirture avec BufferedInput&OutputStream : " + (System.currentTimeMillis() - startTime));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (bis != null)
					bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (bos != null)
					bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
