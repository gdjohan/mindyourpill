package com.project.mindyourpillnew.database;

import com.project.mindyourpillnew.entity.Reminder;

import java.util.ArrayList;

public class LocalDatabase {
    private ArrayList<Reminder> reminders = new ArrayList<>();


    public LocalDatabase() {
        initReminders();
    }

    public ArrayList<Reminder> getReminders() {
        return reminders;
    }

    public void initReminders() {
        reminders.add(new Reminder("Paracetamol", "12:33", 8, 24, "After Meal"));
        reminders.add(new Reminder("Candesartan 16 mg", "21:00", 8, 12, "After Meal"));
        reminders.add(new Reminder("Amlodipine 10 mg", "12:00", 8, 12, "After Meal"));
    }

    public void addReminder(String medName, String startTime, int amount, int interval, String direction) {
        Reminder newReminder = new Reminder(medName, startTime, amount, interval, direction);
        reminders.add(newReminder);
    }

}
