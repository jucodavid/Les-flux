import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main3 {

	public static void main(String[] args) {
		DataInputStream dis = null;
		DataOutputStream dos = null;
		try {
			dos = new DataOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(
									new File("six.txt"))));
			
			dos.writeBoolean(true);
			dos.writeByte(100);
			dos.writeChar('C');
			dos.writeDouble(12.548);
			dos.writeFloat(100.52f);
			dos.writeInt(1045);
			dos.writeLong(1214545765481868765L);
			dos.writeShort(2);
			dos.close();
			
			dis = new DataInputStream(
					new BufferedInputStream(
							new FileInputStream(
									new File("six.txt"))));
			System.out.println(dis.readBoolean());
			System.out.println(dis.readByte());
			System.out.println(dis.readChar());
			System.out.println(dis.readDouble());
			System.out.println(dis.readFloat());
			System.out.println(dis.readInt());
			System.out.println(dis.readLong());
			System.out.println(dis.readShort());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (dis != null)
					dis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (dos != null)
					dos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
