package ClientPackage;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// premiere etape :
		System.out.println("Je suis un client pas encore connecte...");
		
		// J'ai teste le server avec localhost et l'adresse IP
		
		// Socket s = new Socket("localhost", 1234);
		Socket s = new Socket("127.0.0.1", 1234);
		
		System.out.println("Je suis connecté");
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("choix : ");
		int x = sc.nextInt();
	
		OutputStream os = s.getOutputStream(); 
		os.write(x);
		
		System.out.println("Donner le nombre : ");
		int n = sc.nextInt();
		OutputStream os2 = s.getOutputStream(); 
		os2.write(n);
		
		InputStream is = s.getInputStream();
		int nb=is.read();
		System.out.println("Le nombre totale est: "+nb);
		
		//La derniere etape : Fermer socket
		s.close();
		// La console affiche :
			//Je suis un serveur en attende la connexion d'un client
			//un client est connecte
		// Le client est connecte sur le server localhost

	}

}
