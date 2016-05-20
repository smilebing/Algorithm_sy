package sy1;

//背包算法
/*
 *    背包问题描述如下:  已知
   背包容量M=120
   物品种类数n=10
   各种物品的总效益pi(i=1,2,………10) : 50,60,70,80,90,80,70,60,50,40
   各种物品的总重量wi(i=1,2………10) : 17,30,25,41,80,70,64,56,47,38
求: 各种物品所取重量占其总重量的比例xi(i=1,2,…..10),满足0<=xi<=1,
    达到最大值.
基本要求
按三种不同的量度标准分别计算所得最大总效益,然后比较哪个最大
按效益值由大到小取物品. 2. 按重量值由小到大取物品
3.按比值pi/wi的值由大到小取物品

 */
public class Main {

	public static void main(String[] args) {

		int bag = 120;
		int[] weigth = { 17, 30, 25, 41, 80, 70, 64, 56, 47, 38 };
		int[] value = { 50, 60, 70, 80, 90, 80, 70, 60, 50, 40 };
		getMaxValue(weigth, value, bag);
		getMaxWeigth(weigth, value, bag);
		getMaxAverage(weigth, value, bag);
	}

	public static void sort(int w[], int v[]) {
		for (int i = 0; i < w.length - 1; i++) {
			for (int j = w.length - 1; j > i; j--) {
				if (w[j] > w[j - 1]) {
					int temp = w[j - 1];
					w[j - 1] = w[j];
					w[j] = temp;

					temp = v[j - 1];
					v[j - 1] = v[j];
					v[j] = temp;
				}
			}
		}
	}
	
	public static void sort(int w[], int v[],double average[])
	{
		for (int i = 0; i < average.length - 1; i++) {
			for (int j = average.length - 1; j > i; j--) {
				if (average[j] > average[j - 1]) {
					double temp = average[j - 1];
					average[j - 1] = average[j];
					average[j] = temp;
					
					int t=v[j-1];
					v[j - 1] = v[j];
					v[j] = t;
					
					t=w[j-1];
					w[j-1]=w[j];
					w[j]=t;
							
				}
			}
		}
	}

	public static void printArray(int w[], int v[]) {
		for (int i = 0; i < w.length; i++) {
			System.out.print(w[i] + " ");
		}
		System.out.println();

		for (int j = 0; j < v.length; j++) {
			System.out.print(v[j] + " ");
		}
		System.out.println();
		System.out.println();
	}

	public static void printArray(int w[], int v[], double result[],double value) {
		for (int i = 0; i < w.length; i++) {
			System.out.print(w[i] + " ");
		}
		System.out.println();

		for (int j = 0; j < v.length; j++) {
			System.out.print(v[j] + " ");
		}
		System.out.println();

		for (int j = 0; j < result.length; j++) {
			System.out.print(new java.text.DecimalFormat("#0.00").format( result[j])+ " ");
		}
		System.out.println();
		System.out.println("sum value:" + new java.text.DecimalFormat("#0.00").format(value));
	}

	public static void getMaxValue(int w[], int v[], int bag) {
		// key=value
		sort(v, w);
		double value = 0;
		double[] temp = new double[w.length];

		int i = 0;
		while (bag >= 0)
		{
			if (w[i] <= bag) {
				bag = bag - w[i];
				value = value + v[i];
				temp[i] = 1;
				i++;
			} else 
			{
				double tempb = bag;
				double tempw = w[i];
				double tempv = v[i];
				value = (tempb / tempw) * tempv + value;
				temp[i] = tempb / tempw;
				i++;

				System.out.println();
				System.out.println("max value");
				printArray(w, v, temp, value);
				return;
			}
		}
	}

	public static void getMaxWeigth(int w[], int v[], int bag) {
		// key=weight
		sort(w, v);
		double value = 0;
		double[] temp = new double[w.length];

		int i = w.length-1;
		while (bag >= 0) {
			if (w[i] <= bag) {
				bag = bag - w[i];
				value = value + v[i];
				temp[i] = 1;
				i--;
			} else {
				double tempb = bag;
				double tempw = w[i];
				double tempv = v[i];
				value = (tempb / tempw) * tempv + value;
				temp[i] = tempb / tempw;
				i--;
				
				System.out.println();
				System.out.println("max weight");
				printArray(w, v, temp, value);
				return;
			}
		}
	}
	
	public static void getMaxAverage(int w[], int v[], int bag) {
		
		double tempWeight=0;
		double tempValue=0;
		double []average=new double [w.length];
		for(int i=0;i<w.length;i++)
		{
			tempWeight=w[i];
			tempValue=v[i];
			average[i]=tempValue/tempWeight;
		}
		
		//key=average
		sort(w, v, average);
		//print the average
//		for(int i=0;i<average.length;i++)
//		{
//			System.out.print(average[i]+" ");
//		}
//		System.out.println();
		
		double value = 0;
		double[] temp = new double[w.length];

		int i = 0;
		while (bag >= 0) {
			if (w[i] <= bag) {
				bag = bag - w[i];
				value = value + v[i];
				temp[i] = 1;
				i++;
			} else {
				double tempb = bag;
				double tempw = w[i];
				double tempv = v[i];
				value = (tempb / tempw) * tempv + value;
				temp[i] = tempb / tempw;
				i++;

				System.out.println();

				System.out.println("max average");
				printArray(w, v, temp, value);
				return;
			}
		}
	}
	
}

