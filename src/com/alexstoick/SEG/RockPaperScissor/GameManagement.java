package com.alexstoick.SEG.RockPaperScissor;

/**
 * Created by alexstoick on 10/8/14.
 */
public class GameManagement {

	private static final String WAITING_FOR_FIRST_PLAYER = "Waiting for 1st player" ;
	private static final String WAITING_FOR_SECOND_PLAYER = "Waiting for 2nd player" ;
	private static final String WAITING_FOR_FIRST_PLAYER_CHOICE = "Waiting for 1st player choice" ;
	private static final String WAITING_FOR_SECOND_PLAYER_CHOICE = "Waiting for 2nd player choice" ;
	private static final String FINISHED = "Finished" ;
	private static final String ERROR = "Error!!" ;

	private static final String[] GAME_STATES = { WAITING_FOR_FIRST_PLAYER, WAITING_FOR_SECOND_PLAYER,
			WAITING_FOR_FIRST_PLAYER_CHOICE, WAITING_FOR_SECOND_PLAYER_CHOICE, FINISHED } ;
	private static int current_state = 0 ;

	public static String getCurrentState() {
		return GAME_STATES[current_state];
	}

	public static String playerJoined() {
		if( getCurrentState () == WAITING_FOR_FIRST_PLAYER ) {
			return GAME_STATES[++current_state];
		}
		if( getCurrentState () == WAITING_FOR_SECOND_PLAYER ) {
			return GAME_STATES[++current_state];
		}
		return "Error!";
	}

}
