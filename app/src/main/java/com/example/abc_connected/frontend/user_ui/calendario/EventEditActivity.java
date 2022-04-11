package com.example.abc_connected.frontend.user_ui.calendario;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.abc_connected.R;

import java.time.LocalTime;

public class EventEditActivity extends AppCompatActivity
{
    private EditText eventNameET;
    private TextView eventDateTV, eventTimeTV;

    private LocalTime time;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_edit);
        initWidgets();
        time = LocalTime.now();
        eventDateTV.setText("Date: " + com.example.abc_connected.frontend.user_ui.calendario.CalendarUtils.formattedDate(com.example.abc_connected.frontend.user_ui.calendario.CalendarUtils.selectedDate));
        eventTimeTV.setText("Time: " + com.example.abc_connected.frontend.user_ui.calendario.CalendarUtils.formattedTime(time));
    }

    private void initWidgets()
    {
        eventNameET = findViewById(R.id.eventNameET);
        eventDateTV = findViewById(R.id.eventDateTV);
        eventTimeTV = findViewById(R.id.eventTimeTV);
    }

    public void saveEventAction(View view)
    {
        String eventName = eventNameET.getText().toString();
        com.example.abc_connected.frontend.user_ui.calendario.Event newEvent = new com.example.abc_connected.frontend.user_ui.calendario.Event(eventName, com.example.abc_connected.frontend.user_ui.calendario.CalendarUtils.selectedDate, time);
        com.example.abc_connected.frontend.user_ui.calendario.Event.eventsList.add(newEvent);
        finish();
    }
}