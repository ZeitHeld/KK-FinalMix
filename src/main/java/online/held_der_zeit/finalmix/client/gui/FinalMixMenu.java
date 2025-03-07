package online.held_der_zeit.finalmix.client.gui;

import net.minecraft.client.Minecraft;
import online.kingdomkeys.kingdomkeys.client.gui.elements.MenuBackground;
import online.kingdomkeys.kingdomkeys.client.gui.menu.MenuScreen;

import java.awt.*;

public class FinalMixMenu extends MenuScreen {

    //main menu
    public FinalMixMenu() {
        super();
        minecraft = Minecraft.getInstance();
    }

    public enum FMbuttons {
        //FM_COLORS,
        COMMAND_DECK,
        COMMAND_BOARD
    }

    protected void action(FMbuttons buttonID) {
        MenuBackground selectedScreen = new MenuScreen();
        //super.action(buttonID);

        switch(buttonID) {
            case COMMAND_DECK:
                selectedScreen = new CommandDeckMenu();
                //minecraft.setScreen(new CommandDeckMenu());
            case COMMAND_BOARD:
                selectedScreen = new CommandBoardMenu();
                //minecraft.setScreen(new CommandBoardMenu());
        }

        minecraft.setScreen(selectedScreen);
    }
}
