package ua.javarush;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static ua.javarush.TelegramBotContent.*;
import static ua.javarush.TelegramBotUtils.*;

public class MyFirstTelegramBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "stunnerboyone_jru_bot";
    }

    @Override
    public String getBotToken() {
        return "6832743068:AAFqgjTVrMOW_jaRwbzOMVpAa58ygOw5kf8";
    }

    @Override
    public void onUpdateReceived(Update update) {
        Long chatId = getChatId(update);

        if(update.hasMessage() && update.getMessage().getText().equals("/start")) {
            SendMessage message = createMessage(chatId, "Hi Developer!");
            sendApiMethodAsync(message);
        }

        if(update.hasMessage() && update.getMessage().getText().contains("привіт")) {
            SendMessage message = createMessage(chatId, "Привіт, як тебе звуть?");
            sendApiMethodAsync(message);
        }

        if(update.hasMessage() && update.getMessage().getText().contains("мене звуть")) {
            SendMessage message = createMessage(chatId, "Радий знайомству, я — *Кіт*");
            sendApiMethodAsync(message);
        }
    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}