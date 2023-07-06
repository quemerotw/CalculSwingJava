package swing;

public class Suma implements Strategy{

	@Override
	public Integer operar(Integer val1,Integer val2) {
		return val1+val2;
	}
}
