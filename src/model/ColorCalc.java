/**
 * @author Stadler Andre
 * @version 21.1.2021
 */
package model;
import javafx.fxml.FXML;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class ColorCalc {

    public static void main(String[] args) {
        int select;
        boolean quit = true;
        ColorCalc calc = new ColorCalc();

        while(quit)
        {
            Scanner s = new Scanner(System.in);
            menu();
            try
            {
                select = Integer.parseInt(s.next());
            }
            catch (Exception e)
            {
                System.out.println("Wrong Input!");
                break;
            }
            switch (select)
            {
                case 1:
                    System.out.println("Change Color Via Absolute Value:");
                    try
                    {
                        System.out.println("red:");
                        calc.changeColorViaAbsoluteValue(ColorCode.RED, Integer.parseInt(s.next()));
                        System.out.println("green:");
                        calc.changeColorViaAbsoluteValue(ColorCode.GREEN, Integer.parseInt(s.next()));
                        System.out.println("blue:");
                        calc.changeColorViaAbsoluteValue(ColorCode.BLUE, Integer.parseInt(s.next()));
                    }
                    catch (Exception e)
                    {
                        System.out.println("Wrong Input Value!");
                        break;
                    }
                    System.out.println(calc.toString());
                    break;
                case 2:
                    System.out.println("Change Color Via Relative Value:");
                    try
                    {
                        System.out.println("red:");
                        calc.changeColorViaRelativValue(ColorCode.RED, Integer.parseInt(s.next()));
                        System.out.println("green:");
                        calc.changeColorViaRelativValue(ColorCode.GREEN, Integer.parseInt(s.next()));
                        System.out.println("blue:");
                        calc.changeColorViaRelativValue(ColorCode.BLUE, Integer.parseInt(s.next()));
                    }
                    catch (Exception e)
                    {
                        System.out.println("Wrong Input Value!");
                        break;
                    }
                    break;
                case 3:
                    System.out.println(calc.toString() + "\n HexCode: " + calc.getHex());
                    break;
                case 4:
                    System.out.println("*left*");
                     quit =false;
                    break;
                default:
                    System.out.println("not a valid operation");
                    break;
            }

        }
    }

    private ModularCounter red;
    private ModularCounter green;
    private ModularCounter blue;


    public ColorCalc()
    {
        red = new ModularCounter(256);
        green = new ModularCounter(256);
        blue = new ModularCounter(256);
    }

    public static void menu()
    {
        System.out.printf("\nMenu:\n" +
                            "1 - change Color Via Absolute Value\n" +
                            "2 - change Color Via Relative Value\n" +
                            "3 - View Colorcode\n" +
                            "4 - Quit\n");
    }

    public void changeColorViaAbsoluteValue(ColorCode cc, String value)
    {
        int Value = 0;
        try {
            Value = Integer.parseInt(value);
            switch (cc) {
                case RED:
                    red.update(Value - getRed());
                    break;
                case BLUE:
                    blue.update(Value - getBlue());
                    break;
                case GREEN:
                    green.update(Value - getGreen());
                    break;
            }
        }
        catch (Exception e)
        {
            System.out.println("Exeption at last change!\n");
        }
    }

    public void changeColorViaAbsoluteValue(ColorCode cc, int value)
    {
        switch (cc)
        {
            case RED:
                red.update(value - getRed());
                break;
            case BLUE:
                blue.update(value - getBlue());
                break;
            case GREEN:
                green.update(value - getGreen());
                break;
        }
    }

    public void changeColorViaRelativValue(ColorCode cc, String value)
    {
        int Value = 0;
        try{
            Value = Integer.parseInt(value);
            switch (cc)
            {
                case RED:
                    red.update(Value);
                    break;
                case BLUE:
                    blue.update(Value);
                    break;
                case GREEN:
                    green.update(Value);
                    break;
            }
        }
        catch (Exception e)
        {
            System.out.println("Fehler beim Anwenden der letzten Änderung");
        }
    }

    public void changeColorViaRelativValue(ColorCode cc, int value)
    {
        switch(cc)
        {
            case RED:
                red.update(value);
                break;
            case BLUE:
                blue.update(value);
                break;
            case GREEN:
                green.update(value);
                break;
        }
    }

    public int getRed()
    {
        return red.getValue();
    }

    public int getGreen()
    {
        return green.getValue();
    }

    public int getBlue()
    {
        return blue.getValue();
    }

    public String getHex()
    {
        String hex = "#";
        if (getRed() < 16)
            hex += "0" + Integer.toHexString(getRed());
        else
            hex += Integer.toHexString(getRed());
        if(getGreen() < 16)
            hex += "0" + Integer.toHexString(getGreen());
        else
            hex += Integer.toHexString(getGreen());
        if(getBlue() < 16)
            hex += "0" + Integer.toHexString(getBlue());
        else
            hex += Integer.toHexString(getBlue());
        return hex;
    }

    @Override
    public String toString() {
        return "Colors:" + "\n red: " + getRed() +
                "\n green: " + getGreen() + "\n blue: " + getBlue();
    }


}
