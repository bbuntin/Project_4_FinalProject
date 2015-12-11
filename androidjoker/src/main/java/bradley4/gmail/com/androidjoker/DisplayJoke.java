package bradley4.gmail.com.androidjoker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DisplayJoke extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);

        String newJoke = "";
        if (savedInstanceState == null){
            Bundle extras = getIntent().getExtras();
            if(extras == null){
                newJoke = "";
            }else{
                newJoke = extras.getString(getString(R.string.PassingJokeExtra));
            }
        }
        TextView textView = (TextView) this.findViewById(R.id.joke_text);
        textView.setText(newJoke);
    }
}
