package com.example.tvapplication.slice;

import com.example.tvapplication.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.colors.RgbColor;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.components.Text;
import ohos.agp.components.element.ShapeElement;
import ohos.agp.utils.Color;

public class MainAbilitySlice extends AbilitySlice {

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_main_layout);

        //text动态赋值
        Text text=(Text)this.findComponentById(ResourceTable.Id_txt);
        if(text!=null){
            text.setText("Main");
            text.setTextColor(Color.RED);
        }

        //button转发并传值
        Button btn=(Button)this.findComponentById(ResourceTable.Id_btn);
        if(btn!=null){
            btn.setClickedListener(new Component.ClickedListener() {
                @Override
                public void onClick(Component component) {
                    //present(new ListAbilitySlice(),new Intent());
                    ShapeElement element=new ShapeElement();
                    element.setRgbColor(new RgbColor(0,255,0));
                    btn.setBackground(element);
                    //present(new ListAbilitySlice(),new Intent());
                    Intent intent=new Intent();
                    intent.setParam("data","success");
                    present(new ListAbilitySlice(),intent);
                }
            });
        }

        recovery();
        fastboot();
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
    /*
        恢复模式
     */
    public void recovery(){
        Button btn=(Button)this.findComponentById(ResourceTable.Id_recoverybtn);
        if(btn !=null){
            btn.setClickedListener(new Component.ClickedListener() {
                @Override
                public void onClick(Component component) {
                    //present(new ListAbilitySlice(),new Intent());
                    Intent intent=new Intent();
                    intent.setAction("action.system.recovery");
                    intent.setParam("data","恢复模式");
                    startAbility(intent);
                }
            });
        }
    }

    /*
        工程模式
     */
    public void fastboot(){
        Button btn=(Button)this.findComponentById(ResourceTable.Id_fastbootbtn);
        if(btn !=null){
            btn.setClickedListener(new Component.ClickedListener() {
                @Override
                public void onClick(Component component) {
                    //present(new ListAbilitySlice(),new Intent());
                    Intent intent=new Intent();
                    intent.setAction("action.system.fastboot");
                    intent.setParam("data","工程模式");
                    startAbility(intent);
                }
            });
        }
    }
}
