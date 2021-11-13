package com.nagy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.ResourceBundle;

public class DateApplication {

        PrintWriter pw = new PrintWriter(System.out, true);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Locale currentLocale = Locale.US;
        ResourceBundle messages = ResourceBundle.getBundle("messages", Locale.US);

        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter df;

        public void run() {
            String line = "";

            while(!(line.equals("q"))) {
                this.printMenu();
                try {
                    line = this.br.readLine();
                } catch (IOException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                switch(line) {
                    case "1":
                        this.setEnglish();
                        break;
                    case "2":
                        this.setFrench();
                        break;
                    case "3":
                        this.setKorean();
                        break;
                    case "4":
                        this.setJavanese();
                        break;

                }
            }
        }

        public void printMenu() {
            pw.println("=== " + messages.getString("appTitle") + " ===");

            // Print a Full Date
            this.df = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(currentLocale);
            pw.println(messages.getString("date1") + ": " + today.format(df));
            // Print a Long Date
            this.df = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).withLocale(currentLocale);
            pw.println((messages.getString("date2") + ": " + today.format(df)));

            // Print a Medium Date
            this.df = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(currentLocale);
            pw.println((messages.getString("date3") + ": " + today.format(df)));

            // Print a Short Date
            this.df = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(currentLocale);
            pw.println((messages.getString("date4") + ": " + today.format(df)));

            // Print a Medium Date/Time
            this.df = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(currentLocale);
            pw.println((messages.getString("date5") + ": " + today.format(df)));

            // Print a Medium Time
            this.df = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).withLocale(currentLocale);
            pw.println((messages.getString("date6") + ": " + today.format(df)));


            pw.println("\n--- " + messages.getString("menuTitle") + " ---");
            pw.println("1. " + messages.getString("menu1"));
            pw.println("2. " + messages.getString("menu2"));

            // Add 1 or 2 more menu items
            pw.println("3. " + messages.getString("menu3"));
            pw.println("4. " + messages.getString("menu4"));

            pw.println("q. " + messages.getString("menuq"));
            System.out.print(messages.getString("menucommand") + ": ");
        }

        public void setEnglish() {
            // Set currentLocale
            currentLocale = Locale.US;
            // Set messages
            messages = ResourceBundle.getBundle("messages", currentLocale);
        }

        public void setFrench() {
            // Set currentLocale
            currentLocale = Locale.FRANCE;
            // Set messages
            messages = ResourceBundle.getBundle("messages", currentLocale);
        }
    // Add 1 or 2 more setter methods
        public void setKorean() {
            // Set currentLocale
            currentLocale = Locale.KOREA;
            // Set messages
            messages = ResourceBundle.getBundle("messages", currentLocale);
        }

    public void setJavanese() {
        // Set currentLocale
        currentLocale = new Locale("jv", "INDONESIA");
        // Set messages
        messages = ResourceBundle.getBundle("messages", currentLocale);
    }


    }


