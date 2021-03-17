package controller;
import java.util.concurrent.Semaphore;

public class ThreadServidor extends Thread {
	
	private int Id;
	private Semaphore semaforo;
	private int tempo;
	
	public ThreadServidor(int Id, Semaphore semaforo){
		this.Id = Id;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		if (Id%3==1){
			tempo = (int)((Math.random() * 801) + 200);
			Calculo();
			tempo = 1000;
			try {
				semaforo.acquire();
				Transferencia();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally{
				semaforo.release();
			}
			tempo = (int)((Math.random() * 801) + 200);
			Calculo();
			tempo = 1000;
			try {
				semaforo.acquire();
				Transferencia();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally{
				semaforo.release();
			}	
		}else if(Id%3==2){
			tempo = (int)((Math.random() * 1001) + 500);
			Calculo();
			tempo = 1500;
			try {
				semaforo.acquire();
				Transferencia();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally{
				semaforo.release();
			}
			tempo = (int)((Math.random() * 1001) + 500);
			Calculo();
			tempo = 1500;
			try {
				semaforo.acquire();
				Transferencia();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally{
				semaforo.release();
			}
			tempo = (int)((Math.random() * 1001) + 500);
			Calculo();
			tempo = 1500;
			try {
				semaforo.acquire();
				Transferencia();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally{
				semaforo.release();
			}
			}else if(Id%3==0){
				tempo = (int)((Math.random() * 1001) + 1000);
				Calculo();
				tempo = 1500;
				try {
					semaforo.acquire();
					Transferencia();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally{
					semaforo.release();
				}
				tempo = (int)((Math.random() * 1001) + 1000);
				Calculo();
				tempo = 1500;
				try {
					semaforo.acquire();
					Transferencia();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally{
					semaforo.release();
				}
				tempo = (int)((Math.random() * 1001) + 1000);
				Calculo();
				tempo = 1500;
				try {
					semaforo.acquire();
					Transferencia();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally{
					semaforo.release();
				}
			}
	}
	
	private void Calculo(){
		double espera = (double) tempo/1000;
		System.out.println("A Thread "+Id+" calculou por "+espera+" segundos");
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void Transferencia(){
		double espera = (double) tempo/1000;
		System.out.println("A Thread "+Id+" transferiu para o BD por "+espera+" segundos");
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
