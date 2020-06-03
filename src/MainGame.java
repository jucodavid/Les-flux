
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainGame {

	public static void main(String[] args) {
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		
		try {
			oos = new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(
									new File("game.txt"))));
			
			oos.writeObject(new Game("Minecraft", "Aventure", 25.36));
			oos.writeObject(new Game("CSGO", "FPS", 0.00));
			oos.writeObject(new Game("Rocket League", "Arcade", 15.99));
			oos.close();
			
			ois = new ObjectInputStream(
					new BufferedInputStream(
							new FileInputStream(
									new File("game.txt"))));
			try {
				System.out.println("Affichage des jeux :");
				System.out.println("************************\n");
				System.out.println(((Game)ois.readObject()).toString());
				System.out.println(((Game)ois.readObject()).toString());
				System.out.println(((Game)ois.readObject()).toString());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ois != null)
					ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (oos != null)
					oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("\t\t\t\t\t\t\tTout à bien été fermé !");
		}
	}
}
