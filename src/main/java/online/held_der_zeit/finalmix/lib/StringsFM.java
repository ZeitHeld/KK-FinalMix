package online.held_der_zeit.finalmix.lib;

import online.held_der_zeit.finalmix.KingdomKeysFinalMix;

public class StringsFM {

	public static final String
		FM = KingdomKeysFinalMix.MODID,
		Command_Board = ".command_board",
		Command_Deck = ".command_deck",

		Command_Melding = Command_Deck + ".melding",
		Command_List = Command_Deck + ".list",
		Command_Deck_Edit = Command_Deck + ".edit",

		Command_Board_Play = Command_Deck + ".play",

		Gui = "gui." + FM,

		KK_Menu = Gui + ".menu",
		Menu_Button = KK_Menu + ".button",

		Menu_Button_Command_Board = Menu_Button + Command_Board,
		Menu_Button_Command_Deck = Menu_Button + Command_Deck,

		Menu_Button_Command_Melding = Menu_Button + Command_Melding,
		Menu_Button_Command_List = Menu_Button + Command_List,
		Menu_Button_Command_Deck_Edit = Menu_Button + Command_Deck_Edit,

		Menu_Button_Command_Board_Play = Menu_Button + Command_Board_Play,


		Dummy = "dummy"
		;
}
