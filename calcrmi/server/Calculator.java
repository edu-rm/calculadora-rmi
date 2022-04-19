package calcrmi.server;

import java.rmi.RemoteException;

public class Calculator implements CalcInterface{
	public float add(float a, float b) throws RemoteException {
		return a + b;
	}
	public float sub(float a, float b) throws RemoteException {
		return a - b;
	}
	public float mult(float a, float b) throws RemoteException {
		return a * b;
	}
	public float div(float a, float b) throws RemoteException{
		return a / b;
	}
}
