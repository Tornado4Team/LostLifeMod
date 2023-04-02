package net.llm.block.custom.screen;

import net.minecraft.screen.ScreenHandlerType;

public class ModScreenHandlers {
    public static ScreenHandlerType<CleaningTableScreenHandler> CLEANING_TABLE_SCREEN_HANDLER;
    public static ScreenHandlerType<AnalyserScreenHandler> ANALYSER_SCREEN_HANDLER;
    public static ScreenHandlerType<ExtractorScreenHandler> EXTRACTOR_SCREEN_HANDLER;
    public static ScreenHandlerType<SynthetiserScreenHandler> SYNTHETISER_SCREEN_HANDLER;

    public static void registerAllScreenHandlers() {
        CLEANING_TABLE_SCREEN_HANDLER = new ScreenHandlerType<>(CleaningTableScreenHandler::new);
        ANALYSER_SCREEN_HANDLER = new ScreenHandlerType<>(AnalyserScreenHandler::new);
        EXTRACTOR_SCREEN_HANDLER = new ScreenHandlerType<>(ExtractorScreenHandler::new);
        SYNTHETISER_SCREEN_HANDLER = new ScreenHandlerType<>(SynthetiserScreenHandler::new);
    }
}