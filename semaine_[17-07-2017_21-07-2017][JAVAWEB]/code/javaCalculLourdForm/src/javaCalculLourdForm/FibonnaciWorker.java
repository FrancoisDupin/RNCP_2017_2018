package javaCalculLourdForm;

public class FibonnaciWorker implements Runnable {

	private int requestedNumber;
	private String workerName;
	
	public int getRequestedNumber() {return requestedNumber;}
	public void setRequestedNumber(int requestedNumber) {this.requestedNumber = requestedNumber;}
	public String getWorkerName() {return workerName;}
	public void setWorkerName(String workerName) {this.workerName = workerName;}

	public FibonnaciWorker(int requestedNumber, String workerName) {
		super();
		setRequestedNumber(requestedNumber);
		setWorkerName(workerName);
	}

	private long fibonnaci(long n) {
		if (n <= 1)
			return n;
		else
			return fibonnaci(n - 1) + fibonnaci(n - 2);
	}

	@Override
	public void run() {
		System.out.println(getWorkerName() + " je demarre");
		System.out.println(getWorkerName() + " -> fib(" + getRequestedNumber()+") = " 
					+  fibonnaci(requestedNumber));
	}

}
