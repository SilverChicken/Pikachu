package machine_learning;

public class TargetMaker {

	public static void main(String[] args) {
		int[] thingz = {0,1,0,1,1,1,1 ,0,1,1,0,1,0  ,0,0,1,0  ,1,1,1,0,0,1,0,1,1   ,1,1,0,1,0,1,0     ,1,1,1,1,0,0,0,0,1,1   ,1,1,0,0,1,0,1,0    ,0,0,1,1,0,0,1    ,1,1,1,0,1,1,0,0   ,1,1,1,0,0,1,1,0,0,1    ,0,0,0,0,1,0,1,1,1,0   ,0,1,0,1,0,1,0,1,1,0,1,0,0,0};
		for(int i = 0;i<thingz.length;i++){
			System.out.println("{"+thingz[i]+".0},");
		}

	}

}
