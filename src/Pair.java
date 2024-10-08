
public class Pair<T,U> {
	private T firstv;
	private U secondv;
	
	public Pair(T firstv,U secondv) {
		this.firstv = firstv;
		this.secondv = secondv;
	}
	public T getFirst(){
		return firstv;
	}
	public U getSecond() {
		return secondv;
	}
	public void setFirst(T newFirst) {
		firstv = newFirst;
	}
	public void setSecond(U newSec) {
		secondv = newSec;
	}
	public static void main(String[] args) {
		Pair<Integer,Integer>intPair = new Pair<>(1,2);
		Pair<Double,String>mixPair = new Pair<>(1.34,"Hello World");
		
		Pair<Pair<Integer,Integer>,Pair<Double,String>>pairPair = new Pair <>(intPair,mixPair);
	}
}
