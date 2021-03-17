package view;

import java.util.concurrent.Semaphore;

import controller.ThreadServidor;

public class Main {

	public static void main(String[] args) {
		
		int permissao = 1;
		Semaphore semaforo = new Semaphore(permissao);
		
		for(int i=1;i<=21;i++){
			Thread tServidor = new ThreadServidor(i, semaforo);
			tServidor.start();
		}

	}

}
