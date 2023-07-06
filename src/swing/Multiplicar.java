package swing;

public class Multiplicar implements Strategy {

	@Override
	public Integer operar(Integer val1, Integer val2) {
		return val1 * val2;
	}

}
