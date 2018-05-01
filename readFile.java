package InvestRobo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;

public class readFile {
	File file = new File("/home/jonathan/Downloads/AAPL.csv");
	int row = 0; 
	double average = 0;
	String[][] items;
	String[][] predictedItems;
	
	
	public boolean checkIsFile() {
		return file.isFile();
	}
	
	public int findRowNumber() {
		row = 0;
		if(checkIsFile()) {
			
			try {
		
				BufferedReader reader = new BufferedReader(new FileReader(file));	
				while(reader.readLine() != null) {
					row++;
				}
				
				
			}catch(Exception e) {
				System.out.println(e);
			}
			
		}else {
			System.out.println("this is not a file");
		}
	return row;
	
	}
	
	public void convertToArray() {
		int r = 0;
		items = new String[findRowNumber()][7];
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			
			while((line = reader.readLine())!=null) {
				StringTokenizer z = new StringTokenizer(line,",");
				while(z.hasMoreTokens()) {
					for(int c = 0; c < 7; c++) {
						items[r][c] = z.nextToken();
						//System.out.println(r+"\t"+c+"\t"+items[r][c]);
					}
					r++;
				}
			}
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public void printArray() {
		
		for(int x = 0; x < items.length; x++) {
			System.out.printf("%s -",x);
			for(int y = 0; y < items[x].length; y++) {
				System.out.printf("%s ", items[x][y]);
			}
			System.out.println();
		
		}
	}
	
	public double[][] createArray(){
		
		double[][] array = new double[findRowNumber()][2];
		
		for(int i=0; i < array.length;i++) {
	//		items[i][0] = items[i][0].replace("-", "");
	//		System.out.println(Double.parseDouble(items[i][0]));
			array[i][0] = Double.parseDouble(items[i][0]);
		}
		for(int i=0; i < array.length;i++) {
	//		items[i][4] = items[i][4].replace("-", "");
	//		System.out.println(Double.parseDouble(items[i][4]));
			array[i][1] = Double.parseDouble(items[i][4]);
		}
			
		return array;	
	}
	
	public void printArray(double[][] array) {
			
			for(int x = 0; x < array.length; x++) {
				System.out.printf("%s -",x);
				for(int y = 0; y < array[x].length; y++) {
					System.out.printf("%s ", array[x][y]);
				}
				System.out.println();
			
			}
		}
	
	public void printArray(double[] array) {
		
		for(int x = 0; x < array.length; x++) {
			System.out.println(array[x]);
		
		}
	}
	
	
	
	
}
