package online.held_der_zeit.finalmix.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import online.held_der_zeit.finalmix.lib.StringsFM;
import online.kingdomkeys.kingdomkeys.capability.IPlayerCapabilities;
import online.kingdomkeys.kingdomkeys.capability.ModCapabilities;
import online.kingdomkeys.kingdomkeys.client.gui.elements.MenuBackground;
import online.kingdomkeys.kingdomkeys.client.gui.elements.buttons.MenuButton;
import online.kingdomkeys.kingdomkeys.client.gui.menu.MenuScreen;
import online.kingdomkeys.kingdomkeys.util.Utils;

import java.awt.*;

public class FinalMixMenu extends MenuScreen {

    //main menu
    public FinalMixMenu() {
        super();
        minecraft = Minecraft.getInstance();
    }

    public enum FMButtons {
        //FM_COLORS,
        COMMAND_DECK,
        COMMAND_BOARD
    }

    MenuButton commandDeck, commandBoard;

    protected void action(FMButtons buttonID) {
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

    @Override
    public void init(){

        Player player;
        final IPlayerCapabilities playerData = ModCapabilities.getPlayer(minecraft.player);

        //super.width = width;
        //super.height = height;
        super.init();

        float lowBarHeight = (float) height * 0.17F;
        int start = (int)(lowBarHeight) +20;
        int pos = 0;

        float buttonPosX = (float) width * 0.80F;
        float buttonWidth = ((float) width * 0.1744F) - 22;

        addRenderableWidget(commandDeck = new MenuButton((int) buttonPosX, start, (int) buttonWidth, (StringsFM.Menu_Button_Command_Deck), MenuButton.ButtonType.BUTTON, true, (e) -> {
            action(FMButtons.COMMAND_DECK);

        }));


        addRenderableWidget(commandBoard = new MenuButton((int) buttonPosX, start + 18 * ++pos, (int) buttonWidth, (StringsFM.Menu_Button_Command_Board), MenuButton.ButtonType.BUTTON, true, (e) -> {
            action(FMButtons.COMMAND_BOARD);
        }));

    }
}
