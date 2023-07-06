package swing;

public class Resta implements Strategy {

	@Override
	public Integer operar(Integer val1, Integer val2) {
		return val1 - val2;
	}

}
