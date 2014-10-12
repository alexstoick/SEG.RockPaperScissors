package com.alexstoick.SEG.RockPaperScissor;

/**
 * Created by alexstoick on 10/8/14.
 */
public class GameManagement {

	private static final String WAITING_FOR_FIRST_PLAYER = "Waiting for 1st player" ;
	private static final String WAITING_FOR_SECOND_PLAYER = "Waiting for 2nd player" ;
	private static final String WAITING_FOR_FIRST_PLAYER_CHOICE = "Waiting for player choice" ;
	private static final String WAITING_FOR_SECOND_PLAYER_CHOICE = "Waiting for 2nd player choice" ;
	private static final String FINISHED = "Finished" ;
	private static final String ERROR = "Error!!" ;

	private static String[] choices ;

	private static final String[] GAME_STATES = { WAITING_FOR_FIRST_PLAYER, WAITING_FOR_SECOND_PLAYER,
			WAITING_FOR_FIRST_PLAYER_CHOICE, WAITING_FOR_SECOND_PLAYER_CHOICE, FINISHED } ;
	private static int current_state = 0 ;

	public static String getCurrentState() {
		return GAME_STATES[current_state];
	}

	private static int test = 0 ;

	public static void playerMadeChoice( int playerID , String choice ){
		choices[playerID] = choice ;
		++current_state ;
		System.out.println ( "Game status after choice: " + getCurrentState () );
	}

	public static boolean cannotMakeChoice( String state) {
		if ( state != WAITING_FOR_FIRST_PLAYER_CHOICE )
			return false ;
		return true ;
	}

	public static void update_status( String newStatus ) {
		if ( getCurrentState() != newStatus )
		{
			++current_state;
		}
	}


	public static String playerJoined() {
		if( getCurrentState () == WAITING_FOR_FIRST_PLAYER ) {
			return GAME_STATES[++current_state];
		}
		if( getCurrentState () == WAITING_FOR_SECOND_PLAYER ) {
			return GAME_STATES[++current_state];
		}
		return ERROR;
	}

}
