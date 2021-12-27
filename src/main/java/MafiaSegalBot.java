import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class MafiaSegalBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "MafiaSegalBot";
    }

    @Override
    public String getBotToken() {
        return "5023965922:AAGKMzd3mqOSlR9LHre44cs-KNCRwdEnvhI";
    }

    @Override
    public void onUpdateReceived(Update update) {
        String chatID = update.getMessage().getChatId().toString();
        String command = update.getMessage().getText();
        SendMessage MSG = new SendMessage();
        String[] split = command.split("\n");
        int size = split.length;
        Set<Integer> set = new LinkedHashSet<>();
        while (set.size() < size) {
            Random random = new Random();
            Integer i = random.nextInt(size);
            set.add(i);
        }
        int j = 0;
        String[] out = new String[size];
        for (Integer i : set) {
            out[j++] = split[i];

        }
        int t = 1;
        StringBuilder text = new StringBuilder();
        text.append("⚔مافیا سـگال⚔\n• رندوم نقش\u200Cها:\n");
        for (String output : out) {
            text.append(t++).append(". ").append(output).append("\n");
        }
        MSG.setChatId(chatID);
        MSG.setText(String.valueOf(text));
        try {
            execute(MSG);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
