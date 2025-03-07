package online.held_der_zeit.finalmix.client.gui;

import online.held_der_zeit.finalmix.network.PacketHandlerFM;
import online.held_der_zeit.finalmix.network.cts.CSFMOpenBoardPlay;
import online.kingdomkeys.kingdomkeys.client.gui.GuiHelper;
import online.kingdomkeys.kingdomkeys.client.gui.elements.MenuBackground;
import online.kingdomkeys.kingdomkeys.client.gui.elements.buttons.MenuButton;
import online.kingdomkeys.kingdomkeys.lib.Strings;
import online.kingdomkeys.kingdomkeys.util.Utils;

import java.awt.*;

public class CommandBoardMenu extends MenuBackground {

    MenuButton back, play;

    public enum actions {
        BACK,
        PLAY
    }

    public CommandBoardMenu() {
        super("gui.kkfinalmix.command_board_menu", new Color(50, 50, 0));
    }

    protected void action(actions act) {
        switch(act) {
            case BACK:
                GuiHelper.openMenu();
            case PLAY:
                //play board game
                PacketHandlerFM.sendToServer(new CSFMOpenBoardPlay());
        }
    }

    public void init() {
        addRenderableWidget(back = new MenuButton((int) buttonPosX, (int) buttonPosY, (int) buttonWidth, Utils.translateToLocal(Strings.Gui_Menu_Back), MenuButton.ButtonType.BUTTON, (e) -> action(actions.BACK)));
        addRenderableWidget(play = new MenuButton((int) buttonPosX, (int) buttonPosY + (1 * 18), (int) buttonWidth, Utils.translateToLocal("gui.kkfinalmix.command_board.play"), MenuButton.ButtonType.BUTTON, (e) -> action(actions.PLAY)));
    }
}
