package singh.devendra.tasktoday;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText user,pass;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.editTextMail);
        pass = findViewById(R.id.editTextPass);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("singh.devendra.tasktoday", MODE_PRIVATE);
                String s_user = sharedPreferences.getString("user", "user");
                String s_pass = sharedPreferences.getString("pass", "any");

                if (s_user.equals(user.getText().toString()) && s_pass.equals(pass.getText().toString()))
                    startActivity(new Intent(MainActivity.this, Success.class));
                else
                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences=getSharedPreferences("singh.devendra.tasktoday",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("user","devendra.singh_mca18@gla.ac.in");
        editor.putString("pass","123456");
        editor.apply();
    }
}



