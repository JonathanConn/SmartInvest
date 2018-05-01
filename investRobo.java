package InvestRobo;

import java.util.ArrayList;

public class investRobo {

	public static void main(String[] args) {
		
	readFile r = new readFile();
	r.convertToArray();
	
	linearRegression reg = new linearRegression();
	
	double[][] mean = r.createArray();
	double[] meansq = new double[r.findRowNumber()];
	double[] xymean = new double[r.findRowNumber()];

	double xmean = reg.calcXMean(mean);
	double ymean = reg.calcYMean(mean);

	

	
	meansq = reg.xmsqr(mean, meansq.length, xmean);
	
	xymean = reg.xymean(mean, xymean.length, xmean, ymean);
	
	double b1 = reg.calcB1(meansq, xymean);
	double b2 = reg.calcB2(b1, xmean, ymean);
	
	//y=b2+b1x
	
	}

}
