package com.nix.block;

import com.nix.exception.WrongDateException;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class CheckDate implements Block {
    private static Scanner in = new Scanner(System.in);

    @Override
    public void run() throws WrongDateException {
        String[] dataArr;
        String data;

        int day;
        int month;

        System.out.println("Введите дату формата дд.ММ (02.12): ");
        data = in.next();
        log.debug("Date entered: " + data);

        if (data.isBlank()) {
            throw new WrongDateException("Дата не представлена", data);
        }

        if (!data.contains(".")  ) {
            throw new WrongDateException("Дата должна быть в формате дд.ММ (02.12)", data);
        }

        dataArr = data.split("\\.");
        if (!dataArr[0].matches("[\\d]+") || !dataArr[1].matches("[\\d]+")) {
            throw new WrongDateException("Дата содержит буквы", data);
        }

        day = Integer.parseInt(dataArr[0]);
        month = Integer.parseInt(dataArr[1]);

        if (!checkDaysInMonth(day, month)) {
            throw new WrongDateException("Дата введена неккоректно", data);
        }

        log.debug("Date verification completed successfully");
    }

    private boolean checkDaysInMonth(int d, int m) {
        if (m < 1 || m > 12 || d < 1 || d > 31)
            return false;

        switch (m) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return true;
            case 4:
            case 6:
            case 9:
            case 11:
                if (d > 30) {
                    return false;
                }
            case 2:
                if (d > 28) {
                    return false;
                }
        }
        return true;
    }

}
