package net.llm.block.custom.screen;

import net.minecraft.screen.ScreenHandlerType;

public class ModScreenHandlers {
    public static ScreenHandlerType<CleaningTableScreenHandler> CLEANING_TABLE_SCREEN_HANDLER;

    public static void registerAllScreenHandlers() {
        CLEANING_TABLE_SCREEN_HANDLER = new ScreenHandlerType<>(CleaningTableScreenHandler::new);
    }
}