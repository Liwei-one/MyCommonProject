package com.compro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.compro.RNPage.MyReactActivity;
import com.compro.bo.GoodsBo;
import com.compro.entity.GoodsPriceListData;
import com.compro.httphelp.NewResultCallBack;
import com.konggeek.android.geek.http.Result;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
            }
        });

        findViewById(R.id.go_rn_act).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,MyReactActivity.class));
            }
        });
    }
    private void getData(){
        GoodsBo.goodsGoldPriceList(new NewResultCallBack() {
            @Override
            public void onSuccess(int what, Result result) {
                if(result.isSuccess()){
                    List<GoodsPriceListData> data=result.getListObj(GoodsPriceListData.class);
                    System.out.println(data.size());
                }
            }
        });
    }
}
