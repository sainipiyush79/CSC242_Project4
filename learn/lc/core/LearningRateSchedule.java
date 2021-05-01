package learn.lc.core;

public interface LearningRateSchedule {
	
	/**
	 * Return the learning rate alpha for the given iteration t.
	 * (AIMA p. 725).
	 */
	 //less acurate answer from Decaying Learning Rate
	public double alpha(int t);

}
