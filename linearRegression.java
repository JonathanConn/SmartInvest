package InvestRobo;

import java.util.ArrayList;

public class linearRegression {
	
	public double calcXMean(double[][] data) {
		double xmean = 0;
		//addup x
		for(int i = 0; i < data.length; i++) {
			xmean += data[i][0];
		}
		
		xmean = xmean / data.length;
	
		System.out.println("X av: "+xmean);
		System.out.println("\n------------\n");
		
		return xmean;
		
	}
	public double calcYMean(double[][] data) {
		double ymean = 0;

		//addup y
		for(int i = 0; i < data.length; i++) {
			ymean += data[i][1];
		}
				
		ymean = ymean / data.length;
		
		System.out.println("Y av: "+ymean);
		System.out.println("\n------------\n");
		
		return ymean;
		
	}
	
	
	
	public double[] xmsqr(double[][] data, int size, double xmean){
		System.out.println("(x-xmean)^2");
		double[] array = new double[size];
		
		for(int i = 0; i < array.length; i++) {
			array[i] = Math.abs((data[i][0]-xmean)*(data[i][0]-xmean));
			System.out.println(array[i]);
		}
		System.out.println("\n------------\n");
		return array;
	}
	
	public double[] xymean(double[][] data, int size, double xmean, double ymean) {
		System.out.println("(x-xmean)(y-ymean)");
		double[] array = new double[size];
		
		for(int i = 0; i < array.length; i++) {
			array[i] = Math.abs((data[i][0]-xmean)*(data[i][1]-ymean));
			System.out.println(array[i]);
		}
		System.out.println("\n------------\n");
		return array;
	}
	
	public double calcB1(double[] x, double[] xy){
		System.out.println("calc b1");
		double xtotal=0;
		double xytotal=0;
		
		for(int i=0;i<x.length;i++)xtotal+=x[i];
		for(int i=0;i<xy.length;i++)xytotal+=xy[i];
		
		System.out.print("b1: "+(xytotal/xtotal)/10);
		System.out.println("\n------------\n");
		return (xytotal/xtotal)/10;
		
	}
	public double calcB2(double b1, double xmean, double ymean) {
		System.out.println("calc b2");
		System.out.println(ymean-(b1*xmean));
		System.out.println("\n------------\n");
		return (ymean-(b1*xmean));
	}

}
