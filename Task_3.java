public class Task_3 {
	private static int count=0;	// Записываем первую возможность
	private static int N=8;
	public static void main(String[] args) {
		int[][] arr=new int[N][N];	// Элемент по умолчанию - 0 1, когда ферзь
		eightQueen(0,arr);	// Вывести все возможные решения восьми ферзей и начать с первой строки 0
	}
	//row [0,7]
	private static void eightQueen(int row, int[][] arr) {
		if(row==N){// Условие печати, при условии, что это 8 ферзей, оно будет печататься каждый раз, когда достигнет 9-й строки.
			count++;
			System.out.println(" "+count+"Виды:");
			for(int i=0;i<arr.length;i++){
				for(int j=0;j<arr[i].length;j++){
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
		}else{
			// Делаем резервную копию массива
			int[][] newArr=new int[N][N];
			for(int i=0;i<arr.length;i++){
				for(int j=0;j<arr[i].length;j++){
					newArr[i][j]=arr[i][j];
				}
			}
			for(int col=0;col<N;col++){
			/*
			 Определите, есть ли ферзь вверху, вверху слева и вверху справа от текущего элемента.
			*/
				if(noDangerous(row,col,newArr)){
					for(int c=0;c<N;c++){
						newArr[row][c]=0;// Устанавливаем ферзя в других позициях текущей строки на 0
					}
					newArr[row][col]=1;
					eightQueen(row+1, newArr);
				}
			}
		}	
	}
	private static boolean noDangerous(int row, int col, int[][] newArr) {
		//Наверху
		for(int r=row-1;r>=0;r--){
			if(newArr[r][col]==1){
				return false;
			}
		}
		//Верхний левый
		for(int r=row-1,c=col-1;r>=0&&c>=0;r--,c--){
			if(newArr[r][c]==1){
				return false;
			}
		}
		//В правом верхнем углу
		for(int r=row-1,c=col+1;r>=0&&c<N;r--,c++){
			if(newArr[r][c]==1){
				return false;
			}
		}
		return true;
	}
}