package com.CiD.MysteryMod.TecEvolution;

public class TecDATA {

	/**ALL THE MAX ENERGYs */
	
	
	/** Drains*/
	
	/** Producer **/
	public static final int NUCELEAR_PRODUCE = 1000000;
	
	
	/** MACHINES**/
	public static final int MINER_PER_BLOCK = 1000;
	public static final int BENDER_PER_TICK = 200;
	public static final int PRESSURE_SMELTER_PER_TICK = 1000;
	public static final int ATOMIC_MINER_PER_BLOCK = 1000;

	
	
	
	/** OTHER VALUES**/
	public static final int MINER_DIG_Y = 30;
	
	
	public static final int ATOMIC_MINER_DIG_Y = 30;
	public static final int ATOMIC_MINER_DIG_X = 30;
	public static final int ATOMIC_MINER_DIG_Z = 30;

	/** BUrningTIMES**/
	public static final int BENDER_BURNINGTIME = 5*20;
	public static final int PRESSURE_SMELTER_BURNINGTIME = 60*20;
	
	
	//CRACKER STUFF
	public static final int CRACKER_TO_SAND = 0;
	public static final int CRACKER_TO_CUBBLE = 1;
	public static final int CRACKER_TO_DIRT = 2;
	
	public static final int[] CRACKER_BURNING_TIME = {
		2*20,
		3*20,
		2*20
	};

	
	//DROID STUFF
	public static final int DROID_COOLDWON = 20*5;

}
