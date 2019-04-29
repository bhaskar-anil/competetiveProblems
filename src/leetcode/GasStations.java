package leetcode;


import java.util.Arrays;
import java.util.List;


public class GasStations {
	
	public static int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {
        for(int i = 0; i < A.size(); i++) {
        	System.out.println("checking isCompletableStartingPoint at:"+i);
            if(isCompletableStartingPoint(i, A, B)) {
            	return i;
            }
            System.out.println("\n\n");
        }
        return -1;
    }

	private static boolean isCompletableStartingPoint(int i, List<Integer> a, List<Integer> b) {
		System.out.println("-------checking isCompletableStartingPoint start------");
		//move the car from i to i
		
		//to move the car we need track of following
		//fuel in car, initialize to 0
		int fuelInCar = 0;
		for(int j = i; j < a.size(); j++) {
			System.out.println("visiting at:"+j);
			//move car from i to i+1
			if(!canMove(j, fuelInCar, a.get(j), b.get(j))) {
				return false;
			} else {
				//need to update fuelInCar
				fuelInCar += a.get(j);
				fuelInCar -= b.get(j);
			}
		}
		for(int j = 0; j < i; j++) {
			System.out.println("visiting at:"+j);
			//move car from i to i+1
			if(!canMove(j, fuelInCar, a.get(j), b.get(j))) {
				return false;
			} else {
				//need to update fuelInCar
				fuelInCar += a.get(j);
				fuelInCar -= b.get(j);
			}
		}
		return true;
	}

	private static boolean canMove(int i, int fuelInCar, Integer gasAtStation, Integer costToMove) {
		if(fuelInCar + gasAtStation >= costToMove) {
			System.out.println("Possible to move=== fuelInCar:"+fuelInCar+" gasAtStation, "+gasAtStation+", total"+ (fuelInCar+gasAtStation)+" costToMove"+costToMove);
			return true;
		}
		System.out.println("Impossible to move=== fuelInCar:"+fuelInCar+" gasAtStation, "+gasAtStation+", total"+ (fuelInCar+gasAtStation)+" costToMove"+costToMove);
		return false;
	}

	public static void main(String[] args) {
		List<Integer> A1 = Arrays.asList(204, 918, 18, 17, 35, 739, 913, 14, 76, 555, 333, 535, 653, 667, 52, 987, 422, 553, 599, 765, 494, 298, 16, 285, 272, 485, 989, 627, 422, 399, 258, 959, 475, 983, 535, 699, 663, 152, 606, 406, 173, 671, 559, 594, 531, 824, 898, 884, 491, 193, 315, 652, 799, 979, 890, 916, 331, 77, 650, 996, 367, 86, 767, 542, 858, 796, 264, 64, 513, 955, 669, 694, 382, 711, 710, 962, 854, 784, 299, 606, 655, 517, 376, 764, 998, 244, 896, 725, 218, 663, 965, 660, 803, 881, 482, 505, 336, 279 ); 
		List<Integer> B1 = Arrays.asList(273, 790, 131, 367, 914, 140, 727, 41, 628, 594, 725, 289, 205, 496, 290, 743, 363, 412, 644, 232, 173, 8, 787, 673, 798, 938, 510, 832, 495, 866, 628, 184, 654, 296, 734, 587, 142, 350, 870, 583, 825, 511, 184, 770, 173, 486, 41, 681, 82, 532, 570, 71, 934, 56, 524, 432, 307, 796, 622, 640, 705, 498, 109, 519, 616, 875, 895, 244, 688, 283, 49, 946, 313, 717, 819, 427, 845, 514, 809, 422, 233, 753, 176, 35, 76, 968, 836, 876, 551, 398, 12, 151, 910, 606, 932, 580, 795, 187 ); 
		
		System.out.println(canCompleteCircuit(A1, B1));
	}
}
