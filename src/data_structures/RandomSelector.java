package data_structures;

import java.util.ArrayList;

public class RandomSelector<T> {
	private ArrayList<T> objects = new ArrayList<>();
	private ArrayList<Double> scores = new ArrayList<>();

	private double totalScore = 0.0;

	public void add(T obj, double score) {
		this.objects.add(obj);
		this.scores.add(score);
		this.totalScore += score;
	}

	public T random() {
		double x = Math.random() * this.totalScore;
		double runningSum = 0.0;

		for (int i = 0; i < this.objects.size(); i++) {
			runningSum += this.scores.get(i);
			if (runningSum > x) {
				return this.objects.get(i);
			}
		}

		return null;
	}

	public void reset() {
		this.objects.clear();
		this.scores.clear();
		this.totalScore = 0.0;
	}
}
