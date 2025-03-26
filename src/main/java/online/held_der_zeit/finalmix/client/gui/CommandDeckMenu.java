package online.held_der_zeit.finalmix.client.gui;

import online.held_der_zeit.finalmix.network.PacketHandlerFM;
import online.held_der_zeit.finalmix.network.cts.CSFMOpenDeckEdit;
import online.held_der_zeit.finalmix.network.cts.CSFMOpenDeckList;
import online.held_der_zeit.finalmix.network.cts.CSFMOpenDeckMelding;
import online.held_der_zeit.finalmix.network.cts.CSFMOpenDeckSelection;
import online.kingdomkeys.kingdomkeys.client.gui.GuiHelper;
import online.kingdomkeys.kingdomkeys.client.gui.elements.MenuBackground;
import online.kingdomkeys.kingdomkeys.client.gui.elements.buttons.MenuButton;
import online.kingdomkeys.kingdomkeys.lib.Strings;
import online.kingdomkeys.kingdomkeys.util.Utils;

import java.awt.*;

public class CommandDeckMenu extends MenuBackground {

    MenuButton back, edit, selection, melding, list;

    public CommandDeckMenu() {
        super("gui.kkfinalmix.command_deck.menu", new Color(0,50,0));
    }

     protected void action(String act) {
         switch(act) {
             case "back":
                 GuiHelper.openMenu();
             case "edit":
                 //deck edit menu
                 PacketHandlerFM.sendToServer(new CSFMOpenDeckEdit());
             case "selection":
                 //deck selection & rename menu
                 PacketHandlerFM.sendToServer(new CSFMOpenDeckSelection());
             case "melding":
                 //command melding
                 PacketHandlerFM.sendToServer(new CSFMOpenDeckMelding());
             case "list":
                 //command list
                 PacketHandlerFM.sendToServer(new CSFMOpenDeckList());
         }
     }

     public void init() {
         addRenderableWidget(back = new MenuButton((int) buttonPosX, (int) buttonPosY, (int) buttonWidth, Utils.translateToLocal(Strings.Gui_Menu_Back), MenuButton.ButtonType.BUTTON, (e) -> action("back")));
         addRenderableWidget(edit = new MenuButton((int) buttonPosX, (int) buttonPosY + (1 * 18), (int) buttonWidth, Utils.translateToLocal("gui.kkfinalmix.command_deck.edit"), MenuButton.ButtonType.BUTTON, (e) -> action("edit")));
         addRenderableWidget(melding = new MenuButton((int) buttonPosX, (int) buttonPosY + (2 * 18), (int) buttonWidth, Utils.translateToLocal("gui.kkfinalmix.command_deck.melding"), MenuButton.ButtonType.BUTTON, (e) -> action("melding")));
         addRenderableWidget(selection = new MenuButton((int) buttonPosX, (int) buttonPosY + (3 * 18), (int) buttonWidth, Utils.translateToLocal("gui.kkfinalmix.command_deck.selection"), MenuButton.ButtonType.BUTTON, (e) -> action("selection")));
         addRenderableWidget(list = new MenuButton((int) buttonPosX, (int) buttonPosY + (4 * 18), (int) buttonWidth, Utils.translateToLocal("gui.kkfinalmix.command_deck.list"), MenuButton.ButtonType.BUTTON, (e) -> action("list")));
     }
}
