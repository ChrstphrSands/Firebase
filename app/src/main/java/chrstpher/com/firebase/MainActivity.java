package chrstpher.com.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {

    private String FIREBASE_URL = "https://restaurante-web2.firebaseio.com/";
    private String FIREBASE_CHILD = "pedidos";
    EditText editText;
    Firebase firebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        editText = findViewById(R.id.editText);
        Firebase.setAndroidContext(this);
        firebase = new Firebase(FIREBASE_URL).child(FIREBASE_CHILD);
    }

    @OnClick(R.id.button)
    public void escribirFirebase(){
        firebase.setValue(editText.getText().toString());
        editText.setText("");
    }
}
