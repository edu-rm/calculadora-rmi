package calcrmi.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import calcrmi.server.*;

public class CalcClient {
	public static void main(String[] args) {
		try {
			Registry registro = LocateRegistry.getRegistry("172.16.8.49", 12345);
			
			// bind a gente registra e lookup procuramos
			CalcInterface calc = (CalcInterface) registro.lookup("CalcRemote");
			
			int opc = 0;
			
			Scanner sc = new Scanner(System.in);
			
			do {
				System.out.println("1 - Somar");
				System.out.println("2 - Subtrair");
				System.out.println("3 - Multiplicar");
				System.out.println("4 - Dividir");
				System.out.println("Escolha uma opção:");
				
				opc = (int) sc.nextInt();
				
				System.out.println("Forneça dois números:");
				
				float a = sc.nextFloat();
				float b = sc.nextFloat();
				float resp = 0;
				switch (opc) {
					case 1: 
						resp = calc.add(a, b);
						break;
					case 2: 
						resp = calc.sub(a, b);
						break;
					case 3: 
						resp = calc.mult(a, b);
						break;
					case 4: 
						resp = calc.div(a, b);
						break;
					default: 
						opc = 0;
						break;
				}
				
				System.out.println("Resposta " + resp);
			} while (opc != 0);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
}
