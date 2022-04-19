package calcrmi.server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Servidor {
	public static void main(String[] args) {
		try {
			System.setProperty("java.rmi.server.hostname", "localhost");
			
			// Serviço de registro de nomes
			Registry registro = LocateRegistry.createRegistry(7766);
			
			Calculator calc = new Calculator();
			
			// Objeto remoto pronto para publicar
			CalcInterface calcRemote = (CalcInterface) UnicastRemoteObject.exportObject(calc, 0);
			
			// Publicando
			registro.bind("CalcRemote", calcRemote);
			
			System.out.println("Servidor Calc rodando.");
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException ae) {
			ae.printStackTrace();
		}
	}
}
