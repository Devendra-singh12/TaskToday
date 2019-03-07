package singh.devendra.tasktoday;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Success extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        textView=findViewById(R.id.textView);
        SharedPreferences sharedPreferences=getSharedPreferences("singh.devendra.tasktoday", MODE_PRIVATE);
        String s_user=sharedPreferences.getString("user","user");
        textView.setText(s_user);
    }

}
