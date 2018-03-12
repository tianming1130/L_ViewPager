package cn.zknu.l_viewpager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnVP1,btnVP2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnVP1=(Button)findViewById(R.id.btn_vp1);
        btnVP2=(Button)findViewById(R.id.btn_vp2);

        btnVP1.setOnClickListener(this);
        btnVP2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_vp1:
                startActivity(new Intent(this,VP1Activity.class));
                break;
            case R.id.btn_vp2:
                startActivity(new Intent(this,VP2Activity.class));
                break;
        }
    }
}
