package ServerPackage;
import java.net.*;
import java.io.*;

public class Server {

	public static void main(String[] args) throws IOException {
		try {
		// premiere etape :
			ServerSocket ss = new ServerSocket(1234);
			System.out.println("Je suis un serveur en attende la connexion d'un client");
		
		//La deuxieme etape :
			Socket s = ss.accept();
			System.out.println("un client est connecte");
		
			System.out.println("Menu:");
			System.out.println("1. Addition(+) ");
			System.out.println("2. Soustraction(-) ");
			System.out.println("3. Multiplication(*) ");
			System.out.println("4. Division(/) ");

			
			InputStream is = s.getInputStream();
			int c=is.read();
			
			InputStream is2 = s.getInputStream();
			int x=is2.read();
			
			int nb=0;
			
			switch(c) {
				case 1: nb=x+5;
						break;
				case 2: nb=x-5;
						break;
				case 3: nb=x*5;
						break;
				case 4: nb=x/5;
						break;
			}
			
			OutputStream os = s.getOutputStream();
			System.out.println(nb);
			os.write(nb);
			
		//La derniere etape : Fermer socket
			s.close();
		
		// La console affiche :
			//Je suis un serveur en attende la connexion d'un client
		// Donc le server est UP et attent d'une request.
	}catch(IOException e) {
		System.out.println(e.getMessage());
		}
	}

}
