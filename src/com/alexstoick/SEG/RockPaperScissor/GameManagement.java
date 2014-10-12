package com.alexstoick.SEG.RockPaperScissor;

/**
 * Created by alexstoick on 10/8/14.
 */
public class GameManagement {

	public static final String WAITING_FOR_FIRST_PLAYER = "Waiting for 1st player" ;
	public static final String WAITING_FOR_SECOND_PLAYER = "Waiting for 2nd player" ;
	public static final String WAITING_FOR_FIRST_PLAYER_CHOICE = "Waiting for player choice" ;
	public static final String WAITING_FOR_SECOND_PLAYER_CHOICE = "Waiting for 2nd player choice" ;
	public static final String FINISHED = "Finished" ;
	public static final String ERROR = "Error!!" ;

	private static String[] choices = new String[2];
	private static int winnerID = 0; ;

	private static final String[] GAME_STATES = { WAITING_FOR_FIRST_PLAYER, WAITING_FOR_SECOND_PLAYER,
			WAITING_FOR_FIRST_PLAYER_CHOICE, WAITING_FOR_SECOND_PLAYER_CHOICE, FINISHED } ;
	private static int current_state = 0 ;

	public static String getCurrentState() {
		return GAME_STATES[current_state];
	}

	public static int getWinnerID () {
		return winnerID;
	}

	public static void playerMadeChoice( int playerID , String choice ){
		choices[playerID-1] = choice ;
		++current_state ;
		System.out.println ( "Game status after choice: " + getCurrentState () );
		if ( getCurrentState ().equals(FINISHED))
		{
			computeWinner () ;
		}
	}

	public static String getOtherPlayerChoice( int playerID ) {
		return choices[(playerID+1)%2];
	}

	public static boolean isFinished( String state ) {
		if ( state.equals(FINISHED) ) {
			computeWinner();
			return true ;
		}
		return false ;

	}

	public static void computeWinner() {
		if ( winnerID != 0 )
			return ;
		winnerID = 1 ;
	}

	public static boolean canMakeChoice( String state) {
		if ( state.equals(WAITING_FOR_FIRST_PLAYER_CHOICE) ) {
			return true;
		}
		return false;
	}

	public static String playerJoined() {
		if( getCurrentState ().equals( WAITING_FOR_FIRST_PLAYER ) ) {
			return GAME_STATES[++current_state];
		}
		if( getCurrentState ().equals(WAITING_FOR_SECOND_PLAYER) ) {
			return GAME_STATES[++current_state];
		}
		return ERROR;
	}

}
