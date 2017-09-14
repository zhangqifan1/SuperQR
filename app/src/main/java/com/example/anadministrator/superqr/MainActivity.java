package com.example.anadministrator.superqr;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 请输入内容
     */
    private EditText mEtText;
    /**
     * 种瓜得瓜
     */
    private Button mButCreate0;
    /**
     * 种豆得豆
     */
    private Button mButCreate1;
    /**
     * 点石成金
     */
    private Button mButCreate2;
    /**
     * 指鹿为马
     */
    private Button mButCreate3;
    /**
     * 相由心生
     */
    private Button mButCreate4;
    /**
     * 望梅止渴
     */
    private Button mButCreate5;
    private ImageView mImage;

    private String pathXiGua = "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3837549912,2637268487&fm=27&gp=0.jpg";
    private String pathDou = "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=742722196,1936918902&fm=27&gp=0.jpg";
    private String pathJin = "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=569463890,1654348799&fm=27&gp=0.jpg";
    private String pathMa = "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1754709860,1595351849&fm=27&gp=0.jpg";
    private String pathXiang = "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3216390431,2469449241&fm=27&gp=0.jpg";
    private String pathMei = "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=4225776959,1178945115&fm=11&gp=0.jpg";
    /**
     * 老子能变5下
     */
    private TextView mTvColor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mEtText = (EditText) findViewById(R.id.etText);
        mButCreate0 = (Button) findViewById(R.id.butCreate0);
        mButCreate0.setOnClickListener(this);
        mButCreate1 = (Button) findViewById(R.id.butCreate1);
        mButCreate1.setOnClickListener(this);
        mButCreate2 = (Button) findViewById(R.id.butCreate2);
        mButCreate2.setOnClickListener(this);
        mButCreate3 = (Button) findViewById(R.id.butCreate3);
        mButCreate3.setOnClickListener(this);
        mButCreate4 = (Button) findViewById(R.id.butCreate4);
        mButCreate4.setOnClickListener(this);
        mButCreate5 = (Button) findViewById(R.id.butCreate5);
        mButCreate5.setOnClickListener(this);
        mImage = (ImageView) findViewById(R.id.image);
        mTvColor = (TextView) findViewById(R.id.tvColor);
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }

        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }

    /**
     * 方法2:图片和二维码混到一起
     * 方法3:bitmap作为背景图
     * 方法4:比第二种更乱一点
     * 方法5:图片正中央
     * 方法6:三个角的颜色不一样
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.butCreate0://种瓜得瓜
                mImage.setImageBitmap(QRCode.createQRCodeWithLogo2(pathXiGua, 500, drawableToBitmap(getResources().getDrawable(R.drawable.xigua))));
                mTvColor.setBackgroundColor(Color.RED);
                break;
            case R.id.butCreate1://种豆得豆
                mImage.setImageBitmap(QRCode.createQRCodeWithLogo3(pathDou, 500, drawableToBitmap(getResources().getDrawable(R.drawable.dou))));
                mTvColor.setBackgroundColor(Color.YELLOW);
                break;
            case R.id.butCreate2://点石成金
                mTvColor.setBackgroundColor(Color.GRAY);
                mImage.setImageBitmap(QRCode.createQRCodeWithLogo4(pathJin, 500, drawableToBitmap(getResources().getDrawable(R.drawable.jin))));
                break;
            case R.id.butCreate3://指鹿为马
                mTvColor.setBackgroundColor(Color.WHITE);
                mImage.setImageBitmap(QRCode.createQRCodeWithLogo6(pathMa, 500, drawableToBitmap(getResources().getDrawable(R.drawable.ma))));
                break;
            case R.id.butCreate4://正常
                String edString = getEdString(mEtText);
                if (edString == null) {
                    Toast.makeText(MainActivity.this, "空了,亲~", Toast.LENGTH_SHORT).show();
                    return;
                }
                mTvColor.setBackgroundColor(Color.GREEN);
                mImage.setImageBitmap(QRCode.createQRCode(edString));
                break;
            case R.id.butCreate5://望梅止渴
                mTvColor.setBackgroundColor(Color.BLUE);
                mImage.setImageBitmap(QRCode.createQRCodeWithLogo5(pathMei, 500, drawableToBitmap(getResources().getDrawable(R.drawable.meinv))));
                break;
        }
    }

    public String getEdString(EditText editText) {
        String s = editText.getText().toString();
        if (s != null && !s.equals("")) {
            return s;
        }
        return null;
    }
}
