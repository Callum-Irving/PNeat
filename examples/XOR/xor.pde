import neat.*;

Population p;
Trainer t = new XORTrainer();

class XORTrainer implements Trainer {
  public double fitness(Genome g) {
  	double error = 0.0;
  	
  	double[] inputs = new double[] {0.0, 0.0};
  	double output = g.predict(inputs)[0];
  	error += abs(output);
  	inputs[0] = 1.0;
  	output = g.predict(inputs)[0];
  	error += abs(output - 1.0);
  	inputs[1] = 1.0;
  	output = g.predict(inputs)[0];
  	error += abs(output);
  	inputs[0] = 0.0;
  	output = g.predict(inputs)[0];
  	error += abs(output - 1.0);
  	
  	return 4.0 - error;
  }
}

void setup() {
  size(400, 400);
  p = new Population(100);
}

void draw() {
  p.trainOn(t);
  Genome best = p.getBest();
}