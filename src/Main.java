import java.io.File;

public class Main {

	public static void main(String[] args) {
		
		File f = new File("Test.txt");
		System.out.println("Chemin absolu du fichier : " + f.getAbsolutePath());
		System.out.println("Nom du fichier : " + f.getName());
		System.out.println("Existe-t-il ? " + f.exists());
		System.out.println("Est-il en fait un répertoire ? " + f.isDirectory());
		System.out.println("Est-il en fait un fichier ? " + f.isFile());
		
		System.out.println("Affichage des lecteurs à la racine du PC : ");
		for(File file : f.listRoots()) {
			System.out.println(file.getAbsolutePath());
			try {
				int i = 1;
				for(File nom : file.listFiles()) {
					System.out.println("\t\t" + ((nom.isDirectory()) ? nom.getName() + "/" : nom.getName()));	
					i++;
				}
				System.out.println("\n");
			} 
			catch (NullPointerException e) {}
		}

	}

}
