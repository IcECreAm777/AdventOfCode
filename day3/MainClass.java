package day3;

public class MainClass {

	public static void main(String[] args) {

		System.out.println("Program started");
		
		int input = 347991;
		
		System.out.println("Part 1 of Day 3");
		
		/* http://www.guideforschool.com/1260759-java-program-to-print-circular-spiral-matrix/ */
		/**length of Array**/
		int n = 640;
		
		int A[][] = new int[n][n];
        int k=n*n, c1=0, c2=n-1, r1=0, r2=n-1;

        while(k>0) {
            for(int i=c1;i<=c2;i++) {
                A[r1][i]=k--;
            }

            for(int j=r1+1;j<=r2;j++) {
                A[j][c2]=k--;
            }

            for(int i=c2-1;i>=c1;i--) {
                A[r2][i]=k--;
            }

            for(int j=r2-1;j>=r1+1;j--) {
                A[j][c1]=k--;
            }

            c1++;
            c2--;
            r1++;
            r2--;
        }
		
        int[] pos1 = new int[2];
        int[] posInput = new int[2];
		/*get positions of 1 and input*/
        for(int i = 0; i < A.length; i++) {
        	for(int j = 0; j < A[i].length; j++) {
        		if(A[i][j] == 1) {
        			pos1[0] = i;
        			pos1[1] = j;
        		}
        		if(A[i][j] == input) {
        			posInput[0] = i;
        			posInput[1] = j;
        		}
        	}
        }
        
        System.out.println(Math.abs(pos1[0] - posInput[0]) + Math.abs(pos1[1] - posInput[1]));
        System.out.println("Part 2 of Day 3");
        
        int[][] B = new int[n][n];
        
        B[n/2][n/2] = 1;
        
        System.out.println("Program Ended");
	}

}
