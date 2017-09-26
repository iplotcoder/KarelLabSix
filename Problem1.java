
import kareltherobot.*; 


/**
 * @author :  D. Appel
 */
public class Problem1 extends BeeperBot
{
    int[] beeperList = new int[8];
    int tempCount = 0;
    int avenue = 0;
    
    public Problem1(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
    }
    
    public void sortBeepers() {
        firstPosition();
        runRace();
        getBeeperList();
        sortList();
    }
    
    public void sortList() {
        
    }
    
    public int[] getBeeperList() {
            //This will be used to print the beepers found.  No need to modify.
            return beeperList;
    }
    
    public void runRace() {
        while(frontIsClear() && avenue < 7) {
            collectBeepers();
        }
    }
   
    public void collectBeepers() {
        faceEast();
        findABeeperColumn();
        collectColumn();
        returnToFloor();
    }
    
    public void firstPosition()  {
        turnLeft();
        move7();
        turnRight();
        move();
        turnAround();
    }
    
    public void faceEast() {
        while(!facingEast()) {
            turnLeft();
        }
    }
    
    public void findABeeperColumn()  {
        while(!nextToABeeper()) {
            move();
            avenue ++;
        }
    }
    
    public void collectColumn()  {
        pickBeeper();
        tempCount ++;
        turnLeft();
        move();
        while(nextToABeeper())  {
            pickBeeper();
            tempCount ++;
            move();
        }
        beeperList[avenue] = tempCount;
        tempCount = 0;
    }
    
    public void returnToFloor()  {
        turnAround();
        while(frontIsClear())  {
            move();
        }
        turnLeft();
    }
    
    public void move7()  {
        move();
        move();
        move();
        move();
        move();
        move();
        move();
    }
    
    public void turnRight()  {
        turnLeft();
        turnLeft();
        turnLeft();
    }
    
    public void turnAround()  {
        turnLeft();
        turnLeft();
    }
}

