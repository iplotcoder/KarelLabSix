
import kareltherobot.*; 


/**
 * @author :  D. Appel
 */
public class BeeperBot extends Robot
{
    //instance variable to store beeper count
    int[] beeperList = new int[13];
    int tempCount = 0;
    int avenue = 0;
    
    public BeeperBot(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
    }
    
    public void findAndCountBeepers() {
        runRace();
        getBeeperList();
    }
    
    public int[] getBeeperList() {
            //This will be used to print the beepers found.  No need to modify.
            return beeperList;
    }
    
    public void runRace() {
        while(frontIsClear() && avenue < 9) {
            collectBeepers();
        }
    }
   
    public void collectBeepers() {
        faceEast();
        findABeeperColumn();
        collectColumn();
        returnToFloor();
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
    
    public void turnAround()  {
        turnLeft();
        turnLeft();
    }
}

