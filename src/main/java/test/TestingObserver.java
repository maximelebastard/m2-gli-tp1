package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;


public class TestingObserver implements Observer
{
	
	private List<Observable> observables = new ArrayList<Observable>();
	private List<Object> args = new ArrayList<Object>();

	public void update(Observable o, Object arg) {
		observables.add(o);
		args.add(arg);
	}

	/**
	 * @return the observables
	 */
	public List<Observable> getObservables() {
		return observables;
	}

	/**
	 * @param observables the observables to set
	 */
	public void setObservables(List<Observable> observables) {
		this.observables = observables;
	}

	/**
	 * @return the args
	 */
	public List<Object> getArgs() {
		return args;
	}

	/**
	 * @param args the args to set
	 */
	public void setArgs(List<Object> args) {
		this.args = args;
	}
	
	

}
