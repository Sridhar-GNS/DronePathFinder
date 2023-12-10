
import java.util.Scanner;
public class DronePathFinder {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);

        System.out.println("Enter number of rows for grid: ");
        int rows= scan.nextInt();

        System.out.println("Enter number of cols for grid: ");
        int cols= scan.nextInt();

        int[][] dronePositions= new int[4][2];
        for(int i=0;i<4;i++)
        {
            System.out.println("Enter Drone"+ (i+1)+ "position (x y): ");
            int x=scan.nextInt();
            int y= scan.nextInt();
            validatePosition(x,y,rows,cols);
            dronePositions[i][0]=x;
            dronePositions[i][1]=y;
        }

        System.out.println("Enter Target position (x y): ");
        int targetX= scan.nextInt();
        int targetY= scan.nextInt();
        validatePosition(targetX, targetY,rows, cols);

        for(int i=0;i<4;i++)
        {
            System.out.println("Drone"+ (i+1)+"Path:");
            findPath(dronePositions[i][0],dronePositions[i][1],targetX,targetY);
            System.out.println();
        }
        scan.close();
    }

    private static void validatePosition(int x, int y, int rows, int cols){
        if(x<0||x>rows || y<0 || y>=cols){
            System.err.println("Invalid position.Position should be inside grid");
            System.exit(1);
        }
    }

    private static void findPath(int startX,int startY, int targetX, int targetY){
        while(startX!=targetX || startY!=targetY){
            System.out.println(" Move to: ("+ startX+ " , "+startY+")" );
            if(startX<targetX){
                startX++;
            }else if(startX>targetX){
                startX--;
            }
            if(startY<targetY){
                startY++;
            }else if(startY>targetY){
                startY--;
            }

        }

        System.out.println("Target reached at:("+startX+","+startY+")");
    }
}
